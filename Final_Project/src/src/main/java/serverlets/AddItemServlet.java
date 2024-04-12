package serverlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transferObject.InventoryDTO;
import dataAccessImpl.InventoryDaoImpl;
import dataAccessLayer.InventoryDao;

import java.io.IOException;

@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InventoryDao inventoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        inventoryDao = new InventoryDaoImpl(); // Initialize the InventoryDao implementation
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        boolean surplus = request.getParameter("surplus") != null;

        // Create a new InventoryDTO object with the retrieved parameters
        InventoryDTO newItem = new InventoryDTO(itemName, quantity, price, surplus);

        // Add the new item to the database using the InventoryDao
        inventoryDao.addInventoryItem(newItem);

        // Redirect to the RetailerServlet after adding the item
        response.sendRedirect(request.getContextPath() + "/RetailerServlet");
    }
}
