package it.flare.ddd.dao;

import org.springframework.data.jpa.repository.Query;

import it.flare.ddd.domain.User;

public interface UserDAO {

	
	public User findUserByName(String name);
	
}
