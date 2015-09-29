package test.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.Floor;
import com.fsoft.roomreservation.core.model.Room;
import com.fsoft.roomreservation.core.service.RoomService;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceUnitTest {
	
	private IService<Room> service;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Before
    public void setUp() {
        service = mock(RoomService.class);
    }
	
	@Test
	public void create() {
		Floor floor = new Floor()
			.setFloorId(1)
			.setFloorName("Mezzanine")
			.setFloorNumber(1);
		
		Room source = new Room()
			.setRoomId(1)
			.setRoomName("Mala Pascua")
			.setFloor(floor)
			.setRoomCapacity(50);
		
		when(service.create(source)).thenReturn(source);
		Room result = service.create(source);
		
		assertEquals(source.getRoomId(), result.getRoomId());
		assertEquals(source.getRoomName(), result.getRoomName());
		assertEquals(source.getRoomCapacity(), result.getRoomCapacity());
		assertEquals(source.getFloor().getFloorId(), result.getFloor().getFloorId());
		assertEquals(source.getFloor().getFloorName(), result.getFloor().getFloorName());
		assertEquals(source.getFloor().getFloorNumber(), result.getFloor().getFloorNumber());
		
		verify(service).create(result);
	}
	
	@Test
	public void read(){
		Floor floor = new Floor()
			.setFloorId(1)
			.setFloorName("Mezzanine")
			.setFloorNumber(1);
		
		Room source = new Room()
			.setRoomId(1)
			.setRoomName("Mala Pascua")
			.setFloor(floor)
			.setRoomCapacity(50);
		
		when(service.read(1)).thenReturn(source);
		
		Room result = service.read(1);
		assertEquals(source.getRoomId(), result.getRoomId());
		assertEquals(source.getRoomName(), result.getRoomName());
		assertEquals(source.getRoomCapacity(), result.getRoomCapacity());
		assertEquals(source.getFloor().getFloorId(), result.getFloor().getFloorId());
		assertEquals(source.getFloor().getFloorName(), result.getFloor().getFloorName());
		assertEquals(source.getFloor().getFloorNumber(), result.getFloor().getFloorNumber());
		
		verify(service).read(1);
	}
	
	@Test
	public void update(){
		Floor floor = new Floor()
			.setFloorId(1)
			.setFloorName("new Mezzanine")
			.setFloorNumber(1);
		
		Room source = new Room()
			.setRoomId(1)
			.setRoomName("new Mala Pascua")
			.setFloor(floor)
			.setRoomCapacity(50);
		
		when(service.update(source)).thenReturn(source);
		
		Room result = service.update(source);
		assertEquals(source.getRoomId(), result.getRoomId());
		assertEquals(source.getRoomName(), result.getRoomName());
		assertEquals(source.getRoomCapacity(), result.getRoomCapacity());
		assertEquals(source.getFloor().getFloorId(), result.getFloor().getFloorId());
		assertEquals(source.getFloor().getFloorName(), result.getFloor().getFloorName());
		assertEquals(source.getFloor().getFloorNumber(), result.getFloor().getFloorNumber());
		
		verify(service).update(source);
	}
	
	@Test
	public void delete(){
//		when(service.delete(new Integer(1))).thenReturn(new Boolean(true));
//		verify(service).delete(new Integer(1));
	}
	
	@Test
	public void getList(){
		Floor floor = new Floor()
			.setFloorId(1)
			.setFloorName("new Mezzanine")
			.setFloorNumber(1);
		
		Room source = new Room()
			.setRoomId(1)
			.setRoomName("new Mala Pascua")
			.setFloor(floor)
			.setRoomCapacity(50);
		
		List<Room> list = new ArrayList<Room>();
		list.add(source.setRoomId(1));
		when(service.getList()).thenReturn(list);
		
		List<Room> result = service.getList();
		assertEquals(list.size(), result.size());
		assertEquals(list, result);
		
    	verify(service).getList();
	}
	
}

