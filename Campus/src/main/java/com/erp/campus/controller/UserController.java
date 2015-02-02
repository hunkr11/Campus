package com.erp.campus.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	 public ModelAndView indexPage(){
		 System.out.println("\n\n -- UserController.indexPage -- \n\n");		 
		 return new ModelAndView("home");
	 }
}
