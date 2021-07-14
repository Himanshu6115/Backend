package com.capgemini.competency.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.competency.model.EmployeeDetails;
import com.capgemini.competency.model.Response;
import com.capgemini.competency.model.User;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeInterface empInt;
	
	ArrayList<EmployeeDetails> details = new ArrayList();
	
	public List<EmployeeDetails> listAll(){
		return empInt.findAll();
	}
	
	public Response save(EmployeeDetails empDetails) {
		
		Response response = new Response();
		if(empInt.findById(empDetails.getGlobalId()) == null) {
			if(empInt.findByemailId(empDetails.getEmailId())== null) {
		       empInt.save(empDetails);
		       response.setMessage("Record Inserted Successfully");
		       response.setStatus("200,OK");
			}
			else {							
			   response.setMessage("Email Id already Exists!!");
	           response.setStatus("500,DB2 Error");
			}
		}	
		else {
			   response.setMessage("Global Id already Exists!!");
               response.setStatus("500,DB2 Error");
		}
		
		return response;
	}
	
/*	public void saveAll(List<EmployeeDetails> empList) {
	
		
		
		
		empInt.saveAll(empList);
	}
*/	
	
	public EmployeeDetails findById(int globalId) {
		return empInt.findById(globalId);
	}
	
	public List<EmployeeDetails> findAll(){
		
		return empInt.findAll();
	}
	
	
   public void	delete(int id) {
	   
	   empInt.deleteById(id);
   }
   
   public List<EmployeeDetails> getEmployeeDetails(){
		return empInt.findAll();
	}

	public void update(EmployeeDetails empDetail) {
		EmployeeDetails e2=empInt.findById(empDetail.getGlobalId());
		e2.setEmpName(empDetail.getEmpName());
		e2.setGender(empDetail.getGender());
		e2.setJobTitle(empDetail.getJobTitle());
		e2.setEmpSubGroup(empDetail.getEmpSubGroup());
		e2.setTimesheetComplaince(empDetail.getTimesheetComplaince());
		e2.setSupervisorName(empDetail.getSupervisorName());
		e2.setClientTeam(empDetail.getClientTeam());
		e2.setEmailId(empDetail.getEmailId());
		e2.setBaseLocation(empDetail.getBaseLocation());
		e2.setPersonalArea(empDetail.getPersonalArea());
		e2.setLocation(empDetail.getLocation());
		e2.setLocalId(empDetail.getLocalId());
		empInt.save(e2);
	}
	
	
	public List<EmployeeDetails> getNotApproved(String supervisorName) throws FileNotFoundException {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("D:\\competency project\\Sukesh_timesheet.csv"));
			br.readLine();
			details.clear();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if(supervisorName.equals(data[4]) && data[15].equals("Not Approved")) {
					//EmployeeDetails empdetails=empInt.getById(Integer.parseInt(data[0]));
					EmployeeDetails empdetails = empInt.findById(Integer.parseInt(data[0]));
					if(empdetails!=null)
					   details.add(empdetails);
					}
				}
			}
		catch(Exception ex) {
			System.out.println("file not found");
			
		}
		return details;
	}
	
	public ArrayList<EmployeeDetails> getNotSubmitted(String supervisorName) throws FileNotFoundException {
		try {
						
			BufferedReader br = new BufferedReader(new FileReader("D:\\competency project\\Sukesh_timesheet.csv"));
			br.readLine();
			details.clear();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if(supervisorName.equals(data[4]) && data[15].equals("Not Submitted")) {
					//EmployeeDetails empdetails=empInt.getById(Integer.parseInt(data[0]));
					EmployeeDetails empdetails = empInt.findById(Integer.parseInt(data[0]));
					if(empdetails!=null)
					   details.add(empdetails);
					}
				}
			}
		catch(Exception ex) {
			System.out.println("file not found");
			
		}
		return details;
	}
	
	public List<EmployeeDetails> getWeekDetails(String supervisorName) throws FileNotFoundException {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\competency project\\Sukesh_timesheet.csv"));
			br.readLine();
			details.clear();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if(supervisorName.equals(data[4]) && data[15].equals("Not Approved")) {
					//EmployeeDetails empdetails=empInt.getById(Integer.parseInt(data[0]));
					EmployeeDetails empdetails = empInt.findById(Integer.parseInt(data[0]));
					if(empdetails!=null)
					   details.add(empdetails);
					}
				if(supervisorName.equals(data[4]) && data[15].equals("Not Submitted")) {
					//EmployeeDetails empdetails=empInt.getById(Integer.parseInt(data[0]));
					EmployeeDetails empdetails = empInt.findById(Integer.parseInt(data[0]));
					if(empdetails!=null)
					   details.add(empdetails);
					}
				}
			}
		catch(Exception ex) {
			System.out.println("file not found");
			
		}
		return details;
		
	}
	
}
