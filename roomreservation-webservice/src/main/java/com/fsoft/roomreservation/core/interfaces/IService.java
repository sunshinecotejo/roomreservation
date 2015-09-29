package com.fsoft.roomreservation.core.interfaces;

import java.util.List;

import com.fsoft.roomreservation.core.model.ClientError;

public interface IService<T> {
	
	public T create( T type );
	
    public T update( T type );
    
    public Boolean delete( Integer id );
    
    public T read( Integer id );
        
    public T readField(String field, Object value);
    
    public List<T> getList();
    
    public ClientError getClientError();
    
}
