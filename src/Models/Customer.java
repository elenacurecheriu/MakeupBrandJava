package Models;

import java.util.ArrayList;

public class Customer extends Account {
    private ArrayList<Purchase> purchaseHistory;
    private ArrayList<Appointment> appointmentHistory;
    private LoyaltyCard loyaltyCard;

    public Customer(String name, String username, String password, String email) {
        super(name, username, password, email);
        this.purchaseHistory = new ArrayList<>();
        this.appointmentHistory = new ArrayList<>();
        this.loyaltyCard = new LoyaltyCard();
    }

    public Customer(){
        super();
        this.purchaseHistory = new ArrayList<>();
        this.appointmentHistory = new ArrayList<>();
        this.loyaltyCard = new LoyaltyCard();
    }


    public ArrayList<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public ArrayList<Appointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    public void setAppointmentHistory(ArrayList<Appointment> appointmentHistory) {
        this.appointmentHistory = appointmentHistory;
    }

    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
}
