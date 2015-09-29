package com.fsoft.roomreservation.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fsoft.roomreservation.webapp.model.Reservation;
import com.fsoft.roomreservation.webapp.model.Room;
import com.fsoft.roomreservation.webapp.model.User;

@RestController
@RequestMapping(value="/viewScheduler")
public class ScheduleController {

	public static final String SERVER_URI = "http://localhost:8081/roomreservation-webservice-0.0.1-SNAPSHOT";		
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping(value = "/")
	public ModelAndView  getCalendar( ModelAndView model) {				
		UserDetails principal =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();			
		System.out.println(SecurityContextHolder.getContext().getAuthentication());					
		model.addObject("roomList", getRooms());
		model.addObject("user",getUser(principal.getUsername()));
		model.setViewName("viewScheduler");
		
		return model;				
	}
			
	
	public List<Room> getRooms(){
		
		final String uri = SERVER_URI + "/room/";
		
		List<Room> rooms = new ArrayList<Room>();
				
	    RestTemplate restTemplate = new RestTemplate();
	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    messageConverters.add(new MappingJacksonHttpMessageConverter());
	  	restTemplate.setMessageConverters(messageConverters); 
	  	
	  	
	  	List<LinkedHashMap> result = restTemplate.getForObject(uri, List.class);
	    System.out.println("rooms-------------->"+result.size());
	    for(LinkedHashMap map: result){
	    		
	    	Room room = new Room();
	    	room.setRoomId(Integer.parseInt(map.get("roomId").toString()));
	    	room.setRoomName(map.get("roomName").toString());
	    	room.setRoomCapacity(Integer.parseInt(map.get("roomCapacity").toString()));
			rooms.add(room);
		
	    }
	   return rooms;
	}
		
	
	
	@RequestMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public @ResponseBody Reservation waaaa(@RequestBody Reservation reserve){
		System.out.println(reserve.getReservationSchedule());
		UserDetails principal =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String uri = SERVER_URI + "/reservationmgt/create";
		
				
		System.out.println("AUthorities: " + principal.getAuthorities().toString());
		System.out.println("Username: " + principal.getUsername());
		  RestTemplate restTemplate = new RestTemplate();
		  List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		  messageConverters.add(new MappingJacksonHttpMessageConverter());
		  restTemplate.setMessageConverters(messageConverters); 				  
		  reserve.setUserId(getUser(principal.getUsername()).getUserid());
		  
		 // restTemplate.postForObject(uri, reserve,Reservation.class);
		
		return reserve;		
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
