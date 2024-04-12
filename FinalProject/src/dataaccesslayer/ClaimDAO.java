package dataaccesslayer;
import java.util.List;

import Model.Claim;

public interface ClaimDAO {
    void addClaim(Claim claim);
    void updateClaim(Claim claim);
    void deleteClaim(int claimId);
    Claim getClaimById(int claimId);
    List<Claim> getAllClaims();
    List<Claim> getClaimsByFoodItemId(int foodItemId);
}
