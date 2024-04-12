package serverlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transferObject.InventoryDTO;
import dataAccessImpl.InventoryDaoImpl;
import dataAccessLayer.InventoryDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/ConsumerServlet")
public class ConsumerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InventoryDao inventoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        inventoryDao = new InventoryDaoImpl(); // Initialize the InventoryDao implementation
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InventoryDTO> allItems = inventoryDao.getAllInventoryItems();

        // Set the attribute to pass the items to the JSP page
        request.setAttribute("allItems", allItems);

        // Forward the request to the Consumer.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("Consumer.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed
        doGet(request, response);
    }
}
