package Model;
import java.awt.JobAttributes.SidesType;
import java.io.ObjectInputFilter.Status;
import java.math.BigDecimal;
import java.util.Date;

public class FoodItem {
    private int foodItemID;
    private int retailerID;
    private String name;
    private int quantity;
    private Date expirationDate;
    private String status;
    private BigDecimal price;
    private boolean isSurplus;
    private String surplusType;

    public FoodItem() {}

    public FoodItem(int retailerID, String name, int quantity, Date expirationDate, String status, BigDecimal price, boolean isSurplus, String surplusType) {
        this.retailerID = retailerID;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.status = status;
        this.price = price;
        this.isSurplus = isSurplus;
        this.surplusType = surplusType;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getRetailerID() {
        return retailerID;
    }

    public void setRetailerID(int retailerID) {
        this.retailerID = retailerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public java.sql.Date getExpirationDate() {
        return (java.sql.Date) expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isSurplus() {
        return isSurplus;
    }

    public void setSurplus(boolean surplus) {
        isSurplus = surplus;
    }

    public String getSurplusType() {
        return surplusType;
    }

    public void setSurplusType(String surplusType) {
        this.surplusType = surplusType;
    }
}
