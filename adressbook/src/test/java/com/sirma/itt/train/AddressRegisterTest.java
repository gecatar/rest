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

@RunWith(MockitoJUnitRunner.class)
public class AddressRegisterTest {

	@Mock
	TypedQuery<User> query;
	@Mock
	TypedQuery<String> nameQuery;

	@Mock
	private EntityManager entityManager;

	@InjectMocks
	AddressRegister addressRegister;

	@Test
	public void addAddressTest() {
		Mockito.when(
				entityManager.createNamedQuery("User with name", User.class))
				.thenReturn(query);
		ArrayList<User> users = new ArrayList<User>();
		User user = new User();
		user.setAddresses(new ArrayList<String>());
		users.add(user);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals("addressaddressfor username:test added",
				addressRegister.addAddress("test", "address"));
	}

}
