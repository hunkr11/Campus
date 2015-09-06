package com.erp.campus.packages.service.ehr.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.campus.packages.dao.ehr.master.DeptDao;
import com.erp.campus.packages.entity.ehr.master.DeptMasterEntity;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDaoImpl;
	
	@Override
	public List<DeptMasterEntity> getDeptList() {
		// TODO Auto-generated method stub
		return deptDaoImpl.getDeptList();
	}

}
