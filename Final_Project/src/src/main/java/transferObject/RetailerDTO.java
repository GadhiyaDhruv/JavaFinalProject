package transferObject;

import java.util.List;

public class RetailerDTO extends UserDTO {

    private List<InventoryDTO> inventory;

    public RetailerDTO(String name, String email, UserType userType, List<InventoryDTO> inventory) {
        super(name, email, userType);
        this.inventory = inventory;
    }

    public RetailerDTO() {
        super();
    }

    public List<InventoryDTO> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryDTO> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "RetailerDTO{" +
                "inventory=" + inventory +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType=" + getUserType() +
                '}';
    }
}
