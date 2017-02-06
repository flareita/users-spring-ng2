package it.flare.ddd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import it.flare.ddd.domain.User;

public interface UserDAO {

	
	public List<User> findUserByName(String name);
	
}
