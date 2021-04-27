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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Employee;
import com.nagarro.util.RestCalls;


@Controller
public class UpdateEmployee 
{
	//API for updating employee
	@RequestMapping("/updateEmployee")
	public String getEmployee(@RequestParam int code,@RequestParam String user,Model mv,HttpServletRequest request,HttpServletResponse response) throws JsonMappingException, JsonProcessingException
	{
		//Get Employee with the code
		Employee emp=RestCalls.getEmployee(code);
		mv.addAttribute("user",user);
		mv.addAttribute("empData", emp);
		return "edit.jsp";
	}
	
	@RequestMapping(value = "/updatedEmployee")
	public String updatedEmployee(@RequestParam int code,@RequestParam String user,Model mv,HttpServletRequest request,HttpServletResponse response) throws JsonMappingException, JsonProcessingException
	{
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		Employee emp=new Employee(code,name,location,email,dob);
		RestCalls.updateEmployee(emp);
		
		mv.addAttribute("user", user);
		return "redirect:employees";
	}
}
