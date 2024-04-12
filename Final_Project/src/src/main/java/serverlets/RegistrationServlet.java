package serverlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transferObject.UserDTO;
import transferObject.UserType;
import buisnessLayer.UserBuisnessLogic;

import java.io.IOException;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBuisnessLogic userRegistration;

    @Override
    public void init() throws ServletException {
        super.init();
        userRegistration = new UserBuisnessLogic(); // Initialize the UserBuisnessLogic
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String userTypeString = request.getParameter("userType");

        UserType userType = null;

        // Handling possible IllegalArgumentException
        try {
            userType = UserType.valueOf(userTypeString.replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            // Handle invalid user type
            e.printStackTrace();
        }

        String subscribe = request.getParameter("subscribe");
        boolean isSubscribe = "yes".equals(subscribe);

        String notificationMethod = null;

        // Check if user subscribed to alerts and retrieve the selected notification method
        if (subscribe != null && subscribe.equals("yes")) {
            // Check if SMS notification is selected
            if (request.getParameter("smsNotification") != null) {
                notificationMethod = "sms";
            }
            // Check if Email notification is selected
            else if (request.getParameter("emailNotification") != null) {
                notificationMethod = "email";
            }
        }

        UserDTO user = new UserDTO(name, email, password, userType, isSubscribe);

        // Adding user to the database using the UserBuisnessLogic
        userRegistration.addUser(user);

        // Redirecting to LoginServlet after registration
        response.sendRedirect(request.getContextPath() + "/LoginServlet");
    }
}
