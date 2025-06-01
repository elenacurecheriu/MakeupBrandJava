package Models;

public class Appointment {
    private static int noOfAppointments = 0;
    private int appointmentID;
    private int employeeID;
    private int serviceID;
    private int customerID;
    private String date;
    private double finalPrice;

    static {
        noOfAppointments = 0;
    }

    {
        noOfAppointments++;
    }

    public Appointment(int employeeID, int serviceID, int customerID, String date, double finalPrice) {
        this.appointmentID = noOfAppointments;
        this.employeeID = employeeID;
        this.serviceID = serviceID;
        this.customerID = customerID;
        this.date = date;
        this.finalPrice = finalPrice;
    }

    public Appointment() {
        this.appointmentID = noOfAppointments;
        this.employeeID = 0;
        this.serviceID = 0;
        this.customerID = 0;
        this.date = "";
        this.finalPrice = 0;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

//    public void setAppointmentID(int appointmentID) {
//        Models.Appointment.appointmentID = appointmentID;
//    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

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

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
