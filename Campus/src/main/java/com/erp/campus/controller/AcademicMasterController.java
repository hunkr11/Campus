package com.erp.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erp.campus.packages.model.academic.master.MasterCommonModel;


//@RequestMapping(value="/Campus/module/academic/master")


public class AcademicMasterController {
	
	@Autowired
	private MasterCommonModel masterCommonModel;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView defaultPage(){
		System.out.println(" \n AcademicMasterController DefaultPage");
		ModelAndView mav = new ModelAndView("/academic/admissionType/insAdmissionType","INS_ADMSN_TYP", masterCommonModel);
		return mav;		
	}
}
