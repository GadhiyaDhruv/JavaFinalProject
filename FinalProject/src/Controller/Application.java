package Controller;

import java.util.Scanner;
import dataaccesslayer.UserDAO;
import dataaccesslayer.FoodItemDAO;
import dataaccesslayer.ClaimDAO;
import dataaccesslayer.SurplusFoodItemDAO;
import dataaccesslayer.UserDAOImpl;
import dataaccesslayer.FoodItemDAOImpl;
import dataaccesslayer.ClaimDAOImpl;
import dataaccesslayer.SurplusFoodItemDAOImpl;

public class Application {

    public static void main(String[] args) {
        // Create instances of DAOs and scanner
        UserDAO userDao = new UserDAOImpl();
        FoodItemDAO foodItemDao = new FoodItemDAOImpl();
        ClaimDAO claimDao = (ClaimDAO) new ClaimDAOImpl();
        SurplusFoodItemDAO surplusFoodItemDao = new SurplusFoodItemDAOImpl();
        Scanner scanner = new Scanner(System.in);

        // Create instances of controllers
        UserController userController = new UserController(userDao , scanner);
        FoodItemController foodItemController = new FoodItemController(foodItemDao, scanner);
        claimController claimController = new claimController(claimDao, scanner);
        SurplusFoodItemController surplusFoodItemController = new SurplusFoodItemController(surplusFoodItemDao, scanner);

        // Create instance of BusinessLogic
        BusinessLogic businessLogic = new BusinessLogic(userController, foodItemController, claimController, surplusFoodItemController, scanner);

        // Start the application
        businessLogic.start();
    }
}
