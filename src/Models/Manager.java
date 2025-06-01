package Models;

public class Manager extends Account {
    private int storeID;
    private String hireDate;
    private int salary;

    public Manager(String name, String username, String password, String email, int storeID, String hireDate, int salary) {
        super(name, username, password, email);
        this.storeID = storeID;
        this.hireDate = hireDate;
        this.salary = salary;
    }
    public Manager() {
        super();
        this.storeID = 0;
        this.hireDate = "";
        this.salary = 0;
    }

//    @Override
//    public void readAccount() {
//
//    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
