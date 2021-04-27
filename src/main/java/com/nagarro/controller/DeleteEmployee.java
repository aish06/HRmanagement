package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nagarro.models.Employee;
import com.nagarro.util.RestCalls;

@Controller
public class DeleteEmployee 
{
	//API for deleting employee
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int code,@RequestParam String user,Model mv,HttpServletRequest request,HttpServletResponse response) throws JsonMappingException, JsonProcessingException
	{
		RestCalls.deleteEmployee(code);
		
		mv.addAttribute("user",user);
		return "redirect:employees";

	}
}
