package com.erp.campus.packages.dao.academic.master;

import java.util.List;

import com.erp.campus.packages.vo.academic.master.MasterCommonVo;



public interface AdmissionTypeDao {
	public boolean insert(MasterCommonVo masterCommonVo);
	public List getAcademicTypeList();
}
