package com.erp.campus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.erp.campus.packages.dao.academic.master.AdmissionTypeDao;
import com.erp.campus.packages.daoImp.academic.master.AdmissionTypeDaoImpl;
import com.erp.campus.packages.entity.academic.master.AdmissionTypeEntity;
import com.erp.campus.packages.model.academic.master.MasterCommonModel;
import com.erp.campus.packages.service.academic.MasterCommonService;
import com.erp.campus.packages.vo.academic.master.MasterCommonVo;


@Configuration
public class BeanGeneratorConfig {

	@Bean
	public MasterCommonModel masterCommonModel(){
		System.out.println(" masterCommonModel bean creation ");
		return new MasterCommonModel();
	}
	@Bean 
	public MasterCommonVo masterCommonVo(){
		return new MasterCommonVo();
	}	
	@Bean
	public MasterCommonService masterCommonService(){
		return new MasterCommonService();
	}
	@Bean
	public AdmissionTypeEntity admissionTypeEntity(){
		return new AdmissionTypeEntity();
	}
/*	@Bean
	public AdmissionTypeDao admnsTypeDao(){
		return new AdmissionTypeDaoImpl();
	}*/
	
}
