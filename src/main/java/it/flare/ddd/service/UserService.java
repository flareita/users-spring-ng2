package it.flare.ddd.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.flare.ddd.domain.User;


public interface UserService {

	public List<User> getUsers();
	public User  getUser(Long id);
	
	public void editUser(User bo);
	public List<User> findByName(String name);
	public void delete(Long id);
	
}
