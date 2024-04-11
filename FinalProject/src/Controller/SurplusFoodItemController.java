package Controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import dataaccesslayer.SurplusFoodItemDAO;
import dataaccesslayer.SurplusFoodItemDAOImpl;
import Model.SurplusFoodItem;

public class SurplusFoodItemController {
    private SurplusFoodItemDAO surplusFoodItemDAO;

    public SurplusFoodItemController() {
        this.surplusFoodItemDAO = new SurplusFoodItemDAOImpl();
    }

    public void addSurplusFoodItem(int foodItemID, Date listingDate, BigDecimal salePrice, boolean isDonation) {
        SurplusFoodItem surplusFoodItem = new SurplusFoodItem(foodItemID, listingDate, salePrice, isDonation);
        surplusFoodItemDAO.addSurplusFoodItem(surplusFoodItem);
    }

    public void updateSurplusFoodItem( int foodItemID, Date listingDate, BigDecimal salePrice, boolean isDonation) {
        SurplusFoodItem surplusFoodItem = new SurplusFoodItem( foodItemID, listingDate, salePrice, isDonation);
        surplusFoodItemDAO.updateSurplusFoodItem(surplusFoodItem);
    }

    public void deleteSurplusFoodItem(int surplusItemID) {
        surplusFoodItemDAO.deleteSurplusFoodItem(surplusItemID);
    }

    public SurplusFoodItem getSurplusFoodItemById(int surplusItemID) {
        return surplusFoodItemDAO.getSurplusFoodItemById(surplusItemID);
    }

    public List<SurplusFoodItem> getAllSurplusFoodItems() {
        return surplusFoodItemDAO.getAllSurplusFoodItems();
    }

    // You can add more methods as needed for your application's requirements
}
