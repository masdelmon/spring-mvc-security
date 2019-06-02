package com.journaldev.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.exception.SpringException;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	
	public String home(Locale locale, Model model) throws Exception  {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		throw new SpringException("Simulazione di exception...");
		
		//return "home";
	}
	
	@ExceptionHandler(SpringException.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/spring_error");
		model.addObject("errMsg", "this is SpringException.class");

		return model;

	}
	
	@RequestMapping(value = "/emp/get/{id}", method = RequestMethod.GET)
	public String getEmployee(Locale locale, Model model,@PathVariable("id") int id) {
		logger.info("Welcome user! Requested Emp ID is: "+id);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("id", id);
		model.addAttribute("name", "Pankaj");
		
		return "employee";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model){
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(){
		return "logout";
	}
	
	@RequestMapping(value="/denied")
	public String denied(){
		return "denied";
	}
}
