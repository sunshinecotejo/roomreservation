package com.fsoft.roomreservation.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;




import java.util.Map;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fsoft.roomreservation.webapp.model.Building;



@SuppressWarnings("deprecation")
@RestController
@RequestMapping(value="/viewBuilding")
public class BuildingController {
	
	public static final String SERVER_URI = "http://localhost:8081/roomreservation-webservice-0.0.1-SNAPSHOT";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/")
	public ModelAndView  getList(ModelAndView model) {

		final String uri = SERVER_URI + URIConstants.READ_ALL_BUILDING;
		
		List<Building> buildings = new ArrayList<Building>();
		
	    RestTemplate restTemplate = new RestTemplate();
	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    messageConverters.add(new MappingJacksonHttpMessageConverter());
	  	restTemplate.setMessageConverters(messageConverters); 
	  	
	  	
	  	 List<LinkedHashMap> result = restTemplate.getForObject(uri, List.class);
	    System.out.println("buildings-------------->"+result.size());
	    for(LinkedHashMap map: result){
	    	
	    	Building building = new Building();
	    	building.setBuildingId(Integer.parseInt(map.get("buildingId").toString()));
	    	building.setBuildingName(map.get("buildingName").toString());
	    	building.setBuildingAddress(map.get("buildingAddress").toString());
			buildings.add(building);
			  
	    }
	    model.addObject("buildingList", buildings);
		model.setViewName("viewBuilding");
		return model;
	}
	
	@RequestMapping(value = "/read/{id}")
	public ModelAndView read(@PathVariable Integer id, ModelAndView model) {
		final String uri = SERVER_URI + URIConstants.READ_BUILDING;
	
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		
		RestTemplate restTemplate = new RestTemplate();    
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    messageConverters.add(new MappingJacksonHttpMessageConverter());
	  	restTemplate.setMessageConverters(messageConverters); 
		
		Building result  = restTemplate.getForObject(uri, Building.class, params);
		System.out.println("getBuildingById=========="+result);
		
		model.addObject("building", result);
		model.setViewName("viewBuilding");
		return model;
 
	}
	
	@RequestMapping(value = "/create")
	public ModelAndView create(ModelAndView model) {
		final String uri = SERVER_URI + URIConstants.READ_BUILDING;
	
		
		RestTemplate restTemplate = new RestTemplate();    
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    messageConverters.add(new MappingJacksonHttpMessageConverter());
	  	restTemplate.setMessageConverters(messageConverters); 
		
	  	Building building = new Building();
	  	building.setBuildingName("Skyrise 1");
	  	building.setBuildingAddress("IT Park");
	  	
		Building result  = restTemplate.postForObject(uri, building, Building.class);
		System.out.println("getBuildingById=========="+result);
		
		model.addObject("building", result);
		model.setViewName("createBuilding");
		return model;
 
	}
 
	
}
