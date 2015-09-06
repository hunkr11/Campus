package com.erp.campus.packages.daoImp.academic.master;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erp.campus.packages.dao.academic.master.AdmissionTypeDao;
import com.erp.campus.packages.entity.academic.master.AdmissionTypeEntity;
import com.erp.campus.packages.vo.academic.master.MasterCommonVo;

@Repository
public class AdmissionTypeDaoImpl implements AdmissionTypeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AdmissionTypeEntity admissionTypeEntity;
	
	public AdmissionTypeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AdmissionTypeDaoImpl() {	
	}

	@Override
	@Transactional
	public boolean insert(MasterCommonVo masterCommonVo) {
		System.out.println("\n\n INSIDE userLogin DAO IMP \n\n");
		boolean userFlag = false;
		System.out.println("VO Code-->>"+masterCommonVo.getCode()+"\n VO Name -->  " + masterCommonVo.getName() +"V0 Remarks -->>"+masterCommonVo.getRemarks() );
		try {
			BeanUtils.copyProperties(admissionTypeEntity,masterCommonVo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().save(admissionTypeEntity);	
		userFlag = true;
		System.out.println("Insert DAO Flag-->>>"+userFlag);
		return userFlag;				
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public List getAcademicTypeList() {
		ArrayList<AdmissionTypeEntity> list = (ArrayList) sessionFactory.getCurrentSession().createQuery("from AdmissionTypeEntity").list();
		
		for(int i =0;i<list.size();i++){
			System.out.println(" getAcademicTypeList -->> = "+list.get(i).getCode());
		}
	
		return list;
	}
	
	
	
	
}
