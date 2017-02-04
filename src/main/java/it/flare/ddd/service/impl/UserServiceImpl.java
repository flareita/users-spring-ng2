package it.flare.ddd.service.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import it.flare.ddd.dao.UserRepository;
import it.flare.ddd.domain.User;
import it.flare.ddd.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
	
		return userRepository.findAll();
	}
	
	@Override
	public User findByName(String name){
		return userRepository.findUserByName(name);
	}

	@Override
	public void editUser(User bo) {
		bo.setUpdateTS(new Timestamp(new Date().getTime()));
		userRepository.saveAndFlush(bo);
		
	}

	@Override
	public void delete(Long id) {
		//optimistic
		User u=userRepository.findOne(id);
		 userRepository.delete(u);
	}
	
}
