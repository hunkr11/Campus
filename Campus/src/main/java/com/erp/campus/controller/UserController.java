package com.erp.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
//	private static final Logger logger = Logger.getLogger(UserController.class);	
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
    	return "home";
    }*/
	
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		System.out.println("\n\n --USER CONTROLLER STARTED-- \n\n");
		//return new ModelAndView("index");
		 return new ModelAndView("home");
	}
	
}
