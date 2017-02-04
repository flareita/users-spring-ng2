package it.flare.ddd.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import it.flare.ddd.domain.User;
import it.flare.ddd.dto.UserDTO;
import it.flare.ddd.exception.AppException;
import it.flare.ddd.exception.SystemException;
import it.flare.ddd.facade.UserFacade;
import it.flare.ddd.service.UserService;

@Service
public class UserFacadeImpl implements UserFacade{

	@Inject
	UserService userService;


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<UserDTO> getUsers() {
		try{
		List<User> bos = userService.getUsers();
		return bos.stream().map(x->x.toDTO(new UserDTO())).collect(Collectors.toList());
		}catch(AppException e){
			throw (e);
		}catch (Exception e){
			throw new SystemException(e);
		}	
	}


	@Override
	@Transactional(value = TxType.REQUIRED)
	public void editUser(UserDTO userDTO) {
		try{
		userService.editUser(new User().fromDTO(userDTO));
		}catch(AppException e){
			throw (e);
		}catch (Exception e){
			throw new SystemException(e);
		}
	}


	@Override
	public UserDTO getUser(String name) {
		try{
			return userService.findByName(name).toDTO(new UserDTO());
		}catch(AppException e){
			throw (e);
		}catch (Exception e){
			throw new SystemException(e);
		}
	}


	@Override
	@Transactional(value = TxType.REQUIRED)
	public void deleteUser(Long id) {
		try{
			 userService.delete(id);
		}catch(AppException e){
			throw (e);
		}catch (Exception e){
			throw new SystemException(e);
		}
	}




}
