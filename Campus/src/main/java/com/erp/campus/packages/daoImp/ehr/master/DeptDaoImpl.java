package com.erp.campus.packages.daoImp.ehr.master;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erp.campus.packages.dao.ehr.master.DeptDao;
import com.erp.campus.packages.entity.ehr.master.DeptMasterEntity;
import com.erp.campus.packages.vo.academic.master.MasterCommonVo;

@Repository
public class DeptDaoImpl implements DeptDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private DeptMasterEntity deptMasterEntity;

	public DeptDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public DeptDaoImpl(){
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DeptMasterEntity> getDeptList() {
		return sessionFactory.getCurrentSession().createQuery("from DeptMasterEntity").list();		
	}
	
	@Override
	@Transactional
	public boolean insert(MasterCommonVo masterCommonVo) {
		System.out.println("\n\n INSIDE userLogin DAO IMP \n\n");
		boolean userFlag = false;
		System.out.println("VO Code-->>"+masterCommonVo.getCode()+"\n VO Name -->  " + masterCommonVo.getName() +"V0 Remarks -->>"+masterCommonVo.getRemarks() );
		try {
			deptMasterEntity = new DeptMasterEntity();
			BeanUtils.copyProperties(deptMasterEntity,masterCommonVo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().save(deptMasterEntity);	
		userFlag = true;
		System.out.println("Insert DAO Flag-->>>"+userFlag);
		return userFlag;				
	}

}

