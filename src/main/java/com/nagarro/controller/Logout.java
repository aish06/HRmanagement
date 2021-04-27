package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout 
{
	//API for Logout
	@RequestMapping(value = "/Logout")
	public String logout(HttpServletRequest request,HttpServletResponse response, Model mv)
	{
		mv.addAttribute("user", null);
		return "redirect:/";
	}
}
