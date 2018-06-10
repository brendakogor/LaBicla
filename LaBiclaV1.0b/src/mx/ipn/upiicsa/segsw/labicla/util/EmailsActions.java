package mx.ipn.upiicsa.segsw.labicla.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailsActions {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
        /*public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail("hola");
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}*/
 
	public static void generateAndSendEmail(String email,String password) throws AddressException, MessagingException {
 
//Step1		
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2		
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
		generateMailMessage.setSubject("Gracias por registrarte");
		String emailBody = email +"<br><br> Su contrase�a es: "+password+", <br>La Bicla Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
//Step3		
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		
		// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
		transport.connect("smtp.gmail.com", "movecoins@gmail.com", "Noe199710");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	
	public static void setAndSendEmail(String email,String password) throws AddressException, MessagingException {
		 
		//Step1		
				System.out.println("\n 1st ===> setup Mail Server Properties..");
				mailServerProperties = System.getProperties();
		        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				mailServerProperties.put("mail.smtp.port", "587");
				mailServerProperties.put("mail.smtp.auth", "true");
				mailServerProperties.put("mail.smtp.starttls.enable", "true");
				System.out.println("Mail Server Properties have been setup successfully..");
		 
		//Step2		
				System.out.println("\n\n 2nd ===> get Mail Session..");
				getMailSession = Session.getDefaultInstance(mailServerProperties, null);
				generateMailMessage = new MimeMessage(getMailSession);
				generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				
				generateMailMessage.setSubject("Gracias por registrarte");
				String emailBody = email +"<br><br> Su contrase�a temporal es: "+password+", <br>La Bicla Admin";
				generateMailMessage.setContent(emailBody, "text/html");
				System.out.println("Mail Session has been created successfully..");
		 
		//Step3		
				System.out.println("\n\n 3rd ===> Get Session and Send mail");
				Transport transport = getMailSession.getTransport("smtp");
				
				// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
				transport.connect("smtp.gmail.com", "movecoins@gmail.com", "Noe199710");
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
				transport.close();
			}
	
        public static void password(String email,String mensaje,String pass) throws AddressException, MessagingException {
 
//Step1		
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
                mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2		
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
		generateMailMessage.setSubject("Recuperaci�n de password");
		String emailBody = email +"<br><br>"+mensaje+"<br><br>tu contrase&ntilde;a; "+pass+ "<br><br> Gracias por formar parte de movecoin, <br>MoveCoin Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
//Step3		
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		
		// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
		transport.connect("smtp.gmail.com", "movecoins@gmail.com", "Noe199710");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}