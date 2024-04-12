package notificationSystem;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import transferObject.UserDTO;

public class EmailNotificationService implements NotificationService {

    private static final String EMAIL_HOST = "your_email_host";
    private static final String EMAIL_PORT = "your_email_port";
    private static final String EMAIL_USERNAME = "your_email_username";
    private static final String EMAIL_PASSWORD = "your_email_password";

    @Override
    public void sendNotification(UserDTO user, String message) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.port", EMAIL_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(EMAIL_USERNAME));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
            emailMessage.setSubject("Notification");
            emailMessage.setText(message);
            Transport.send(emailMessage);
            System.out.println("Email notification sent successfully to " + user.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
