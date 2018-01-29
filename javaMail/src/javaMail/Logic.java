package javaMail;
//working but before run change password
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Logic {

	public static void main(String gh[]) {
		 // attachments
		 String message = "I have some attachments for you.";
        String[] attachFiles = new String[1];
        attachFiles[0] = "C:/Users/Vicky/Downloads/photos/index.png";
		sendmail("vivekdiscover17@gmail.com", "Test", "Test Body",attachFiles,message);// from mail
																	// data
	}

	public static void sendmail(String tomail, String sub, String body, String[] attachFiles, String message) {
		String to = tomail;
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vivekdiscover16@gmail.com", "password");// change
			}
		});
		// compose message
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(tomail));// change accordingly
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(sub);
			msg.setText(body);
			
			 // creates message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(message, "text/html");
	        
			   // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	 
	        // adds attachments
	        if (attachFiles != null && attachFiles.length > 0) {
	            for (String filePath : attachFiles) {
	                MimeBodyPart attachPart = new MimeBodyPart();
	 
	                try {
	                    attachPart.attachFile(filePath);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	 
	                multipart.addBodyPart(attachPart);
	            }
	        }
	 
	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);
			// send message
			Transport.send(msg);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
