package com.capgemini.competency.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.competency.model.EmployeeDetails;
import com.capgemini.competency.model.User;

public interface EmployeeInterface extends JpaRepository<EmployeeDetails , Integer>{
	
	EmployeeDetails findById(int globalId);

}
