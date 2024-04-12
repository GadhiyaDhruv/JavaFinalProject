package transferObject;

public class CharitableOrganizationDTO extends UserDTO {

    public CharitableOrganizationDTO(int userId, String name, String email) {
        super(userId, name, email, UserType.Charitable_Organization);
    }

    public CharitableOrganizationDTO() {
        super();
    }
}
