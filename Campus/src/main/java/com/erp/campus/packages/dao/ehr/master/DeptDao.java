package com.erp.campus.packages.dao.ehr.master;

import java.util.List;

import com.erp.campus.packages.entity.ehr.master.DeptMasterEntity;
import com.erp.campus.packages.vo.academic.master.MasterCommonVo;

public interface DeptDao {
	public List<DeptMasterEntity> getDeptList();

	boolean insert(MasterCommonVo masterCommonVo);
}
