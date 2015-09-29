package com.fsoft.roomreservation.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.ClientError;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;

public abstract class AbstractController<T>{
	
	public abstract IService<T> getService();
	
	public ClientResponseEntity<List<T>> getList(){
		ClientResponseEntity<List<T>> response = new ClientResponseEntity<List<T>>(); 
		List<T> types = getService().getList();
		ClientError error = getService().getClientError();
		if( error.isEmpty() ){
			response.setCode(200)
					.setMessage("Success!")
					.setEntity(types);
		}else{
			response.setCode(error.getCode())
					.setMessage(error.getMessage())
					.setEntity(types);
		}
		return response;
	}
	
	public ClientResponseEntity<?> create(T type){
		ClientResponseEntity<T> response = new ClientResponseEntity<T>();
		getService().create(type);
		ClientError error = getService().getClientError();
		if( error.isEmpty() ){
			response.setCode(200)
					.setMessage("Success!")
					.setEntity(type);
		}else{
			response.setCode(error.getCode())
					.setMessage(error.getMessage())
					.setEntity(type);
		}
		return response;
	}
	
	public ClientResponseEntity<T> read(@PathVariable("id") Integer id){
		ClientResponseEntity<T> response = new ClientResponseEntity<T>();
		T type = getService().read(id);
		ClientError error = getService().getClientError();
		if( error.isEmpty() ){
			response.setCode(200)
					.setMessage("Success!")
					.setEntity(type);
			
		}else{
			response.setCode(error.getCode())
					.setMessage(error.getMessage())
					.setEntity(type);
		}
		return response;
	}
	
	public ClientResponseEntity<T> update(@RequestBody T type){
		ClientResponseEntity<T> response = new ClientResponseEntity<T>();
		getService().update(type);
		ClientError error = getService().getClientError();
		if( error.isEmpty() ){
			response.setCode(200)
					.setMessage("Success!")
					.setEntity(type);
			
		}else{
			response.setCode(error.getCode())
					.setMessage(error.getMessage())
					.setEntity(type);
		}
		
		return response;
	}
	
	public ClientResponseEntity<Boolean> delete(@PathVariable("id") Integer id){
		ClientResponseEntity<Boolean> response = new ClientResponseEntity<Boolean>();
		Boolean result = getService().delete(id);
		ClientError error = getService().getClientError();
		if( error.isEmpty() ){
			response.setCode(200)
					.setMessage("Success!")
					.setEntity(result);
		}else{
			response.setCode(error.getCode())
					.setMessage(error.getMessage())
					.setEntity(result);
		}
		
		return response;
	}
	
}
