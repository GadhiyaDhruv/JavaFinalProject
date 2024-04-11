package dataaccesslayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;

public class UserDAOImpl implements UserDAO {
  
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO Users (Name, Email, Password, UserType) VALUES (?, ?, ?, ?)";
        try {
             con = DataSource.getConnection();
             ps = con.prepareStatement(query);
        
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUserType());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE Users SET Name = ?, Email = ?, Password = ?, UserType = ? WHERE UserID = ?";
        try {
             con = DataSource.getConnection();
             ps = con.prepareStatement(query);
         
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUserType());
            ps.setInt(5, user.getUserID());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        String query = "DELETE FROM Users WHERE UserID = ?";
        try {
             con = DataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
        
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int userId) {
        String query = "SELECT * FROM Users WHERE UserID = ?";
        try {
            con  = DataSource.getConnection();
             ps = con.prepareStatement(query);
        
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        rs.getString("UserType")
                    );
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM Users WHERE Email = ?";
        try {
            con  = DataSource.getConnection();
             ps = con.prepareStatement(query);
        
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                       
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        rs.getString("UserType")
                    );
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try {
            con  = DataSource.getConnection();
             ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                userList.add(new User(
                
                    rs.getString("Name"),
                    rs.getString("Email"),
                    rs.getString("Password"),
                    rs.getString("UserType")
                ));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return userList;
    }


}
