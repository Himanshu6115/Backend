package com.capgemini.competency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.competency.model.Response;
import com.capgemini.competency.model.User;
import com.capgemini.competency.model.UserInterface;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class LoginController {
	
	@Autowired
	UserInterface userInter;
	
	@RequestMapping("/")
	public String checkMVC()
	{
		return "Login";
	}
	
    @RequestMapping("/login")
	public Response loginHomePage(@RequestBody User loginDetails)
	{
		User u = null;
		Response response = new Response();
		try {
			u = userInter.findAllByUsername(loginDetails.getUsername());
			if(u!= null) {
				if(u.getPassword().equals(loginDetails.getPassword()))
				{					
					response.setStatus("success");
					response.setMessage("User got successfully login");
					return response;
				}
			}
		}
		catch(Exception ex) {
			System.out.println("username not found");
			
		}
		response.setStatus("fail");
		response.setMessage("username Or password is incorrect!!");
		System.out.println("Response "+response.getStatus());
		return response;
	}

}
