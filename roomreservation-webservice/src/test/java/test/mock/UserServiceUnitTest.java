package test.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.model.Role;
import com.fsoft.roomreservation.core.model.Room;
import com.fsoft.roomreservation.core.model.User;
import com.fsoft.roomreservation.core.service.UserService;
import com.fsoft.roomreservation.core.util.DateUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {
	
	private IService<User> service;
	
	@Before
    public void setUp() {
        service = mock(UserService.class);
    }
	
	@Test
	public void create() {
		Set<Role> roles = new HashSet<Role>();
		roles.add( new Role().setRoleId(1).setRoleName("USER_ROLE"));
		roles.add( new Role().setRoleId(2).setRoleName("ADMIN_ROLE"));
		User source = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("delacerna_teodoro@yahoo.com");
		
		when(service.create(source)).thenReturn(source);
		User result = service.create(source);
		
		assertEquals(source.getUserid(), result.getUserid());
		assertEquals(source.getEmail() , result.getEmail());
		assertEquals(source.getFirstName(), result.getFirstName());
		assertEquals(source.getLastName(), result.getLastName());
		assertEquals(source.getPassword(), result.getPassword());
		
		verify(service).create(result);
	}
	
	@Test
	public void read(){
		Set<Role> roles = new HashSet<Role>();
		roles.add( new Role().setRoleId(1).setRoleName("USER_ROLE"));
		roles.add( new Role().setRoleId(2).setRoleName("ADMIN_ROLE"));
		User source = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("delacerna_teodoro@yahoo.com");
		
		when(service.read(1)).thenReturn(source);
		
		User result = service.read(1);
		
		assertEquals(source.getUserid(), result.getUserid());
		assertEquals(source.getEmail() , result.getEmail());
		assertEquals(source.getFirstName(), result.getFirstName());
		assertEquals(source.getLastName(), result.getLastName());
		assertEquals(source.getPassword(), result.getPassword());
		
		verify(service).read(1);
	}
	
	@Test
	public void update(){
		Set<Role> roles = new HashSet<Role>();
		roles.add( new Role().setRoleId(1).setRoleName("USER_ROLE"));
		roles.add( new Role().setRoleId(2).setRoleName("ADMIN_ROLE"));
		User source = new User()
			.setUserid(1)
			.setFirstName("new teodoro")
			.setLastName("new dela cerna")
			.setEmail("new_delacerna_teodoro@yahoo.com");
		
		when(service.update(source)).thenReturn(source);
		
		User result = service.update(source);
		assertEquals(source.getUserid(), result.getUserid());
		assertEquals(source.getEmail() , result.getEmail());
		assertEquals(source.getFirstName(), result.getFirstName());
		assertEquals(source.getLastName(), result.getLastName());
		assertEquals(source.getPassword(), result.getPassword());
		
		verify(service).update(source);
	}
	
	@Test
	public void delete(){
//		when(service.delete(new Integer(97))).thenReturn(new Boolean(true));
//		verify(service).delete(new Integer(97));
	}
	
	@Test
	public void getList(){
		Set<Role> roles = new HashSet<Role>();
		roles.add( new Role().setRoleId(1).setRoleName("USER_ROLE"));
		roles.add( new Role().setRoleId(2).setRoleName("ADMIN_ROLE"));
		User source = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("new_delacerna_teodoro@yahoo.com");
		
		List<User> list = new ArrayList<User>();
		list.add(source.setUserid(1));
		when(service.getList()).thenReturn(list);
		
		List<User> result = service.getList();
		assertEquals(list.size(), result.size());
		assertEquals(list, result);
		
    	verify(service).getList();
	}
	
}

