package com.capgemini.competency.model;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Perform user related CRUD operations
 */
public interface UserInterface extends JpaRepository<User,Integer>{

	User findAllByUsername(String userName);

}
