package serverlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import dataAccessLayer.InventoryDao;
import dataAccessImpl.InventoryDaoImpl;
import transferObject.InventoryDTO;

@WebServlet("/RetailerServlet")
public class RetailerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InventoryDao inventoryDao;

    public RetailerServlet() {
        super();
        inventoryDao = new InventoryDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all items from the database
        List<InventoryDTO> items = inventoryDao.getAllInventoryItems();

        // Set the attribute to pass the items to the JSP page
        request.setAttribute("items", items);

        // Forward the request to the retailer.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("retailer.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Create InventoryDTO object with the retrieved parameters
        InventoryDTO newItem = new InventoryDTO(itemName, quantity, price);

        // Add the new item to the database using the InventoryDao
        inventoryDao.addInventoryItem(newItem);

        // Redirect back to the doGet method to refresh the page with updated inventory
        response.sendRedirect(request.getContextPath() + "/RetailerServlet");
    }
}
