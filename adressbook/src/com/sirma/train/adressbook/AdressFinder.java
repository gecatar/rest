package com.sirma.train.adressbook;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Store and find addresses.
 * 
 * @author estefanov
 *
 */
@Stateless
public class AdressFinder {

	@PersistenceContext()
	private EntityManager entityManager;

	/**
	 * Store address to corresponding user.
	 * 
	 * @param name
	 * @param adress
	 */
	public void storeAdress(String name, String adress) {
		User user = new User();
		user.setName(name);
		List<String> adresses = new ArrayList<String>();
		adresses.add(adress);
		user.setAdresses(adresses);
		entityManager.persist(user);
	}

	/**
	 * List all users.
	 * 
	 * @return string with names on all users.
	 */
	public String listUsers() {
		TypedQuery<String> query = entityManager.createNamedQuery(
				"All users names", String.class);
		List<String> users = query.getResultList();
		StringBuilder adressesString = new StringBuilder();
		for (String name : users) {
			adressesString.append(name).append(" ");
		}
		return adressesString.toString().trim();
	}

	/**
	 * Gets addresses for user with selected name.
	 * 
	 * @param name
	 * @return
	 */
	public String getAdresses(String name) {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"User with name", User.class);
		query.setParameter("name", name);
		List<User> users = query.getResultList();
		StringBuilder adresses = new StringBuilder();
		for (User user : users) {
			adresses.append(user.getName()).append(" ");
			for (String adress : user.getAdresses()) {
				adresses.append(adress).append(" ");
			}
		}
		return adresses.toString();
	}
}
