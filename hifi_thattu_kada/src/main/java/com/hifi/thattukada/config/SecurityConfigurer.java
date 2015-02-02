package com.hifi.thattukada.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*@Configuration
@EnableWebSecurity*/
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Inject
	private DataSource dataSource;
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**", "/signup", "/welcome/**","/").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin();
				/*.loginPage("/index")
				.permitAll();*/
		}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth
	.ldapAuthentication()
	.userDnPatterns("uid={0},ou=people")
	.groupSearchBase("ou=groups");
	}*/
}
