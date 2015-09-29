package com.fsoft.roomreservation.core.service.email;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.model.Room;
import com.fsoft.roomreservation.core.model.User;
import com.fsoft.roomreservation.core.util.CommonUtil;
import com.fsoft.roomreservation.core.util.Constants;
import com.fsoft.roomreservation.core.util.DateUtil;
import com.fsoft.roomreservation.core.util.PropertyUtil;

@Service
public class EmailService {
	
	private static final String APP_PROPERTIES = "./app.properties";
	Session session;
	
	@Autowired
	IService<Reservation> reservationSvc;
	
	@Autowired
	IService<User> userSvc;
	
	@Autowired
	IService<Room> roomSvc;
	
	public EmailService(){
		init();
	}
	
	public void init(){
		Properties props = new Properties();
		InputStream inputStream = null;
		try{
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(APP_PROPERTIES);
			props.load(inputStream);
			for( String key : props.stringPropertyNames()){
				if( null == System.getProperty(key) ){
					System.setProperty(key, props.getProperty(key));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			// log failed to load property
		}finally{
			CommonUtil.closeQuitely(inputStream);
		}
		
		props.put("mail.smtp.host", PropertyUtil.get(Constants.MAIL_SMTP_HOST));
		props.put("mail.smtp.starttls.enable", PropertyUtil.get(Constants.MAIL_SMTP_STARTTLS_ENABLE));
		props.put("mail.smtp.auth", PropertyUtil.get(Constants.MAIL_SMTP_AUTH));
		props.put("mail.smtp.port", PropertyUtil.get(Constants.MAIL_SMTP_PORT));
		props.put("mail.smtp.connectiontimeout", PropertyUtil.get(Constants.MAIL_SMTP_CONN_TIMEOUT));
		props.put("mail.smtp.timeout", PropertyUtil.get(Constants.MAIL_SMTP_TIMEOUT));

        session = Session.getInstance(props);
        if( PropertyUtil.getBoolean(Constants.MAIL_SMTP_DEBUG) ){
        	session.setDebug(true);
        }
        
        Properties vprops = new Properties();
        vprops.put("resource.loader", "class");
        vprops.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        
        Velocity.init(vprops);
	}
	
	public void sendEmail( Integer reservationid ){
		Reservation reservation = reservationSvc.read(reservationid);
		sendEmail(reservation);
	}
	
	public void sendEmail( final Reservation reservation ){
		new Thread(new Runnable(){
			public void run() {
				Transport transport = null;
				try{
					transport = session.getTransport("smtp");
					if(PropertyUtil.getBoolean(Constants.MAIL_SMTP_AUTH)){
						String emailUser = PropertyUtil.get(Constants.MAIL_SMTP_USER);
						String emailPwd = PropertyUtil.get(Constants.MAIL_SMTP_PWD);
						transport.connect(emailUser, emailPwd);
					}else{
						transport.connect();
					}
					
					try{
						MimeMessage emailMsg = createMessage( reservation );
						// logger sending email to user
						
						transport.sendMessage(emailMsg, emailMsg.getAllRecipients());
					}catch( MessagingException mex ){
						mex.printStackTrace();
					}catch( Exception ex ){
						ex.printStackTrace();
						if(!transport.isConnected()){
							ex = new SocketTimeoutException();
						}
						
						throw new MessagingException(ex.getMessage(), ex);
					}
				}catch( AuthenticationFailedException aex ){
					throw new IllegalStateException(aex);
				}catch( MessagingException ex ){
					Exception next = ex.getNextException();
					if( next instanceof SocketTimeoutException ){
						sendEmail( reservation );
					}
				}finally{
					if( transport != null ){
						try{
							transport.close();
						}catch( MessagingException ex ){
							ex.printStackTrace();
						}
					}
				}
			}
		}).start();;
		
	}
	
	private MimeMessage createMessage( Reservation reservation ) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder message = new StringBuilder();
		User user = reservation.getUser();
		Room room = reservation.getRoom();
		
		Date schedule = reservation.getReservationSchedule();
		int duration = reservation.getDuration();
		String start_time = DateUtil.getDate(schedule, sdf);
		String end_time = DateUtil.getDate(DateUtil.getIncDate(schedule,duration, Calendar.MINUTE), sdf);
		
		if( null != reservation.getReservationid() ){
			message.append(" Is Now Available.");
		}else{
			// read the room and get the user for negotiation
			message.append(" Is No Longer Available.");
		}
		
		String sender = PropertyUtil.get(Constants.MAIL_SMTP_SENDER);
		String subject = String.format("Reservation for %s (%s - %s)",room.getRoomName(), start_time, end_time);
		String[] recipients = user.getEmail().split(",");
		Date sentDate = new Date();
		MimeMessage emailMsg = new MimeMessage(session);
		
        StringWriter writer = new StringWriter();
        VelocityContext vc = new VelocityContext();
        vc.put("user", user);
        vc.put("subject", subject);
        vc.put("message", String.format("%s %s", subject, message.toString()));
        vc.put("currdate", sentDate);
        vc.put("formatter", sdf);
        vc.put("helper", this);
        Velocity.mergeTemplate(PropertyUtil.get("email.template"), Velocity.ENCODING_DEFAULT, vc, writer);
        
        emailMsg.setSentDate( sentDate );
		emailMsg.setFrom( new InternetAddress(sender) );
		Set<InternetAddress> addresses = new HashSet<InternetAddress>();
		for(String add : recipients ){
			try{
				InternetAddress address = new InternetAddress(add);
				address.validate();
				addresses.add( address );
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
        emailMsg.setRecipients( Message.RecipientType.TO, addresses.toArray(new InternetAddress[]{}) );
        emailMsg.setSubject( subject );
        emailMsg.setContent( writer.toString(), "text/html" );
        
		return emailMsg;
	}
	
	
	
}
