package it.flare.ddd.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.flare.ddd.domain.User;


public interface UserService {

	public List<User> getUsers();
	public User  getUser(Long id);
	
	public User editUser(User bo);
	public List<User> findByName(String name);
	public Long delete(Long id);
	
}
