<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="transferObject.InventoryDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Page</title>
    <link rel="stylesheet" href="./css/retailerStyle.css"> 
</head>
<body>

<div class="container">
    <h1>Inventory List</h1>
    <div id="inventory">
        <table>
            <thead>
                <tr>
                    <th>Item ID</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Surplus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<InventoryDTO> items = (List<InventoryDTO>) request.getAttribute("items");
                    if (items != null) {
                        for (InventoryDTO item : items) {
                %>
                    <tr>
                        <td><%= item.getItemId() %></td>
                        <td><%= item.getItemName() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td><%= item.getPrice() %></td>
                        <td><%= item.isSurPlus() ? "Yes" : "No" %></td>
                        <td>
                            <button onclick="editItem(<%= item.getItemId() %>)">Edit</button>
                        </td>
                    </tr>
                <% 
                        }
                    }else{
                %>
                    <tr>
                        <td colspan="6">No items found</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <button id="addItemBtn" onclick="showAddItemForm()">Add New Item</button>
</div>

<!-- Add Item Form Popup -->
<div id="addItemFormPopup" class="popup">
    <div class="popup-content">
        <span class="close" onclick="closeAddItemForm()">&times;</span>
        <h2>Add New Item</h2>
        <form id="addItemForm" action="addItemServlet" method="post">
            <label for="itemName">Item Name:</label>
            <input type="text" id="itemName" name="itemName" required><br>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required><br>
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" required><br>
            <input type="submit" value="Add Item To List">
        </form>
    </div>
</div>

<!-- Edit Item Form Popup -->
<div id="editItemFormPopup" class="popup">
    <div class="popup-content">
        <span class="close" onclick="closeEditItemForm()">&times;</span>
        <h2>Edit Item</h2>
        <form id="editItemForm" action="editItemServlet" method="post">
            <!-- Edit item form will be dynamically inserted here -->
        </form>
    </div>
</div>

<!-- Logout button -->
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>

<script>
// Function to open the add item form popup
function showAddItemForm() {
    var popup = document.getElementById("addItemFormPopup");
    popup.style.display = "block";
}

// Function to close the add item form popup
function closeAddItemForm() {
    var popup = document.getElementById("addItemFormPopup");
    popup.style.display = "none";
}

/* // Function to handle form submission and close popup
function onSubmit() {
    // Add your form submission logic here if needed
    // Close the popup
    closeAddItemForm();
    // Prevent default form submission
    return false;
} */
</script>

</body>
</html>
