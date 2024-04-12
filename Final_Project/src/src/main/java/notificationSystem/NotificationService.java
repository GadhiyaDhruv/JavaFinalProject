package notificationSystem;

import transferObject.UserDTO;

public interface NotificationService {

    void sendNotification(UserDTO user, String message);

    void sendNotification(UserDTO user, String message, String subject);

    void sendHtmlNotification(UserDTO user, String htmlMessage, String subject);
}
