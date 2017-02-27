package it.flare.ddd.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import it.flare.ddd.dto.UserDTO;


public interface UserFacade {

	public List<UserDTO> getUsers();
	public UserDTO getUser(Long id);
	public List<UserDTO> getUser(String name);
	public UserDTO editUser(UserDTO user);
	
	public Long deleteUser(Long id);
		
	
	
	
}
