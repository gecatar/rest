package com.sirma.train.adressbook;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
public class AdressBook {

	@EJB
	private AdressFinder adressFinder;

	@GET
	@Path("/{userName}")
	public String getAdress(@PathParam("userName") String userName) {
		return adressFinder.getAdresses(userName);
	}

	@PUT
	@Path("/{userName}/{adress}")
	public String storeAdress(@PathParam("userName") String fullName,
			@PathParam("adress") String adress) {
		adressFinder.storeAdress(fullName, adress);
		return fullName + " " + adress;
	}
}
