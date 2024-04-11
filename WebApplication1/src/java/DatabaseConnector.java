import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static DatabaseConnector instance;
    private Connection connection;
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/FWRP";
    private static final String USER = "yash";
    private static final String PASSWORD = "yashan";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    // Private constructor to prevent instantiation
    private DatabaseConnector() {
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(SERVER_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnector.class) {
                if (instance == null) {
                    instance = new DatabaseConnector();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}