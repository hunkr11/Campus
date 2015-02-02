package com.hifi.thattukada.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

@Service
public class SpringSecuritySignInAdapter implements SignInAdapter {
	public String signIn(String localUserId, Connection<?> connection,NativeWebRequest request) {
		System.out.println("\n localUserId -->>"+localUserId+"\n connection-->"+connection+"\n request"+request+"\n");
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(localUserId,null, null));
	return null;
	}
}