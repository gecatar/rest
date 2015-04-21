package com.sirma.itt.train;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Add and remove users from database.
 * @author estefanov
 *
 */
@Singleton
public class UserRegister {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Add users in database.
	 */
	public String register(String username){
		if(isUsernameFree(username)){
			User user = new User();
			user.setUsername(username);
			user.setAddresses(new ArrayList<String>());
			entityManager.persist(user);
			return "user "+ username +" registered!!!";
		}
		return "username is bisy";
	}
	
	/**
	 * Remove user from database.
	 */
	public String remove(String username){
		StringBuilder operationResult = new StringBuilder();
		TypedQuery<User> query = entityManager.createNamedQuery(
				"User with name", User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		for(User user:users){
			entityManager.remove(user);
			operationResult.append("User removed").append(" ");
		}
		return operationResult.toString().trim();
	}
	
	private boolean isUsernameFree(String username){
		TypedQuery<User> query = entityManager.createNamedQuery(
				"User with name", User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		return users.isEmpty();
	}
}
