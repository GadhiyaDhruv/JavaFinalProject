package Controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dataaccesslayer.ClaimDAO;
import dataaccesslayer.ClaimDAOImpl;
import Model.Claim;

public class claimController {
    private ClaimDAO claimDAO;

    public claimController() {
        this.claimDAO = (ClaimDAO) new ClaimDAOImpl();
    }

    public claimController(ClaimDAO claimDao2, Scanner scanner) {
		// TODO Auto-generated constructor stub
	}

	public void addClaim(int foodItemID, int quantityClaimed, Date claimDate) {
        Claim claim = new Claim(foodItemID, quantityClaimed, claimDate);
        claimDAO.addClaim(claim);
    }

    public void updateClaim( int foodItemID, int quantityClaimed, Date claimDate) {
        Claim claim = new Claim( foodItemID, quantityClaimed, claimDate);
        claimDAO.updateClaim(claim);
    }

    public void deleteClaim(int claimID) {
        claimDAO.deleteClaim(claimID);
    }

    public Claim getClaimById(int claimID) {
        return claimDAO.getClaimById(claimID);
    }

    public List<Claim> getAllClaims() {
        return claimDAO.getAllClaims();
    }

	public static void manageClaims() {
		// TODO Auto-generated method stub
		
	}

    // You can add more methods as needed for your application's requirements
}
