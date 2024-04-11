package dataaccesslayer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.FoodItem;

public class FoodItemDAOImpl implements FoodItemDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void addFoodItem(FoodItem foodItem) {
        String query = "INSERT INTO FoodItems (RetailerID, Name, Quantity, ExpirationDate, Status, Price, IsSurplus, SurplusType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, foodItem.getRetailerID());
            ps.setString(2, foodItem.getName());
            ps.setInt(3, foodItem.getQuantity());
            ps.setDate(4, foodItem.getExpirationDate());
            ps.setString(5, foodItem.getStatus());
            ps.setBigDecimal(6, foodItem.getPrice());
            ps.setBoolean(7, foodItem.isSurplus());
            ps.setString(8, foodItem.getSurplusType());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFoodItem(FoodItem foodItem) {
        String query = "UPDATE FoodItems SET RetailerID = ?, Name = ?, Quantity = ?, ExpirationDate = ?, Status = ?, Price = ?, IsSurplus = ?, SurplusType = ? WHERE FoodItemID = ?";
        try {
            con = DataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, foodItem.getRetailerID());
            ps.setString(2, foodItem.getName());
            ps.setInt(3, foodItem.getQuantity());
            ps.setDate(4, foodItem.getExpirationDate());
            ps.setString(5, foodItem.getStatus());
            ps.setBigDecimal(6, foodItem.getPrice());
            ps.setBoolean(7, foodItem.isSurplus());
            ps.setString(8, foodItem.getSurplusType());
            ps.setInt(9, foodItem.getFoodItemID());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFoodItem(int foodItemId) {
        String query = "DELETE FROM FoodItems WHERE FoodItemID = ?";
        try {
            con = DataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, foodItemId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FoodItem getFoodItemById(int foodItemId) {
        // Implement logic to retrieve a food item by ID from the database
        return null; // Placeholder return value
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItemList = new ArrayList<>();
        // Implement logic to retrieve all food items from the database
        return foodItemList; // Placeholder return value
    }
}
