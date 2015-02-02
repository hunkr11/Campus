package com.erp.campus.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println(" \n\n -- CONFIGURATIOn START -- \n \n");
		configurer.enable();
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("\n WebMvcConfig.addResourceHandlers");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	 @Bean
	  	public ViewResolver viewResolver() {
			System.out.println(" \n viewResolver() \n");
		    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		    templateResolver.setTemplateMode("XHTML");
		    templateResolver.setPrefix("/views/");
		    templateResolver.setSuffix(".html");
		    SpringTemplateEngine engine = new SpringTemplateEngine();
		    engine.setTemplateResolver(templateResolver);
		//	engine.addDialect(new SpringSocialDialect());
			engine.addDialect(new LayoutDialect());
		    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		    viewResolver.setTemplateEngine(engine);
	    	return viewResolver;
	  }

}
