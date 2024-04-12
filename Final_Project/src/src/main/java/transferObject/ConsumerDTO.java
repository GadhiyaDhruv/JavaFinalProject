package transferObject;

public class ConsumerDTO extends UserDTO {

    public ConsumerDTO(int userId, String name, String email) {
        super(userId, name, email, UserType.Consumer);
    }

    public ConsumerDTO() {
        super();
    }
}
