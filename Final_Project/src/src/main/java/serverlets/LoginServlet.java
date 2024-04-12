package serverlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dataAccessImpl.UserDaoImpl;
import dataAccessLayer.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDaoImpl(); // Initialize the UserDao implementation
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isAuthenticated = userDao.authenticateUser(username, password);
        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Retrieve userType from the database
            String userType = userDao.getUserType(username, password);

            // Redirect the user based on userType
            switch (userType) {
                case "Retailer":
                    response.sendRedirect(request.getContextPath() + "/RetailerServlet");
                    break;
                case "Consumer":
                    response.sendRedirect(request.getContextPath() + "/ConsumerServlet");
                    break;
                case "Charitable_Organization":
                    response.sendRedirect(request.getContextPath() + "/CharitableServlet");
                    break;
                default:
                    // Handle if userType is unknown or not specified
                    break;
            }
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
