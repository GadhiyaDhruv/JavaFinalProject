package Model;
import java.util.Date;

public class Claim {
    private int claimID;
    private int foodItemID;
    private int quantityClaimed;
    private Date claimDate;

    public Claim() {}

    public Claim(int foodItemID, int quantityClaimed, Date claimDate) {
        this.foodItemID = foodItemID;
        this.quantityClaimed = quantityClaimed;
        this.claimDate = claimDate;
    }

    public int getClaimID() {
        return claimID;
    }

    public void setClaimID(int claimID) {
        this.claimID = claimID;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getQuantityClaimed() {
        return quantityClaimed;
    }

    public void setQuantityClaimed(int quantityClaimed) {
        this.quantityClaimed = quantityClaimed;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }
}
