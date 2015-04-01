package com.erp.campus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erp.campus.packages.model.academic.master.MasterCommonModel;
import com.erp.campus.packages.service.academic.MasterCommonService;

@Controller
@RequestMapping(value = "/Campus/module/academic")
public class AcademicController {

	@Autowired
	private MasterCommonModel masterCommonModel;
	
	@Autowired
	private MasterCommonService masterCommonService;

	@RequestMapping(method = RequestMethod.GET)
	public String academic() {
		System.out.println("ACADEMICS MODULE");
		return "academic/homeAcademic";
	}

	@RequestMapping(value = "/admission", method = RequestMethod.GET)
	public ModelAndView admission() {
		System.out.println(" \n AcademicController ADMISSION ");
		ModelAndView mav = new ModelAndView("academic/admission");
		return mav;
	}

	@RequestMapping(value = "/master/admissionType", method = RequestMethod.GET)
	public ModelAndView admissionType() {
		System.out.println(" \n AcademicMasterController admissionType");
		ModelAndView mav = new ModelAndView(
				"academic/admissionType/insAdmissionType", "INS_ADMSN_TYP",
				masterCommonModel);
		return mav;
	}
	
	@RequestMapping(value = "/master/admissionType", method = RequestMethod.POST)
	public ModelAndView admissionTypePost(@ModelAttribute("INS_ADMSN_TYP") MasterCommonModel masterCommonModel,HttpServletRequest request) {
		boolean flag = false;
		System.out.println(" \n AcademicMasterController admissionType  POST");
		
		String admissionTypeCode = masterCommonModel.getCode();
		String admissionTypeName = masterCommonModel.getName();
		String admissionTypeRemarks = masterCommonModel.getRemarks();
		System.out.println("\n  Admission Type Code -->"+ admissionTypeCode+"  Admission Type Name --> "+admissionTypeName+" Admission Type Remarks --> "+ admissionTypeRemarks);
		this.masterCommonService.copyProperties(masterCommonModel);
		flag = this.masterCommonService.insert();		
		System.out.println("\n Controller admissionTypePost flag-->>"+flag);
		masterCommonModel.setCode(null);
		masterCommonModel.setName(null);
		masterCommonModel.setRemarks(null);
		ModelAndView mav = new ModelAndView(
				"academic/admissionType/insAdmissionType", "INS_ADMSN_TYP",
				masterCommonModel);
		return mav;
	}
}
