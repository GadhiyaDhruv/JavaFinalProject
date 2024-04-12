package buisnessLayer;

import java.util.List;

import dataAccessImpl.UserDaoImpl;
import transferObject.UserDTO;

public class UserBuisnessLogic {

    private UserDaoImpl userDao;

    public UserBuisnessLogic() {
        userDao = new UserDaoImpl();
    }

    public UserDTO getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public List<UserDTO> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void addUser(UserDTO user) {
        userDao.addUser(user);
    }

    public void updateUser(UserDTO updatedUser) {
        userDao.updateUser(updatedUser);
    }

    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }
}
