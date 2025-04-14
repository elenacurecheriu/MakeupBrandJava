import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private static int noOfPurchases = 0;
    private int purchaseID;
    private String purchaseDate;
    private int customerID;
    private String type;
    private int employeeID;
    private ArrayList<Product> products;
    private double finalPrice;

    static
    {
        noOfPurchases = 0;
    }

    {
        noOfPurchases++;
    }

    public Purchase(String purchaseDate, int customerID, String type, int employeeID, ArrayList<Product> products, double finalPrice) {
        this.purchaseID = noOfPurchases;
        this.purchaseDate = purchaseDate;
        this.customerID = customerID;
        this.type = type;
        this.employeeID = employeeID;
        this.products = products;
        this.finalPrice = finalPrice;
    }

    public Purchase() {
        this.purchaseID = noOfPurchases;
        this.purchaseDate = "";
        this.customerID = 0;
        this.type = "";
        this.employeeID = 0;
        this.products = new ArrayList<>();
        this.finalPrice = 0;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

//    public static void setPurchaseID(int purchaseID) {
//        Purchase.purchaseID = purchaseID;
//    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
