package com.example.demo.popup;

import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class PopUpApplication implements WebMvcConfigurer{
	public void addViewController(ViewControllerRegistry registry) {
		registry.addViewController("/Home").setViewName("Home");
	}
	public static void main(String [] args) {
		SpringApplication.run(PopUpApplication.class, args); 
	}

}
