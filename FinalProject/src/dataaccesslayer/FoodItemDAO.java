package dataaccesslayer;
import java.util.List;

import Model.FoodItem;

public interface FoodItemDAO {
    void addFoodItem(FoodItem foodItem);
    void updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(int foodItemId);
    FoodItem getFoodItemById(int foodItemId);
    List<FoodItem> getAllFoodItems();
}
