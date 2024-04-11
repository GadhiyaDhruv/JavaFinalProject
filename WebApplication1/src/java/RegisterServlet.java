import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name = request.getParameter("name");
        String Email = request.getParameter("email");
        String Password = request.getParameter("password"); 
        String UserType = request.getParameter("userType");

        Connection connection = null;
        try {
            // Use DBConnection class to get database connection
            DatabaseConnector db = DatabaseConnector.getInstance();
           System.out.println("DatabaseConnector instance retrieved: " + db);

            connection = db.getConnection();

            String query = "INSERT INTO users (Name, Email, Password, UserType) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Name);
            statement.setString(2, Email);
            statement.setString(3, Password); 
            statement.setString(4, UserType);

            int result = statement.executeUpdate();
            if (result > 0) {
                response.sendRedirect("registration_success.html");
            } else {
                response.getWriter().println("Registration failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration: " + e.getMessage());
        } 
    }
}