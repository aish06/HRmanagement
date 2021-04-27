package com.nagarro.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;
import com.nagarro.models.Employee;
import com.nagarro.pdfexport.NewPDF;
import com.nagarro.util.RestCalls;



@Controller
public class Pdf 
{
	//API for creating a pdf of list of employees
	@RequestMapping("/exportPdf")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException
	{
		 response.setContentType("application/pdf");
	     DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	     String currentDateTime = dateFormatter.format(new Date());
	      
	     String headerKey = "Content-Disposition";
	     String headerValue = "attachment; filename=employeeList_" + currentDateTime + ".pdf";
	     response.setHeader(headerKey, headerValue);
	       
	    
			
	     List<Employee> empList = RestCalls.getAllEmployees();
	     
	     NewPDF exporter = new NewPDF(empList);
	     exporter.export(response);
	     
	}
	
	
}
