package Models;

import java.util.ArrayList;
import java.util.Map;

public class Store {
    private int storeID;
    private String location;
    private int noOfEmployees;
    private ArrayList<Employee> employees;
    private Map<Product, Integer> inventory;


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

    public Store(String location, int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
        this.location = location;
    }

    public Store(Store store)
    {
        this.storeID = store.storeID;
        this.location = store.location;
        this.noOfEmployees = store.noOfEmployees;
        this.employees = new ArrayList<>(store.employees);
        this.inventory = store.inventory; // Assuming a shallow copy is sufficient for the inventory
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
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
