package Controller;
import java.util.List;
import java.util.Scanner;

import dataaccesslayer.UserDAO;
import dataaccesslayer.UserDAOImpl;
import Model.User;

public class UserController {
    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAOImpl();
    }

    public UserController(UserDAO userDao, Scanner scanner) {
		// TODO Auto-generated constructor stub
	}

	public void addUser(String name, String email, String password, String userType) {
        User user = new User(name, email, password, userType);
        userDAO.addUser(user);
    }

    public void updateUser( String name, String email, String password, String userType) {
        User user = new User( name, email, password, userType);
        userDAO.updateUser(user);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

	public void manageUsers() {
		// TODO Auto-generated method stub
		
	}

	
    // You can add more methods as needed for your application's requirements
}
