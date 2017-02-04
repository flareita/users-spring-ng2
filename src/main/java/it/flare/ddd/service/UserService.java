package it.flare.ddd.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.flare.ddd.domain.User;


public interface UserService {

	public List<User> getUsers();
	
	public void editUser(User bo);
	public User findByName(String name);
	public void delete(Long id);
	
}
