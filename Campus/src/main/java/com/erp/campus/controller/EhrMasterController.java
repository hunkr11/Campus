package com.erp.campus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erp.campus.packages.entity.ehr.master.DeptMasterEntity;
import com.erp.campus.packages.form.master.DeptForm;
import com.erp.campus.packages.service.ehr.master.DeptService;
// module/ehr/master/deptMaster
@Controller
@RequestMapping("/module/ehr/master")
public class EhrMasterController {
	@Autowired
	private DeptService deptServiceImpl;
	
	@RequestMapping(value="/deptMaster",method = RequestMethod.GET)
	public ModelAndView deptMaster(){
		System.out.println("deptMaster EHR");
		List<DeptForm> formBeanList = prepareBean(deptServiceImpl.getDeptList());		
		return new ModelAndView("module/ehr/master/deptMaster","objDept",formBeanList);
	}
	
	public List<DeptForm> prepareBean(List<DeptMasterEntity> list) {
		ArrayList<DeptForm> formBeanList = null;
		if(list !=null || list.isEmpty()){
			formBeanList = new ArrayList<DeptForm>();
			DeptForm bean = null;
			for(DeptMasterEntity entity:list){
				bean = new DeptForm();
				bean.setDeptId(entity.getId());
			//	bean.setDeptCode(entity.getDeptCode());
			//	bean.setDescription(entity.getDeptDescription());
			//	bean.setActive(entity.isActive());
				formBeanList.add(bean);
			}
		}
		return formBeanList;
		
	}

}
