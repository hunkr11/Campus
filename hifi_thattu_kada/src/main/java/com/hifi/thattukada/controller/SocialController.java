package com.hifi.thattukada.controller;

import javax.inject.Inject;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SocialController {
	
 @Inject
	private ConnectionRepository connectionRepository;

	@RequestMapping(value="/facebook",  method = { RequestMethod.GET, RequestMethod.POST })
	
	public String home(Model model) {
		System.out.println("\n \n SocialController facebook HOME");
		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
		if (connection == null) {
			return "redirect:/connect/facebook";
		}
		model.addAttribute("profile", connection.getApi().userOperations().getUserProfile());
		return "facebook/profile";
	}
	
/*@RequestMapping(value="/signin/facebook",  method =  RequestMethod.POST )
	
	public String facebook(Model model) {
		System.out.println("\n \n SocialController.facebook ");
		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
		if (connection == null) {
			return "redirect:/signin/facebook";
		}
		else{
		model.addAttribute("profile", connection.getApi().userOperations().getUserProfile());
		return "home";
		}
	}
*/
	
}
