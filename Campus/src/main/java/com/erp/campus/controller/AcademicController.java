package com.erp.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "module/academic")
public class AcademicController {
	
	@RequestMapping(value = "module/academic",method = RequestMethod.GET)
	public String academic(){
		System.out.println("ACADEMICS MODULE");
		return "academic/home";
	}
}
