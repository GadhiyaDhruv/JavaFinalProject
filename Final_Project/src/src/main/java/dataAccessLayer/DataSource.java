package dataAccessLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/foodwastereduction";
    private static final String USER = "root";
    private static final String PASSWORD = "Dgadhiya@20";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    // Private constructor to prevent instantiation
    private DataSource() {}

    public static Connection getConnection() throws IOException, SQLException {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(SERVER_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new IOException("Failed to obtain database connection", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
