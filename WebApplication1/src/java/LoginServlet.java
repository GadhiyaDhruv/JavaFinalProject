import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@jakarta.servlet.annotation.WebServlet("/LoginServlet")
public class LoginServlet extends jakarta.servlet.http.HttpServlet {
    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        String UserType = request.getParameter("userType");

        Connection connection = null;
        try {
            // Use DBConnection class to get database connection
            DatabaseConnector db = DatabaseConnector.getInstance();
           System.out.println("DatabaseConnector instance retrieved: " + db);

            connection = db.getConnection();

            String query = "SELECT * FROM users WHERE Email = ? AND Password = ? AND UserType = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Email);
            statement.setString(2, Password);
            statement.setString(3, UserType);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // User exists in the database
                // Redirect to appropriate page based on UserType
                String userTypeFromDB = resultSet.getString("UserType");
                switch (userTypeFromDB) {
                    case "retailer" -> response.sendRedirect("retailer");
                    case "consumer" -> response.sendRedirect("consumer");
                    case "charity" -> response.sendRedirect("charity");
                }
            } else {
                // User does not exist or invalid credentials
                response.getWriter().println("Login failed. Invalid credentials.");
            }
        } catch (SQLException e) {
            response.getWriter().println("Database error: " + e.getMessage());
        } 
    }
}