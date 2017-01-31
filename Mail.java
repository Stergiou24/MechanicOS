import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mail {
	static Properties mailp;
	static Session mails;
	static MimeMessage msg;
	public static void generateAndSendEmail(String mail,String username,String password) throws AddressException, MessagingException {
		mailp = System.getProperties();
		mailp.put("mail.smtp.port", "587");
		mailp.put("mail.smtp.auth", "true");
		mailp.put("mail.smtp.starttls.enable", "true");
		mails = Session.getDefaultInstance(mailp, null);
		msg = new MimeMessage(mails);
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
		msg.addRecipient(Message.RecipientType.CC, new InternetAddress("stergiou24@gmail.com"));
		msg.setSubject("Username and Password from Company");
		String email = "Username: " +username+"<br>"+"Password: "+password+"<br><br> Regards, <br>THE DEVs : Mhnas Saker, Vaggelis Kallipolitis, Thanos Papakwnstantinou";
		msg.setContent(email, "text/html");
		Transport trans = mails.getTransport("smtp");
		trans.connect("smtp.gmail.com", "stergiou24@gmail.com", "stergiousniper");
		trans.sendMessage(msg, msg.getAllRecipients());
		trans.close();
	}
}