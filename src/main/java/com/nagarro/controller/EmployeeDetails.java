package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nagarro.models.Employee;
import com.nagarro.util.RestCalls;

@Controller
public class EmployeeDetails 
{
	//API for getting list of all Employees
	@RequestMapping(value = "/employees")
	public String getAllEmployess(@RequestParam String user,HttpServletRequest request,HttpServletResponse response,Model mv) throws JsonMappingException, JsonProcessingException
	{
		List<Employee> empList = RestCalls.getAllEmployees();
		mv.addAttribute("empList",empList);
		mv.addAttribute("auth", "true");
		mv.addAttribute("user", user);
		return "employeedetails.jsp";
	}
}
