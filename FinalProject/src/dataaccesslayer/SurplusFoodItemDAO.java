package dataaccesslayer;
import java.util.List;

import Model.SurplusFoodItem;

public interface SurplusFoodItemDAO {
    void addSurplusFoodItem(SurplusFoodItem surplusFoodItem);
    void updateSurplusFoodItem(SurplusFoodItem surplusFoodItem);
    void deleteSurplusFoodItem(int surplusFoodItemId);
    SurplusFoodItem getSurplusFoodItemById(int surplusFoodItemId);
    List<SurplusFoodItem> getAllSurplusFoodItems();
}
