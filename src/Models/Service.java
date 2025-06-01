package Models;

import java.util.ArrayList;

public class Service {
    private static int noOfServices = 0;
    private int serviceID;
    private String type;
    private double price;
    private int duration;
    private ArrayList<Employee> qualifiedEmployees;

    static
    {
        noOfServices = 0;
    }

    {
        noOfServices++;
    }

    public Service(String type, double price, int duration, ArrayList<Employee> qualifiedEmployees) {
        this.serviceID = noOfServices;
        this.type = type;
        this.price = price;
        this.duration = duration;
        this.qualifiedEmployees = qualifiedEmployees;
    }

    public Service() {
        this.serviceID = noOfServices;
        this.type = "";
        this.price = 0.0;
        this.duration = 0;
        this.qualifiedEmployees = new ArrayList<>();
    }

    public int getServiceID() {
        return serviceID;
    }

//    public static void setServiceID(int serviceID) {
//        Models.Service.serviceID = serviceID;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Employee> getQualifiedEmployees() {
        return qualifiedEmployees;
    }


    public void setQualifiedEmployees(ArrayList<Employee> qualifiedEmployees) {
        this.qualifiedEmployees = qualifiedEmployees;
    }
}
