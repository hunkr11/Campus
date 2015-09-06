package com.erp.campus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erp.campus.packages.entity.academic.master.AdmissionTypeEntity;
import com.erp.campus.packages.model.academic.master.MasterCommonModel;
import com.erp.campus.packages.service.academic.MasterCommonService;

@Controller
@RequestMapping(value = "/module/academic")
public class AcademicController {

	@Autowired	
	private MasterCommonModel masterCommonModel;
	
	@Autowired
	private MasterCommonService masterCommonService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String academic() {
		System.out.println("ACADEMICS MODULE");
		//return "homeAcademic";
		return "module/academic/homeAcademic";
	
	}

	@RequestMapping(value = "/admission", method = RequestMethod.GET)
	public ModelAndView admission() {
		System.out.println(" \n AcademicController ADMISSION ");
		ModelAndView mav = new ModelAndView("academic/admission");
		return mav;
	}

	@RequestMapping(value = "/master/admissionType", method = RequestMethod.GET)
	public ModelAndView admissionType() {
		System.out.println(" \n AcademicMasterController admissionType GET");
		ModelAndView mav = new ModelAndView(
				"module/academic/master/admissionType/insAdmissionType", "INS_ADMSN_TYP",
				masterCommonModel);
		return mav;
	}
	@RequestMapping(value="/master/admissionType/getAdmissionTypeCode", method = {RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Object> getAdmissionTypeCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	//	JSONObject jsonObj = getJsonFromMyFormObject(masterCommonService.getAcademicTypeList());
		PrintWriter out = response.getWriter();


	//	Insert_UserDetails details = 
		request.setCharacterEncoding("utf8");
		response.setContentType("application/json");
		
		@SuppressWarnings("unchecked")
		List<AdmissionTypeEntity> list = masterCommonService.getAcademicTypeList();
		int recordCounter=1;
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
		    JSONObject formDetailsJson = new JSONObject();
		 //   formDetailsJson.put("acad_typ_id", list.get(i).getId());
		 //     formDetailsJson.put("acad_typ_code", list.get(i).getCode());
		    formDetailsJson.put("acad_typ_id", list.get(i).getId());
		    formDetailsJson.put("acad_typ_code", list.get(i).getCode());
		//    formDetailsJson.put("age", list.get(++i));

		   

		    jArray.put(formDetailsJson);
		    recordCounter++;
		}
	

		out.print(jArray.toString());
		
		
		System.out.println("finalJSON.toString() :: "+jArray.toString());

/// response.setContentType("application/json");
// System.out.println("json ---- >>> "+jsonObj.toString());
// response.getWriter().write(jsonObj.toString());
		return null;
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
				"module/academic/master/admissionType/insAdmissionType", "INS_ADMSN_TYP",
				masterCommonModel);
		return mav;
	}
	
	// JSON Conversion
	
	 @SuppressWarnings("unchecked")
	public static JSONObject getJsonFromMyFormObject(List<AdmissionTypeEntity> form1)
	  {
	    JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();

	    for (int i = 0; i < form1.size(); i++)
	    {
	      JSONObject formDetailsJson = new JSONObject();
	      formDetailsJson.put("acad_typ_id", form1.get(i).getId());
	      formDetailsJson.put("acad_typ_code", form1.get(i).getCode());

	      ((List<Object>) jsonArray).add(formDetailsJson);
	    }
	    responseDetailsJson.put("forms", jsonArray);
	    System.out.println("json array :: "+jsonArray);
	    return responseDetailsJson;
	  }
	
}
