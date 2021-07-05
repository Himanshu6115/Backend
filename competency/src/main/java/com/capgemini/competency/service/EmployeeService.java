package com.capgemini.competency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.competency.model.EmployeeDetails;
import com.capgemini.competency.model.User;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeInterface empInt;
	
	public List<EmployeeDetails> listAll(){
		return empInt.findAll();
	}
	
	public void save(EmployeeDetails empDetails) {
		 empInt.save(empDetails);
	}
	
	public void saveAll(List<EmployeeDetails> empList) {
		
		empInt.saveAll(empList);
	}
	


}
