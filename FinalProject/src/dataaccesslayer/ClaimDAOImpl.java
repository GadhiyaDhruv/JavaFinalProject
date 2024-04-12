package dataaccesslayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Claim;

public class ClaimDAOImpl implements ClaimDAO {
    private Map<Integer, Claim> claims;

    public ClaimDAOImpl() {
        this.claims = new HashMap<>();
    }

    @Override
    public void addClaim(Claim claim) {
        claims.put(claim.getClaimID(), claim);
    }

    @Override
    public void updateClaim(Claim claim) {
        claims.put(claim.getClaimID(), claim);
    }

    @Override
    public void deleteClaim(int claimId) {
        claims.remove(claimId);
    }

    @Override
    public Claim getClaimById(int claimId) {
        return claims.get(claimId);
    }

    @Override
    public List<Claim> getAllClaims() {
        return new ArrayList<>(claims.values());
    }

    @Override
    public List<Claim> getClaimsByFoodItemId(int foodItemId) {
        List<Claim> result = new ArrayList<>();
        for (Claim claim : claims.values()) {
            if (claim.getFoodItemID() == foodItemId) {
                result.add(claim);
            }
        }
        return result;
    }
}
