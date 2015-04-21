package com.sirma.itt.train;

import java.util.List;

public interface UserDao {

	public User getUser(String name);
	
	public List<User> getUsers();
	
}
