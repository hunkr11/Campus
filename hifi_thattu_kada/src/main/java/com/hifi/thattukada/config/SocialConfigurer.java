package com.hifi.thattukada.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;


@Configuration
@EnableSocial


public class SocialConfigurer extends SocialConfigurerAdapter {
	@Inject
	private DataSource dataSource;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
	//	cfConfig.addConnectionFactory(new TwitterConnectionFactory(env.getProperty("twitter.appKey"), env.getProperty("twitter.appSecret")));
		cfConfig.addConnectionFactory(new FacebookConnectionFactory(env.getProperty("facebook.appKey"), env.getProperty("facebook.appSecret")));
	//	cfConfig.addConnectionFactory(new LinkedInConnectionFactory(env.getProperty("linkedin.appKey"), env.getProperty("linkedin.appSecret")));
	}
	
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		System.out.println("\n --getUsersConnectionRepository--");
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
		repository.setConnectionSignUp(new SimpleConnectionSignUp());
		return repository;
	}
	
	/*public UserIdSource getUserIdSource() {
		System.out.println("\n getUserIdSource");
		return new UserIdSource() {
			@Override
			public String getUserId() {
				return SecurityContext.getCurrentUser().getId();
			}
		};
	}*/

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public Facebook facebook(ConnectionRepository repository) {
		System.out.println("\n facebook repository-->"+repository);
		Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
		return connection != null ? connection.getApi() : null;
	}

	@Bean
	public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository) {
		System.out.println("\n providerSignInController");
		return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, new SpringSecuritySignInAdapter());
	}

}
