package it.flare.ddd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.flare.ddd.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,UserDAO{
	
}
