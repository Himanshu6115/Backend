package com.capgemini.competency.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.competency.model.EmployeeDetails;
import com.capgemini.competency.model.User;

@Repository
public interface EmployeeInterface extends JpaRepository<EmployeeDetails , Integer>{
	
	EmployeeDetails findById(int globalId);

	EmployeeDetails findByemailId(String emailId);

}
