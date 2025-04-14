
import java.util.Scanner;

public class Employee extends Account{
    private String position;
    private String hireDate;
    private int storeID;
    private int salary;
    private int commission;
    private double rating;

    public Employee(String name, String username, String password, String email, String position, String hireDate, int storeID, int salary, int commission) {
        super(name, username, password, email);
        this.position = position;
        this.hireDate = hireDate;
        this.storeID = storeID;
        this.salary = salary;
        this.commission = commission;
        this.rating = 0.0;
    }
    public Employee() {
        super();
        this.position = "";
        this.hireDate = "";
        this.storeID = 0;
        this.salary = 0;
        this.commission = 0;
        this.rating = 0.0;
    }

//    @Override
//    public void readAccount() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.println("Enter username: ");
//        String username = scanner.nextLine();
//        System.out.println("Enter email: ");
//        String email = scanner.nextLine();
//        System.out.println("Enter password: ");
//        String password = scanner.nextLine();
//        System.out.println("Enter store ID: ");
//        int storeID = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter hire date: ");
//        String hireDate = scanner.nextLine();
//        System.out.println("Enter salary: ");
//        int salary = scanner.nextInt();
//    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
