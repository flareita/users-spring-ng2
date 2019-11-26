package it.flare.ddd.facade.impl;

import static java.util.stream.Collectors.toList;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;
import static javax.transaction.Transactional.TxType.REQUIRED;

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
public class UserFacadeImpl implements UserFacade {

	@Inject
	UserService userService;

	@Override
	@Transactional(value = NOT_SUPPORTED)
	public List<UserDTO> getUsers() {
		try {
			List<User> bos = userService.getUsers();
			return bos.stream().map(x -> x.toDTO(new UserDTO())).collect(toList());
		} catch (AppException e) {
			throw (e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Override
	@Transactional(value = REQUIRED)
	public UserDTO editUser(UserDTO userDTO) {
		try {
			return userService.editUser(new User().fromDTO(userDTO)).toDTO(new UserDTO());
		} catch (AppException e) {
			throw (e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Override
	public List<UserDTO> getUser(String name) {
		try {
			List<User> bos = userService.findByName(name);
			return bos.stream().map(x -> x.toDTO(new UserDTO())).collect(toList());
		} catch (AppException e) {
			throw (e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Override
	@Transactional(value = REQUIRED)
	public Long deleteUser(Long id) {
		try {
			return userService.delete(id);
		} catch (AppException e) {
			throw (e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Override
	public UserDTO getUser(Long id) {
		try {
			return userService.getUser(id).toDTO(new UserDTO());
		} catch (AppException e) {
			throw (e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

}
