package com.erp.campus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.erp.campus.packages.model.academic.master.MasterCommonModel;

@Configuration
public class BeanGeneratorConfig {

	@Bean
	public MasterCommonModel masterCommonModel(){
		System.out.println(" masterCommonModel bean creation ");
		return new MasterCommonModel();
	}
}
