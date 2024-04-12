package Controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dataaccesslayer.FoodItemDAO;
import dataaccesslayer.FoodItemDAOImpl;
import Model.FoodItem;

public class FoodItemController {
    private FoodItemDAO foodItemDAO;

    public FoodItemController() {
        this.foodItemDAO = new FoodItemDAOImpl();
    }

    public FoodItemController(FoodItemDAO foodItemDao, Scanner scanner) {
		// TODO Auto-generated constructor stub
	}

	public void addFoodItem(int retailerID, String name, int quantity, Date expirationDate, String status, BigDecimal price, boolean isSurplus, String surplusType) {
        FoodItem foodItem = new FoodItem();
        foodItemDAO.addFoodItem(foodItem);
    }

    public void updateFoodItem( int retailerID, String name, int quantity, Date expirationDate, String status, BigDecimal price, boolean isSurplus, String surplusType) {
        FoodItem foodItem = new FoodItem(retailerID, surplusType, quantity, expirationDate, surplusType, price, isSurplus, surplusType);
        foodItemDAO.updateFoodItem(foodItem);
    }

    public void deleteFoodItem(int foodItemID) {
        foodItemDAO.deleteFoodItem(foodItemID);
    }

    public FoodItem getFoodItemById(int foodItemID) {
        return foodItemDAO.getFoodItemById(foodItemID);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemDAO.getAllFoodItems();
    }

	public void manageFoodItems() {
		// TODO Auto-generated method stub
		
	}

    // You can add more methods as needed for your application's requirements
}
