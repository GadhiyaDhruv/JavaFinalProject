package buisnessLayer;

import java.util.ArrayList;
import java.util.List;

import transferObject.RetailerDTO;

public class RetailerBuisnessLogic {

    private List<RetailerDTO> retailers;

    public RetailerBuisnessLogic() {
        retailers = new ArrayList<>();
    }

    public RetailerDTO getRetailerById(int userId) {
        for (RetailerDTO retailer : retailers) {
            if (retailer.getUserId() == userId) {
                return retailer;
            }
        }
        return null;
    }

    public List<RetailerDTO> getAllRetailers() {
        return retailers;
    }

    public void addRetailer(RetailerDTO retailer) {
        retailers.add(retailer);
    }

    public void updateRetailer(RetailerDTO updatedRetailer) {
        for (int i = 0; i < retailers.size(); i++) {
            RetailerDTO retailer = retailers.get(i);
            if (retailer.getUserId() == updatedRetailer.getUserId()) {
                retailers.set(i, updatedRetailer);
                return;
            }
        }
    }

    public void deleteRetailer(int userId) {
        retailers.removeIf(retailer -> retailer.getUserId() == userId);
    }
}
