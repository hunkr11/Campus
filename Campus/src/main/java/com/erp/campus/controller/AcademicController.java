package com.erp.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Campus/module/academic")
public class AcademicController {
	
	//@RequestMapping(value = "/module/academic",method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String academic(){
		System.out.println("ACADEMICS MODULE");
		return "academic/homeAcademic";
	}
	
	@RequestMapping(value="/admission",method=RequestMethod.GET)
	public ModelAndView admission(){
		System.out.println(" \n AcademicController ADMISSION ");
		ModelAndView mav = new ModelAndView("academic/admission");		
		return mav;
	}
}
