package dataAccessLayer;

import java.util.List;
import transferObject.UserDTO;

public interface UserDao {
    UserDTO getUserById(int userId);
    List<UserDTO> getAllUsers();
    void addUser(UserDTO user);
    void updateUser(UserDTO user);
    void deleteUser(int userId);
    boolean authenticateUser(String username, String password);
    String getUserType(String username, String password);
    UserDTO getUserByUsername(String username);
}
