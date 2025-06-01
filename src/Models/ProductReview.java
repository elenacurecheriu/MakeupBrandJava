package Models;

public class ProductReview extends Review {
    public int productID;

    public ProductReview(int customerID, String date, String reviewText, int rating, int productID) {
        super(customerID, date, reviewText, rating);
        this.productID = productID;
    }

    public ProductReview() {
        super();
        this.productID = 0;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
