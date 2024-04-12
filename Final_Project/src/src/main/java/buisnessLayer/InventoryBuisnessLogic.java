package buisnessLayer;

import java.util.List;

import dataAccessImpl.InventoryDaoImpl;
import transferObject.InventoryDTO;

public class InventoryBuisnessLogic {

    private InventoryDaoImpl inventoryDao;

    public InventoryBuisnessLogic() {
        inventoryDao = new InventoryDaoImpl();
    }

    public InventoryDTO getInventoryItemById(int itemId) {
        return inventoryDao.getInventoryItemById(itemId);
    }

    public List<InventoryDTO> getAllInventoryItems() {
        return inventoryDao.getAllInventoryItems();
    }

    public List<InventoryDTO> getSurplusInventoryItems() {
        return inventoryDao.getSurplusInventoryItems();
    }

    public List<InventoryDTO> getExpiringInventoryItems(int daysUntilExpiration) {
        return inventoryDao.getExpiringInventoryItems(daysUntilExpiration);
    }

    public void addInventoryItem(InventoryDTO item) {
        inventoryDao.addInventoryItem(item);
    }

    public void updateInventoryItem(InventoryDTO item) {
        inventoryDao.updateInventoryItem(item);
    }

    public void deleteInventoryItem(int itemId) {
        inventoryDao.deleteInventoryItem(itemId);
    }
}
