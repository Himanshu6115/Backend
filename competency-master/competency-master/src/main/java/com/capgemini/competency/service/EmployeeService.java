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
import com.capgemini.competency.model.User;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeInterface empInt;
	
    List<EmployeeDetails> details = new ArrayList<>();

	
	/*public List<EmployeeDetails> listAll(){
		return empInt.findAll();
	}
	*/
	
	public void save(EmployeeDetails empDetails) {
		 empInt.save(empDetails);
	}
	
	public void saveAll(List<EmployeeDetails> empList) {
		
		empInt.saveAll(empList);
	}
	
    public void delete(Integer Id) {
	empInt.deleteById(Id);
	} 
    
    public List<EmployeeDetails> getEmployeeDetails(){
		return empInt.findAll();
	}

    public EmployeeDetails findById(int globalId) {
        return empInt.findById(globalId);
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
   
    public List<EmployeeDetails> getNotSubmitted(String supervisorName) throws FileNotFoundException {
        try {
                       
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\4016115\\Desktop\\Surya.csv"));
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
}
