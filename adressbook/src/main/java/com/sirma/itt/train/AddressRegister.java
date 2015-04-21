package com.sirma.itt.train;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Add and remove addresses from database.
 * 
 * @author estefanov
 *
 */
@Singleton
public class AddressRegister {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Add address.
	 */
	public String addAddress(String username, String address) {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"User with name", User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		for (User user : users) {
			user.getAddresses().add(address);
		}
		if (users.size() > 0) {
			return "address" + address + "for username:" + username + " added";
		}else{
			throw new UserException("There is no such user!!!");
		}
	}

	/**
	 * Gets addresses from database.
	 */
	public String getAddresses(String username) {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"User with name", User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		StringBuilder addressesString = new StringBuilder();
		for(User user:users){
			List<String> addresses = user.getAddresses();
			for(String addres:addresses){
				addressesString.append(addres).append(" ");
			}
		}
		return addressesString.toString();
	}

	/**
	 * Remove all addresses for selected user.
	 */
	public String removeAddresses(String username) {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"User with name", User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		StringBuilder resultString = new StringBuilder();
		for(User user:users){
			user.getAddresses().clear();
			resultString.append("addresses removed!!!").append(" ");
		}
		return resultString.toString().trim();
	}
}
