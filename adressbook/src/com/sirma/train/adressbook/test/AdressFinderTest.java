package com.sirma.train.adressbook.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.train.adressbook.AdressFinder;
import com.sirma.train.adressbook.User;

@RunWith(MockitoJUnitRunner.class)
public class AdressFinderTest {

	@Mock
	TypedQuery<User> query;
	@Mock
	TypedQuery<String> nameQuery;

	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private AdressFinder adressFinder;

	@Test
	public void listUsersTest() {
		Mockito.when(
				entityManager.createNamedQuery("All users names", String.class))
				.thenReturn(nameQuery);
		List<User> users = new ArrayList<User>();
		users.add(new User("Test", null));
		users.add(new User("proba", null));
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals("Test proba", adressFinder.listUsers());
	}

	@Test
	public void getAddressesTest() {
		Mockito.when(
				entityManager.createNamedQuery("User with name", User.class))
				.thenReturn(query);

		Mockito.when(query.getResultList()).thenReturn(new ArrayList<User>());
		Assert.assertEquals("", adressFinder.getAdresses("sfds"));
		Mockito.verify(query, Mockito.atLeastOnce()).setParameter("name",
				"sfds");
	}

}
