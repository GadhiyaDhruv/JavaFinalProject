package dataAccessLayer;

import java.util.List;
import transferObject.InventoryDTO;

public interface InventoryDao {
    InventoryDTO getInventoryItemById(int itemId);
    List<InventoryDTO> getAllInventoryItems();
    List<InventoryDTO> getSurplusInventoryItems();
    List<InventoryDTO> getExpiringInventoryItems(int daysUntilExpiration);
    List<InventoryDTO> getInventoryItemsByName(String itemName);
    void addInventoryItem(InventoryDTO item);
    void updateInventoryItem(InventoryDTO item);
    void deleteInventoryItem(int itemId);
    void deleteExpiredItems();
}
