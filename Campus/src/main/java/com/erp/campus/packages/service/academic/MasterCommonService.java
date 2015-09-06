package com.erp.campus.packages.service.academic;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.campus.packages.dao.academic.master.AdmissionTypeDao;
import com.erp.campus.packages.dao.ehr.master.DeptDao;
import com.erp.campus.packages.model.academic.master.MasterCommonModel;
import com.erp.campus.packages.vo.academic.master.MasterCommonVo;

@Service
public class MasterCommonService {
	
	@Autowired
	private  MasterCommonVo masterCommonVo;
	
	@Autowired	
	private AdmissionTypeDao admissionTypeDao;
	
	@Autowired
	private DeptDao deptDaoImpl;
	
	public void copyProperties(MasterCommonModel masterCommonModel){
		System.out.println("masterCommonModel Size in Service-->>>"+masterCommonModel.getCode()+"name-->>"+masterCommonModel.getCode());
//		ClsCommon.copyProperties(masterCommonModel,masterCommonVo);
		try {
			BeanUtils.copyProperties(masterCommonVo,masterCommonModel);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insert(){
		boolean flag = false;
		
	//	flag = this.admissionTypeDao.insert(masterCommonVo);
		flag = this.deptDaoImpl.insert(masterCommonVo);
		return flag;
	}
	
	public List getAcademicTypeList(){
		return admissionTypeDao.getAcademicTypeList();
	}
}
