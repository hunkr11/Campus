package com.erp.campus.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@EnableWebMvc
public class HibernateConfig {
	@Bean
    public DataSource dataSource() {
    	
    	System.out.println("\n\n-- CONFIGURATING DATA SOURCE-- \n\n");
    	BasicDataSource dataSource = new BasicDataSource();
 	    dataSource.setDriverClassName("org.postgresql.Driver");
 	    dataSource.setUrl("jdbc:postgresql://localhost/HIFI_THATTU_KADA");
 	    dataSource.setUsername("postgres");
 	    dataSource.setPassword("redhat");
        return (DataSource) dataSource;        
    }
	
	 @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory sessionFactory() {
	    	System.out.println("\n\n  --SESSION FACTORY CREATION--  \n\n");
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
	    //	sessionBuilder.addAnnotatedClass(UserEntity.class);
	    	sessionBuilder.setProperty("hibernate.show_sql", "true");
	    	sessionBuilder.setProperty("entitymanager.packages.to.scan", "com.hifi.thattukada.variety.entity");
	    	sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");  
	    	return sessionBuilder.buildSessionFactory();
			
		}
	 
	 @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    	System.out.println("\n\n HibernateTransactionManager \n \n");
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);     
	        return transactionManager;
	    }
	 
	
}
