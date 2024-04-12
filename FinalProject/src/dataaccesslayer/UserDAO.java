package dataaccesslayer;
import java.util.List;

import Model.User;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
	
}
