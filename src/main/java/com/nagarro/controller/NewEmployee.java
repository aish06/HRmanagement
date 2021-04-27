package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Employee;
import com.nagarro.util.RestCalls;

@Controller
public class NewEmployee
{
	@RequestMapping(value="/newEmployee")
	public String newEmployee(@RequestParam String user,HttpServletRequest request,HttpServletResponse response,Model mv)
	{
		System.out.println(user);
		mv.addAttribute("user", user);
		return "newemployee.jsp";
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestParam String user,HttpServletRequest request,HttpServletResponse response,Model mv) throws JsonMappingException, JsonProcessingException
	{
		int code=Integer.parseInt(request.getParameter("code"));
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		
		//New Employee object
		Employee emp=new Employee(code,name,location,email,dob);
		RestCalls.addEmployee(emp);

		mv.addAttribute("user",user);
		return "redirect:employees";
	}
}

