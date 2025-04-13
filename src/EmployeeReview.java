public class EmployeeReview extends Review{
    private int employeeID;

    public EmployeeReview(int customerID, String date, String reviewText, int rating, int employeeID) {
        super(customerID, date, reviewText, rating);
        this.employeeID = employeeID;
    }

    public EmployeeReview() {
        super();
        this.employeeID = 0;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
