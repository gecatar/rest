package com.sirma.itt.train;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test correct adding and removing on users in database.
 * @author estefanov
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRegisterTest {

	@Mock
	TypedQuery<User> query;
	@Mock
	TypedQuery<String> nameQuery;

	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private UserRegister userRegister;
	
	/**
	 * Check correct adding on user in database when user name is free.
	 */
	@Test
	public void registerTest() {
		Mockito.when(
				entityManager.createNamedQuery("User with name", User.class))
				.thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(new ArrayList<User>());
		Assert.assertEquals("user test registered!!!", userRegister.register("test"));
		Mockito.verify(entityManager,Mockito.atLeastOnce()).persist(Mockito.any(User.class));
	}
	
	/**
	 * Check rejecting on request when user name is not free.
	 */
	@Test
	public void registerExsistingName(){
		Mockito.when(
				entityManager.createNamedQuery("User with name", User.class))
				.thenReturn(query);
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User());
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals("username is bisy", userRegister.register("test"));
		Mockito.verify(entityManager,Mockito.never()).persist(Mockito.any(User.class));
	}

}
