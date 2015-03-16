package com.erp.campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.erp.campus")
@EnableAutoConfiguration
@EnableWebMvc
public class Campus {


    public static void main(String[] args) {
    	System.out.println("- -MAIN START- -\n  \n");
        SpringApplication.run(Campus.class, args); 
    }
}
