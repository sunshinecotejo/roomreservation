package com.fsoft.roomreservation.core.interfaces;

import java.util.List;

public interface IRepository<T> {
	
	public T create( T type ) throws Exception;;
    
    public T update( T type ) throws Exception;
    
    public void delete( Integer id ) throws Exception;
    
    public T read( Integer id );
    
    public T readField(String field, Object value);
    
    public List<T> getList();

}
