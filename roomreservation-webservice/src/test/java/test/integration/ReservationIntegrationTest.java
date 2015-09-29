//package test.integration;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.RestTemplate;
//
//import com.fsoft.roomreservation.core.model.ClientResponseEntity;
//import com.fsoft.roomreservation.core.model.Reservation;
//import com.fsoft.roomreservation.core.model.Room;
//import com.fsoft.roomreservation.core.model.User;
//import com.fsoft.roomreservation.core.util.DateUtil;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:**/mvc-config.xml"})
//public class ReservationIntegrationTest {
//
//    private static final String URI = "http://localhost:8080/roomreservation-webservice/reservationmgt/";
//    private RestTemplate restTemplate = new RestTemplate();
//    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    
//    @Test
//    @SuppressWarnings("unchecked")
//    public void create() {
//    	Date reservationDate = DateUtil.toDate("2015-07-24 09:30:07", sdf); 
//		User user = new User()
//			.setUserid(1)
//			.setFirstName("teodoro")
//			.setLastName("dela cerna")
//			.setEmail("delacerna_teodoro@yahoo.com");
//		Room room = new Room()
//			.setRoomId(1)
//			.setRoomName("Mala Pascua");
//			
//		Reservation source = new Reservation()
//			.setUserId(1)
//			.setRoomId(1)
//			.setUser(user)
//			.setRoom(room)
//			.setTitle("DTV Interview")
//			.setDescription("DTV Interview")
//			.setReservationSchedule(reservationDate)
//			.setDuration(2);
//		
//        ClientResponseEntity<Reservation> response = restTemplate.postForObject(
//    			String.format("%screate",URI), 
//    			source, ClientResponseEntity.class
//			);
//        
//        assertNotNull(response);
//        assertEquals(200, response.getCode());
//        assertNotNull(response.getEntity());
//    }
//
//    @Test
//    @SuppressWarnings("unchecked")
//    public void read() {
//	  	ClientResponseEntity<Reservation> response = restTemplate.getForObject(
//				String.format("%sread/{id}",URI), 
//				ClientResponseEntity.class, 
//				new HashMap(){{put("id",114);}}
//			);
//	    
//        assertNotNull(response);
//        assertEquals(200, response.getCode());
//        assertNotNull(response.getEntity());
//    }
//
//    @Test
//    @SuppressWarnings("unchecked")
//    public void delete() {
////    	ClientResponseEntity<Reservation> clientResponse = restTemplate.postForObject(URI + "update", source, ClientResponseEntity.class);
////       
////		assertNotNull(clientResponse);
////		assertEquals(200, clientResponse.getCode());
////		assertNotNull( clientResponse.getEntity() );
//    }
//}
