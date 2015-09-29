package test.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.model.Room;
import com.fsoft.roomreservation.core.model.User;
import com.fsoft.roomreservation.core.service.ReservationService;
import com.fsoft.roomreservation.core.util.DateUtil;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceUnitTest {
	
	private static IService<Reservation> service;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@BeforeClass
	public static void setUp(){
		service = mock(ReservationService.class);
		System.out.println("~~~~~~~~~~~~setting up~~~~~~~~~~~~~");
	}
	
	@AfterClass 
	public static void cleanUp(){
		System.out.println("~~~~~~~~~~~~cleaning up~~~~~~~~~~~~~");
	}
	
	/*
	@Before
    public void before() {
        System.out.println("===========before===============");
    }
	*/
	
	@After
	public void after(){
		System.out.println("===========after===============");
	}
	
	@Test
	public void create() {
		System.out.println("create...");
		Date reservationDate = DateUtil.toDate("2015-07-24 09:30:07", sdf); 
		User user = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("delacerna_teodoro@yahoo.com");
		Room room = new Room()
			.setRoomId(1)
			.setRoomName("Mala Pascua");
			
		Reservation source = new Reservation()
			.setUser(user)
			.setRoom(room)
			.setTitle("DTV Interview")
			.setDescription("DTV Interview")
			.setReservationSchedule(reservationDate)
			.setDuration(2);
		
		when(service.create(source)).thenReturn(source);
		Reservation result = service.create(source);
		
		assertTrue("Source and Result Room ids are equal ", source.getRoomId() == result.getRoomId());
		assertTrue("Source and Result User ids are equal ", source.getUserId() == result.getUserId());
		
		assertEquals(source.getUserId(), result.getUserId());
		assertEquals(source.getRoomId(), result.getRoomId());
		
		assertEquals(source.getUser().getUserid(), result.getUser().getUserid());
		assertEquals(source.getUser().getFirstName(), result.getUser().getFirstName());
		assertEquals(source.getUser().getLastName(), result.getUser().getLastName());
		assertEquals(source.getUser().getEmail(), result.getUser().getEmail());
		
		assertEquals(source.getRoom().getRoomId(), result.getRoom().getRoomId());
		assertEquals(source.getRoom().getRoomName(), result.getRoom().getRoomName());
		
		assertEquals(source.getTitle(), result.getTitle());
		assertEquals(source.getDescription(), result.getDescription());
		assertEquals(source.getDuration(), result.getDuration());
		assertEquals(source.getReservationSchedule(), result.getReservationSchedule());
		
		verify(service).create(result);
	}
	
	@Test
	public void read(){
		Date reservationDate = DateUtil.toDate("2015-07-24 09:30:07", sdf); 
		User user = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("delacerna_teodoro@yahoo.com");
		Room room = new Room()
			.setRoomId(1)
			.setRoomName("Mala Pascua");
			
		Reservation source = new Reservation()
			.setUser(user)
			.setRoom(room)
			.setTitle("DTV Interview")
			.setDescription("DTV Interview")
			.setReservationSchedule(reservationDate)
			.setDuration(2);
		
		when(service.read(1)).thenReturn(source);
		
		Reservation result = service.read(1);
		assertTrue("Source and Result Room ids are equal ", source.getRoomId() == result.getRoomId());
		assertTrue("Source and Result User ids are equal ", source.getUserId() == result.getUserId());
		
		assertEquals(source.getUserId(), result.getUserId());
		assertEquals(source.getRoomId(), result.getRoomId());
		
		assertEquals(source.getUser().getUserid(), result.getUser().getUserid());
		assertEquals(source.getUser().getFirstName(), result.getUser().getFirstName());
		assertEquals(source.getUser().getLastName(), result.getUser().getLastName());
		assertEquals(source.getUser().getEmail(), result.getUser().getEmail());
		
		assertEquals(source.getRoom().getRoomId(), result.getRoom().getRoomId());
		assertEquals(source.getRoom().getRoomName(), result.getRoom().getRoomName());
		
		assertEquals(source.getTitle(), result.getTitle());
		assertEquals(source.getDescription(), result.getDescription());
		assertEquals(source.getDuration(), result.getDuration());
		assertEquals(source.getReservationSchedule(), result.getReservationSchedule());
		
		verify(service).read(1);
	}
	
	@Test
	public void update(){
		System.out.println("update...");
		Date reservationDate = DateUtil.toDate("2015-07-24 09:30:07", sdf); 
		User user = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("delacerna_teodoro@yahoo.com");
		Room room = new Room()
			.setRoomId(1)
			.setRoomName("Mala Pascua");
			
		Reservation source = new Reservation()
			.setUser(user)
			.setRoom(room)
			.setTitle("new DTV Interview")
			.setDescription("new DTV Interview")
			.setReservationSchedule(reservationDate)
			.setDuration(2);
		
		when(service.update(source)).thenReturn(source);
		
		Reservation result = service.update(source);
		assertTrue("Source and Result Room ids are equal ", source.getRoomId() == result.getRoomId());
		assertTrue("Source and Result User ids are equal ", source.getUserId() == result.getUserId());
		
		assertEquals(source.getUserId(), result.getUserId());
		assertEquals(source.getRoomId(), result.getRoomId());
		
		assertEquals(source.getUser().getUserid(), result.getUser().getUserid());
		assertEquals(source.getUser().getFirstName(), result.getUser().getFirstName());
		assertEquals(source.getUser().getLastName(), result.getUser().getLastName());
		assertEquals(source.getUser().getEmail(), result.getUser().getEmail());
		
		assertEquals(source.getRoom().getRoomId(), result.getRoom().getRoomId());
		assertEquals(source.getRoom().getRoomName(), result.getRoom().getRoomName());
		
		assertEquals(source.getTitle(), result.getTitle());
		assertEquals(source.getDescription(), result.getDescription());
		assertEquals(source.getDuration(), result.getDuration());
		assertEquals(source.getReservationSchedule(), result.getReservationSchedule());
		
		verify(service).update(source);
	}
	
	@Test
	public void delete(){
		System.out.println("delete...");
//		when(service.delete(new Integer(97))).thenReturn(new Boolean(true));
//		verify(service).delete(new Integer(97));
	}
	
	@Test
	public void getList(){
		System.out.println("getList...");
		Date reservationDate = DateUtil.toDate("2015-07-24 09:30:07", sdf); 
		User user = new User()
			.setUserid(1)
			.setFirstName("teodoro")
			.setLastName("dela cerna")
			.setEmail("delacerna_teodoro@yahoo.com");
		Room room = new Room()
			.setRoomId(1)
			.setRoomName("Mala Pascua");
			
		Reservation source = new Reservation()
			.setUser(user)
			.setRoom(room)
			.setTitle("DTV Interview")
			.setDescription("DTV Interview")
			.setReservationSchedule(reservationDate)
			.setDuration(2);
		
		List<Reservation> list = new ArrayList<Reservation>();
		list.add(source.setReservationid(94));
		when(service.getList()).thenReturn(list);
		
		List<Reservation> result = service.getList();
		assertEquals(list.size(), result.size());
		assertEquals(list, result);
		
    	verify(service).getList();
	}
	
}

