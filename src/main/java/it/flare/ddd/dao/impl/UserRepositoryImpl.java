package it.flare.ddd.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.flare.ddd.dao.UserDAO;
import it.flare.ddd.dao.UserRepository;
import it.flare.ddd.domain.User;
import it.flare.ddd.exception.AppException;

//a custom dao
//just a test not really necessary
public class UserRepositoryImpl implements UserDAO {
	
	@PersistenceContext
	EntityManager manager;
	@Inject
	UserRepository repo;
	
	@Override
	public List<User> findUserByName(String name) {
		
		// TODO Auto-generated method stub
		TypedQuery<User> q= manager.createQuery("from user u where u.username like :name",User.class).setParameter("name", "%"+name+"%");
		return  q.getResultList();
		//if(list.size()>1) throw 
		//	new AppException(11,"NOT_UNIQ");
		//if(list.isEmpty()) throw 
		//new AppException(10,"USER_NOT_FOUND");
		
		
	}

}
