package com.fsoft.roomreservation.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fsoft.roomreservation.webapp.model.Reservation;
import com.fsoft.roomreservation.webapp.model.Room;
import com.fsoft.roomreservation.webapp.model.User;


@Controller
public class TempReserveController {
	
	public static final String SERVER_URI = "http://localhost:8081/roomreservation-webservice-0.0.1-SNAPSHOT";
	
	@RequestMapping(value="/tempReserve",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public @ResponseBody Reservation waaaa(@RequestBody Reservation reserve){
		System.out.println(reserve.getReservationSchedule());
		
		String uri = SERVER_URI + "/reservationmgt/create";
		
		  RestTemplate restTemplate = new RestTemplate();
		  List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		  messageConverters.add(new MappingJacksonHttpMessageConverter());
		  restTemplate.setMessageConverters(messageConverters); 				  
		  reserve.setUserId(1);
		  
		  restTemplate.postForObject(uri, reserve,Reservation.class);
		
		return reserve;		
	}
	
	@RequestMapping(value="/try",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public @ResponseBody Room waaa(@RequestBody Room room){		
		return room;		
	}
	
	@RequestMapping(value="/getHeader")
	public @ResponseBody String waaaaa2(@RequestHeader("Authorization") String boot){
		return boot;
	}
			
	@RequestMapping(value="/reserve")
	public String waaaa2(@RequestHeader("Authorization") String boot){
		System.out.println(boot);								
		return "samplePost";	
	}
	
	@RequestMapping(value="/reserveView")
	public String waaaaa3(){
		return "viewScheduler";	
	}
}
