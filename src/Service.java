import java.util.ArrayList;

public class Service {
    private static int serviceID;
    private String type;
    private double price;
    private int duration;
    private ArrayList<Employee> qualifiedEmployees;

    static
    {
        serviceID = 0;
    }

    {
        serviceID++;
    }

    public Service(String type, double price, int duration, ArrayList<Employee> qualifiedEmployees) {
        this.type = type;
        this.price = price;
        this.duration = duration;
        this.qualifiedEmployees = qualifiedEmployees;
    }

    public Service() {
        this.type = "";
        this.price = 0.0;
        this.duration = 0;
        this.qualifiedEmployees = new ArrayList<>();
    }

    public static int getServiceID() {
        return serviceID;
    }

    public static void setServiceID(int serviceID) {
        Service.serviceID = serviceID;
    }

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
