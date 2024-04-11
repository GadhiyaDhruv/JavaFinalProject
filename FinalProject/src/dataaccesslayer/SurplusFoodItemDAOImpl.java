package dataaccesslayer;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SurplusFoodItem;


public class SurplusFoodItemDAOImpl implements SurplusFoodItemDAO {

	

	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	
    @Override
    public void addSurplusFoodItem(SurplusFoodItem surplusFoodItem) {
        String query = "INSERT INTO SurplusFoodItems (FoodItemID, ListingDate, SalePrice, IsDonation) VALUES (?, ?, ?, ?)";
        try {
            con  = DataSource.getConnection();
             ps = con.prepareStatement(query);
       
            ps.setInt(1, surplusFoodItem.getFoodItemID());
            ps.setDate(2, surplusFoodItem.getListingDate());
            ps.setBigDecimal(3, surplusFoodItem.getSalePrice());
            ps.setBoolean(4, surplusFoodItem.isDonation());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSurplusFoodItem(SurplusFoodItem surplusFoodItem) {
        String query = "UPDATE SurplusFoodItems SET ListingDate = ?, SalePrice = ?, IsDonation = ? WHERE SurplusItemID = ?";
        try {
            con  = DataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
        
            ps.setDate(1, surplusFoodItem.getListingDate());
            ps.setBigDecimal(2, surplusFoodItem.getSalePrice());
            ps.setBoolean(3, surplusFoodItem.isDonation());
            ps.setInt(4, surplusFoodItem.getSurplusItemID());
            ps.executeUpdate();
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSurplusFoodItem(int surplusFoodItemId) {
        String query = "DELETE FROM SurplusFoodItems WHERE SurplusItemID = ?";
        try {
            con  = DataSource.getConnection();
             ps = con.prepareStatement(query);
        
            ps.setInt(1, surplusFoodItemId);
            ps.executeUpdate();
        } catch (SQLException | IOException  e) {
            e.printStackTrace();
        }
    }

    @Override
    public SurplusFoodItem getSurplusFoodItemById(int surplusFoodItemId) {
        // Implement logic to retrieve a surplus food item by ID from the database
        return null; // Placeholder return value
    }

    @Override
    public List<SurplusFoodItem> getAllSurplusFoodItems() {
        List<SurplusFoodItem> surplusFoodItemList = new ArrayList<>();
        // Implement logic to retrieve all surplus food items from the database
        return surplusFoodItemList; // Placeholder return value
    }


		
	}

