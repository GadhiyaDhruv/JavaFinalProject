package transferObject;

import notificationSystem.NotificationService;

public class UserDTO {
    private int userId;
    private String name;
    private String email;
    private String password;
    private UserType userType;
    private boolean isSubscribed;
    private NotificationService notificationType;

    // Constructor
    public UserDTO(String name, String email, String password, UserType userType, boolean isSubscribed) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.isSubscribed = isSubscribed;
    }

    public UserDTO(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public UserDTO() {
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public NotificationService getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationService notificationType) {
        this.notificationType = notificationType;
    }
}