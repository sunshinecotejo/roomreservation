package com.fsoft.roomreservation.core.service;

import java.util.List;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.ClientError;

public abstract class AbstractService<T> implements IService<T>{
	
	protected abstract IRepository<T> getRepository();
	protected ClientError clientError;
	
	public ClientError getClientError(){
		return clientError;
	}
	
	public T create( T type ) {
		try{
			clientError = new ClientError();
			return getRepository().create(type);
		}catch( Exception ex ){
			this.clientError = new ClientError().setCode(204).setMessage(ex.getMessage());
			throw new IllegalStateException( ex.getMessage(), ex );
		}
	}
	
    public T update( T type ){
		try{
			clientError = new ClientError();
			return getRepository().update(type);
		}catch( Exception ex ){
			this.clientError = new ClientError().setCode(204).setMessage(ex.getMessage());
			throw new IllegalStateException( ex.getMessage(), ex );
		}
    }
    
    public Boolean delete( Integer id ) {
    	try{
    		clientError = new ClientError();
			getRepository().delete( id );
			return new Boolean(true);
		}catch( Exception ex ){
			this.clientError = new ClientError().setCode(204).setMessage(ex.getMessage());
			throw new IllegalStateException( ex.getMessage(), ex );
		}
    }
    
    public T read( Integer id ){
    	try{
    		clientError = new ClientError();
    		T type = getRepository().read(id);
    		if( null == type ){
    			throw new Exception("No Records Found.");
    		}
			return type;
		}catch( Exception ex ){
			this.clientError = new ClientError().setCode(204).setMessage(ex.getMessage());
			throw new IllegalStateException( ex.getMessage(), ex );
		}
    }
    
    public List<T> getList(){
    	try{
    		clientError = new ClientError();
    		List<T> list = getRepository().getList();
    		if( list.isEmpty() ){
    			throw new Exception("No Records Found.");
    		}
			return list;
		}catch( Exception ex ){
			this.clientError = new ClientError().setCode(204).setMessage(ex.getMessage());
			throw new IllegalStateException( ex.getMessage(), ex );
		}
    }
    
    public T readField(String field, Object value){
    	try{
			return getRepository().readField(field,value);
		}catch( Exception ex ){
			throw new IllegalStateException( ex.getMessage(), ex );
		}
    }
	
}
