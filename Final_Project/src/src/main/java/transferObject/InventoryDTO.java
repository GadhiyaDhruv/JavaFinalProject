package transferObject;

public class InventoryDTO {

    private int itemId;
    private String itemName;
    private int quantity;
    private double price;
    private boolean isSurplus;

    public InventoryDTO(int itemId, String itemName, int quantity, double price, boolean isSurplus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.isSurplus = isSurplus;
    }

    public InventoryDTO(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.isSurplus = false; // Default to not surplus
    }

    public InventoryDTO() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSurplus() {
        return isSurplus;
    }

    public void setSurplus(boolean surplus) {
        isSurplus = surplus;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", isSurplus=" + isSurplus +
                '}';
    }
}
