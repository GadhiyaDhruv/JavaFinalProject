<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="transferObject.InventoryDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory List</title>
    <link rel="stylesheet" href="./css/consumerStyle.css">
</head>
<body>

<div class="container">
    <h1>Inventory List</h1>
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
                List<InventoryDTO> items = (List<InventoryDTO>) request.getAttribute("surplusItems");
                if (items != null && !items.isEmpty()) {
                    for (InventoryDTO item : items) {
            %>
                <tr>
                    <td><%= item.getItemId() %></td>
                    <td><%= item.getItemName() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>$<%= item.getPrice() %></td>
                    <td><%= item.isSurPlus() ? "Yes" : "No" %></td>
                    <td>
                        <button onclick="editItem(<%= item.getItemId() %>)">Claim</button>
                    </td>
                </tr>
            <% 
                    }
                } else {
            %>
                <tr>
                    <td colspan="6">No items found</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>