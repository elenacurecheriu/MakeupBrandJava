package Models;

public abstract class Review {
    private static int noOfReviews = 0;
    private int reviewID;
    private int customerID;
    private String date;
    private String reviewText;
    private int rating;

    static {
        noOfReviews = 0;
    }

    {
        noOfReviews++;
    }

    public Review(int customerID, String date, String reviewText, int rating) {
        this.reviewID = noOfReviews;
        this.customerID = customerID;
        this.date = date;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Review() {
        this.reviewID = noOfReviews;
        this.customerID = 0;
        this.date = "";
        this.reviewText = "";
        this.rating = 0;
    }

    public int getReviewID() {
        return reviewID;
    }

//    public static void setReviewID(int reviewID) {
//        Models.Review.reviewID = reviewID;
//    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
