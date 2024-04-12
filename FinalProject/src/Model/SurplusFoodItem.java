package Model;
import java.math.BigDecimal;
import java.util.Date;

public class SurplusFoodItem {
    private int surplusItemID;
    private int foodItemID;
    private Date listingDate;
    private BigDecimal salePrice;
    private boolean isDonation;

    public SurplusFoodItem() {}

    public SurplusFoodItem(int foodItemID, Date listingDate, BigDecimal salePrice, boolean isDonation) {
        this.foodItemID = foodItemID;
        this.listingDate = listingDate;
        this.salePrice = salePrice;
        this.isDonation = isDonation;
    }

    public int getSurplusItemID() {
        return surplusItemID;
    }

    public void setSurplusItemID(int surplusItemID) {
        this.surplusItemID = surplusItemID;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public java.sql.Date getListingDate() {
        return (java.sql.Date) listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isDonation() {
        return isDonation;
    }

    public void setDonation(boolean donation) {
        isDonation = donation;
    }
}
