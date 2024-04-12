package dataAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.DataSource;
import dataAccessLayer.UserDao;
import transferObject.UserDTO;
import transferObject.UserType;

public class UserDaoImpl implements UserDao {

    @Override
    public UserDTO getUserById(int userId) {
        UserDTO user = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE userid = ?")) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new UserDTO();
                    user.setUserId(rs.getInt("userid"));
                    user.setName(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setUserType(UserType.valueOf(rs.getString("usertype")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Users");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getInt("userid"));
                user.setName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserType(UserType.valueOf(rs.getString("usertype")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(UserDTO user) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Users (username,email,password,usertype) VALUES (?,?,?,?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUserType().name());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UserDTO user) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Users SET username=?, email=?, password=?, usertype=? WHERE userid=?")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUserType().name());
            ps.setInt(5, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Users WHERE userid=?")) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        boolean isValidUser = false;
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                isValidUser = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValidUser;
    }

    @Override
    public String getUserType(String username, String password) {
        String userType = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT usertype FROM users WHERE username =? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    userType = rs.getString("usertype");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }
}
