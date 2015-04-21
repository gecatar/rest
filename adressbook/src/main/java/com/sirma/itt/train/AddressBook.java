package com.sirma.itt.train;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Add and remove users and addresses.
 * @author estefanov
 *
 */
@Path("/")
public class AddressBook {
	
	@Inject
	private UserRegister userRegister;
	@Inject
	private AddressRegister addressRegister;
	
	/**
	 *Gets addresses for selected user. 
	 */
	@GET
	@Path("/addresses/{username}")
	public String getAddresses(@PathParam("username") String username){
		return addressRegister.getAddresses(username);
	}
	
	/**
	 * Add addresses for selected user.
	 */
	@PUT
	@Path("/addresses/{username}/{address}")
	public String addAddresses(@PathParam("username") String username,@PathParam("address") String address){
		return addressRegister.addAddress(username, address);
	}
	
	/**
	 * Remove all addresses assigned to selected user.
	 */
	@DELETE
	@Path("/addresses/{username}")
	public String removeAddresses(@PathParam("username") String username){
		return addressRegister.removeAddresses(username);
	}
	
	/**
	 * Register user.
	 */
	@PUT
	@Path("/users/{username}")
	public String registerUser(@PathParam("username") String username){
		return userRegister.register(username);
	}
	
	/**
	 * Delete user.
	 */
	@DELETE
	@Path("/users/{username}")
	public String removeUser(@PathParam("username") String username){
		return userRegister.remove(username);
	}
	
}
