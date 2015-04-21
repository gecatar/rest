package com.sirma.itt.train;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "All users names", query = "SELECT u.username FROM User as u"),
	@NamedQuery(name = "User with name", query = "SELECT u FROM User as u WHERE u.username = :username") })
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	
	private ArrayList<String> addresses;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<String> addresses) {
		this.addresses = addresses;
	}
}
