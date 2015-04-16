package com.sirma.train.adressbook;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "All users names", query = "SELECT u.name FROM User as u"),
		@NamedQuery(name = "User with name", query = "SELECT u FROM User as u WHERE u.name = :name") })
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ElementCollection
	private List<String> adresses;

	private String name;

	public User() {

	}

	public User(String name, List<String> adresses) {
		this.name = name;
		this.adresses = adresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<String> adresses) {
		this.adresses = adresses;
	}

}
