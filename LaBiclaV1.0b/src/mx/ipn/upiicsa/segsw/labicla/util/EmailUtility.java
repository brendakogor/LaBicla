package mx.ipn.upiicsa.segsw.labicla.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
public class EmailUtility 
{
	private static final String GMAIL_USER = "patito_feliz@gmail.com"; // PONER CUENTA DE EMAIL DE  GMAIL
	private static final String GMAIL_PASSWORD = "elqueagandallanobatalla";			// PONER PASSWORD DE GMAIL
	private static final Properties GMAIL_SERVER_PROPERTIES = new Properties();

	static {
		GMAIL_SERVER_PROPERTIES.put("mail.smtp.auth", "true");
		GMAIL_SERVER_PROPERTIES.put("mail.smtp.starttls.enable", "true");
		GMAIL_SERVER_PROPERTIES.put("mail.smtp.host", "smtp.gmail.com");
		GMAIL_SERVER_PROPERTIES.put("mail.smtp.port", "587");
	}
	/**
	 * 
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param props
	 * @param username
	 * @param password
	 * @throws MessagingException
	 */
	public static void sendEmail(String from, String to, String subject, String content, Properties props, String username, String password) throws MessagingException 
	{
		Session session = null;
		Message message = null;
		
		
		try {
			
			session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			
			message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(content);
			
			Transport.send(message);
		} 
		catch (MessagingException ex) 
		{
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public static void main(String[] args) throws MessagingException
	{
		sendEmail("upiicsa.swgsw@gmail.com","guillermart@gmail.com", "Testing Javamail","This is a test.", GMAIL_SERVER_PROPERTIES, GMAIL_USER, GMAIL_PASSWORD);
		
		System.out.println("Message sent.");
	}

}
