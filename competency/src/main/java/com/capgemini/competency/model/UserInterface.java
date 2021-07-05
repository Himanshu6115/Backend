package com.capgemini.competency.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User,Integer>{

	User findAllByUsername(String userName);

}
