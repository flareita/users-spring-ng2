package it.flare.ddd.service.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.flare.Application;
import it.flare.ddd.dao.UserRepository;
import it.flare.ddd.domain.User;
import it.flare.ddd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Inject
	UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
	
		return userRepository.findAll();
	}
	
	@Override
	public List<User> findByName(String name){
		return userRepository.findUserByName(name);
	}

	@Override
	public User editUser(User bo) {
		bo.setUpdateTS(new Timestamp(new Date().getTime()));
		return  userRepository.saveAndFlush(bo);
		
		
	}

	@Override
	public Long delete(Long id) {
		//optimistic
		User u=userRepository.findOne(id);
		  userRepository.delete(u);
		  return id;
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	
}
