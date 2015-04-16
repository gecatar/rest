package com.sirma.train.adressbook.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.train.adressbook.AdressBook;
import com.sirma.train.adressbook.AdressFinder;

@RunWith(MockitoJUnitRunner.class)
public class AdressBookTest {

	@Mock
	private AdressFinder adressFinder;
	@InjectMocks
	private AdressBook adressBook;

	@Test
	public void getAdressTest() {
		adressBook.getAdress("test");
		Mockito.verify(adressFinder, Mockito.atLeastOnce()).getAdresses("test");
	}

	@Test
	public void storeAdressTest() {
		adressBook.storeAdress("test", "adress");
		Mockito.verify(adressFinder, Mockito.atLeastOnce()).storeAdress("test",
				"adress");
	}

}
