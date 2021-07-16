package com.capgemini.competency;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ch.qos.logback.classic.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import com.capgemini.competency.model.EmployeeDetails;
import com.capgemini.competency.model.Response;
import com.capgemini.competency.service.EmployeeInterface;
import com.capgemini.competency.service.EmployeeService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeInterface empInt;
	
	private Logger logger= (Logger) LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping("/insert")
	public Response addDetail(@RequestBody EmployeeDetails empDetail) {
		
		
		Response response=empService.save(empDetail);
	    return response;
		
	}
	
	@PostMapping("/addmultiple")
	public List<Response> addMultiple(@RequestBody List<EmployeeDetails> empAll) {
		
		List<Response> responseList = new ArrayList();
		
		for(EmployeeDetails empDetail: empAll)
		{
			Response response = empService.save(empDetail);	
			responseList.add(response);
		}
		
		return responseList;
		
	}
	
    @GetMapping("/allemployee")
    public List<EmployeeDetails> findAllEmployee(){
    	return empService.findAll();
    }
	
	@GetMapping("/{globalId}")
	public EmployeeDetails findEmployeebyId(@PathVariable("globalId") int globalId)
	{
		
		return empService.findById(globalId);
		
	}
	
	@GetMapping("/notApproved")
	public List<EmployeeDetails> getNotApproved(@RequestParam("supervisorName") String supervisorName) throws FileNotFoundException {
		
		List<EmployeeDetails> listEmp;
		
		listEmp = empService.getNotApproved(supervisorName);
		return listEmp;
		
	}
	
	@GetMapping("/notSubmitted")
	public List<EmployeeDetails> getNotSubmitted(@RequestParam("supervisorName") String supervisorName) throws FileNotFoundException {
		
		ArrayList<EmployeeDetails> listEmp= new ArrayList();
		
		listEmp = empService.getNotSubmitted(supervisorName);
		return listEmp;
		
	}
	
	//create a delete mapping that deletes a specified employee 
    @DeleteMapping("/delete")
    public void delete(@RequestParam int Id) {
        empService.delete(Id);
    }
	
	//create a update mapping that update the detail of a specific employee
	@PutMapping("/updateEmployee")
	 public void updateEmployeeDetails(@RequestBody EmployeeDetails empDetail)
	    {
			logger.info("Received update Request for specific employee");
	        empService.update(empDetail);  
	    }
}
