public class Appointment {
    private static int noOfAppointments = 0;
    private int appointmentID;
    private int employeeID;
    private int customerID;
    private String date;
    private int finalPrice;

    static {
        noOfAppointments = 0;
    }

    {
        noOfAppointments++;
    }

    public Appointment(int employeeID, int customerID, String date, int finalPrice) {
        this.appointmentID = noOfAppointments;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.date = date;
        this.finalPrice = finalPrice;
    }

    public Appointment() {
        this.appointmentID = noOfAppointments;
        this.employeeID = 0;
        this.customerID = 0;
        this.date = "";
        this.finalPrice = 0;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

//    public void setAppointmentID(int appointmentID) {
//        Appointment.appointmentID = appointmentID;
//    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
