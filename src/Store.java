import java.util.ArrayList;
import java.util.Map;

public class Store {
    private static int storeID;
    private String location;
    private int noOfEmployees;
    private ArrayList<Employee> employees;
    private Map<Product, Integer> inventory;

    static {
        storeID = 0;
    }

    {
        storeID++;
    }

    public Store(String location, int noOfEmployees, ArrayList<Employee> employees, Map<Product, Integer> inventory) {
        this.location = location;
        this.noOfEmployees = noOfEmployees;
        this.employees = employees;
        this.inventory = inventory;
    }

    public Store() {
        this.location = "";
        this.noOfEmployees = 0;
        this.employees = new ArrayList<>();
        this.inventory = null;
    }

    public static int getStoreID() {
        return storeID;
    }

    public static void setStoreID(int storeID) {
        Store.storeID = storeID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }
}
