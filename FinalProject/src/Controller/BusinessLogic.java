
	package Controller;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class BusinessLogic {

	    private UserController userController;
	    private FoodItemController foodItemController;
	    private claimController claimController;
	   
	    private Scanner scanner;

	    public BusinessLogic(UserController userController, FoodItemController foodItemController, claimController claimController, SurplusFoodItemController SurplusFoodItemController, Scanner scanner) {
	        this.userController = userController;
	        this.foodItemController = foodItemController;
	        this.claimController = claimController;
	        
	        this.scanner = scanner;
	    }

	    public void start() {
	        initializeDatabase();
	        System.out.println("Welcome to FWRP Project!");
	        displayMenu();
	    }

	    private void initializeDatabase() {
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "username", "password");
	             Statement statement = connection.createStatement()) {

	            // Drop the FWRP database if it exists
	            statement.executeUpdate("DROP DATABASE IF EXISTS FWRP");

	            // Create the FWRP database
	            statement.executeUpdate("CREATE DATABASE FWRP");

	            // Select the FWRP database for use
	            statement.executeUpdate("USE FWRP");

	            // Create the Users table
	            statement.executeUpdate("CREATE TABLE Users (UserID INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255) NOT NULL, Email VARCHAR(255) UNIQUE NOT NULL, Password VARCHAR(255) NOT NULL, UserType ENUM('retailer', 'consumer', 'charity') NOT NULL)");

	            // Create the FoodItems table
	            statement.executeUpdate("CREATE TABLE FoodItems (FoodItemID INT AUTO_INCREMENT PRIMARY KEY, RetailerID INT, Name VARCHAR(255) NOT NULL, Quantity INT NOT NULL, ExpirationDate DATE NOT NULL, Status ENUM('available', 'discounted', 'donated') NOT NULL DEFAULT 'available', Price DECIMAL(10,2) NOT NULL, IsSurplus BOOLEAN NOT NULL DEFAULT FALSE, SurplusType ENUM('donation', 'sale') DEFAULT NULL, FOREIGN KEY (RetailerID) REFERENCES Users(UserID) ON DELETE CASCADE)");

	            // Create the SurplusFoodItems table
	            statement.executeUpdate("CREATE TABLE SurplusFoodItems (SurplusItemID INT AUTO_INCREMENT PRIMARY KEY, FoodItemID INT, ListingDate DATETIME DEFAULT CURRENT_TIMESTAMP, SalePrice DECIMAL(10,2), IsDonation BOOLEAN NOT NULL, FOREIGN KEY (FoodItemID) REFERENCES FoodItems(FoodItemID) ON DELETE CASCADE)");

	            // Create the Claims table
	            statement.executeUpdate("CREATE TABLE Claims (ClaimID INT AUTO_INCREMENT PRIMARY KEY, FoodItemID INT, QuantityClaimed INT, ClaimDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (FoodItemID) REFERENCES FoodItems(FoodItemID))");

	            System.out.println("Database initialized successfully.");

	        } catch (SQLException e) {
	            System.err.println("Error initializing database: " + e.getMessage());
	        }
	    }

	    private void displayMenu() {
	        System.out.println("1. User Management");
	        System.out.println("2. Food Item Management");
	        System.out.println("3. Transaction Management");
	        System.out.println("4. Retailer Management");
	        System.out.println("5. Inventory Management");
	        System.out.println("6. Charitable Organization Management");
	        System.out.println("7. Exit");

	        int choice = scanner.nextInt();
	        scanner.nextLine();

	        switch (choice) {
	            case 1:
	                userController.manageUsers();
	                break;
	            case 2:
	                foodItemController.manageFoodItems();
	                break;
	            case 3:
	                claimController.manageClaims();
	                break;
	            case 4:
	                SurplusFoodItemController.manageSurplusFoodItem();
	                break;
	            case 5:
	                System.out.println("Exiting...");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                displayMenu();
	                break;
	        }
	    }
	}
