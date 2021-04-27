package com.nagarro.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Employee;

public class RestCalls 
{
	//Rest Template to hit API of Employee Manager
	static private RestTemplate restTemplate=new RestTemplate();
	
	//Hits API to get list of Employees
	public static List<Employee> getAllEmployees() throws JsonMappingException, JsonProcessingException
	{
		String jsonEmpList=restTemplate.getForObject("http://localhost:8082/employees", String.class);
		ObjectMapper m=new ObjectMapper();
		
		List<Employee> empList = m.readValue(jsonEmpList, new TypeReference<List<Employee>>(){});
		
		return empList;
	}
	
	
	//Hits API to add new Employees
	public static void addEmployee(Employee emp)
	{
		restTemplate.postForLocation("http://localhost:8082/employee", emp);
	}
	
	//Hits API to get an Employee from employee code
	public static Employee getEmployee(int code)
	{
		Employee emp=restTemplate.getForObject("http://localhost:8082/employee/"+code, Employee.class);
		return emp;
	}
	
	//Hits API to update Employee with the following code
	public static void updateEmployee(Employee emp)
	{
		restTemplate.put("http://localhost:8082/employee",emp);
	}
	
	//Hits API to delete Employee with the following code
	public static void deleteEmployee(int code)
	{
		restTemplate.delete("http://localhost:8082/employee/"+code);
	}
}
