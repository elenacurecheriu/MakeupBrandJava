package Models;

import java.util.UUID;

public class LoyaltyCard {
    private String cardID;
    private int noOfPoints;
    private int customerID;

    public LoyaltyCard(String cardID, int noOfPoints, int customerID) {
        this.cardID = cardID;
        this.noOfPoints = noOfPoints;
        this.customerID = customerID;
    }

    public LoyaltyCard() {
        this.cardID = UUID.randomUUID().toString().substring(0, 10).toUpperCase();
        this.noOfPoints = 0;
        this.customerID = 0;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
