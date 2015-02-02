package com.hifi.thattukada.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.social.connect.web.thymeleaf.SpringSocialDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.hifi.thattukada.variety.dao.UserDao;
import com.hifi.thattukada.variety.daoImp.UserDaoImp;
import com.hifi.thattukada.variety.entity.UserEntity;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("com.hifi.thattukada")
@PropertySources(value = {@PropertySource("classpath:application.properties")})

public class HibernateConfigurer{
	
//	private static final String PROPERTY_NAME_DATABASE_DRIVER="spring.datasource.driverClassName";	
//	private static final String PROPERTY_NAME_DATABASE_URL="spring.datasource.url";
//	private static final String PROPERTY_NAME_DATABASE_USERNAME="spring.datasource.username";
//	private static final String PROPERTY_NAME_DATABASE_PASSWORD="spring.datasource.password";
	
//	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
 //   private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
 //   private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.hifi.thattukada.variety.entity";

    
    @Resource
    private Environment env;
	
    @Bean
    public UserDao userDao(SessionFactory sessionFactory){
    	System.out.println("\n\n --USER DAO BEAN-- \n \n");
    	return new UserDaoImp(sessionFactory);
    }
    
    @Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
    @Bean
	public DataSource dataSource() {
    	System.out.println("\n\n-- HIBERNATE CONFIGURATION DATA SOURCE-- \n\n");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/HIFI_THATTU_KADA");
	    dataSource.setUsername("root");
	    dataSource.setPassword("password");
	 
	    return dataSource;
	}
    
    /*@Bean
    public DataSource dataSource() {
    	
    	System.out.println("\n\n-- HIBERNATE CONFIGURATION DATA SOURCE-- \n\n");
    	 BasicDataSource dataSource = new BasicDataSource();
 	    dataSource.setDriverClassName("org.postgresql.Driver");
 	    dataSource.setUrl("jdbc:postgresql://localhost/HIFI_THATTU_KADA");
 	    dataSource.setUsername("postgres");
 	    dataSource.setPassword("redhat");
        return (DataSource) dataSource;
        
    }*/
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
    	System.out.println("\n\n  --SESSION FACTORY CREATION--  \n\n");
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
    	sessionBuilder.addAnnotatedClass(UserEntity.class);
    	sessionBuilder.setProperty("hibernate.show_sql", "true");
    	sessionBuilder.setProperty("entitymanager.packages.to.scan", "com.hifi.thattukada.variety.entity");
   // 	sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    	sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
    	//sessionBuilder.addProperties(hibProperties());
    	return sessionBuilder.buildSessionFactory();
		/*return (SessionFactory) new LocalSessionFactoryBuilder((javax.sql.DataSource) dataSource())
		   .addAnnotatedClasses(UserEntity.class)	
		   .addProperties(hibProperties());
		   .buildSessionFactory(); */
	}
    
  /*  @Autowired
    @Bean  // bean name should be transactionManager
	public HibernateTransactionManager hibTransMan(SessionFactory sessionFactory){
    	System.out.println("\n\n HibernateTransactionManager \n \n");
    	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	} */
    /*      	with reference to http://fruzenshtein.com/spring-mvc-hibernate-maven-crud/
     */
  /*  private Properties hibProperties() {
        	Properties properties = new Properties();
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect ");
            return properties;
    } */
    
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    	System.out.println("\n\n HibernateTransactionManager \n \n");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);     
        return transactionManager;
    }
    
    
    
    /*
   @Bean
    public LocalSessionFactoryBean sessionFactory() {
    	System.out.println("\n\n-- LOCAL SESSION FACTORY BEAN-- \n\n");
    	System.out.println("package name--->>> \n\n"+PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        System.out.println("\n\n\n BOOMMMMMM \n\n\n");
        sessionFactoryBean.setDataSource( (javax.sql.DataSource) dataSource());
        System.out.println("\n\n\n BOOMMMMMM 2 \n\n\n");
        sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        System.out.println("\n\n\n BOOMMMMMM 3\n\n\n");
        sessionFactoryBean.setHibernateProperties(hibProperties());
        System.out.println("\n\n\n BOOMMMMMM 4\n\n\n");
        return sessionFactoryBean;
    }*/
    
    
     
    /*@Bean
    public HibernateTransactionManager transactionManager() {
    	System.out.println("\n\n-- TRANSACTION MANAGER-- \n\n");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }*/
    
}
