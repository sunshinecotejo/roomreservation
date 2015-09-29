package com.fsoft.roomreservation.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fsoft.roomreservation.webapp.model.User;



@Controller
public class UserController {
	
	@RequestMapping(value="/login")
	public ModelAndView loginPage(ModelAndView model){
		model.setViewName("login");
		return model;
	}
		
	@RequestMapping(value="/admin")
	public ModelAndView adminPage(ModelAndView model){
		model.setViewName("admin");
		return model;
	}
	
	
	@RequestMapping(value="/getUserDetail")
	public @ResponseBody User getUserDetail(){
		UserDetails principal =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = getUser(principal.getUsername());		
		
		return user;
	}
	
	public User getUser(String email){								
		final String uri =ScheduleController.SERVER_URI + "/user/getUser/{email}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("email",email);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    messageConverters.add(new MappingJackson2HttpMessageConverter());
	  	restTemplate.setMessageConverters(messageConverters); 
	  	
	  	
	    User result = new User();
	    result= restTemplate.getForObject(uri, User.class, params);
	    /*result.setEmail(map.get("email").toString());
	    result.setUserid((Integer)map.get("userid"));*/
	    
	    return result;
	}	
}
