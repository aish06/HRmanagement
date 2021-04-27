package com.nagarro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.dao.HRDao;
import com.nagarro.dao.HRDaoImpl;
import com.nagarro.models.Employee;
import com.nagarro.models.HRModel;
import com.nagarro.util.RestCalls;

@Controller
public class Login
{
	//API for Login 
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response,Model mv) throws JsonMappingException, JsonProcessingException
	{
	//	ModelAndView mv=new ModelAndView();
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		HRDao hrDao=new HRDaoImpl();
		HRModel user=hrDao.getHRUser(userId, password);
		if(user==null)
		{
//			mv.setViewName("index.jsp");
//			mv.addObject("auth", "false");
			return "redirect:/";
		}
		else
		{
			mv.addAttribute("user", user.getFirstName());
			return "redirect:employees";
		}
		
//	//	return mv;
//		return redirectView;
		
	}
}