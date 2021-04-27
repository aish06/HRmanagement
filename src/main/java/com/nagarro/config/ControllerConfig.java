package com.nagarro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.nagarro.controller.*;

@Configuration
@ComponentScan({"com.nagarro.controller"})
public class ControllerConfig
{
	
}