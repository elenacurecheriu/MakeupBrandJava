import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.List;


public class ServiceClass {
    //add a product
    public static Product readProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        return new Product(name, brand, price, category);
    }

    //add an employee
    public static Employee readEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee username: ");
        String username = scanner.nextLine();
        System.out.println("Enter employee email: ");
        String email = scanner.nextLine();
        System.out.println("Enter employee password: ");
        String password = scanner.nextLine();
        System.out.println("Enter employee position: ");
        String position = scanner.nextLine();
        System.out.println("Enter employee hire date: ");
        String hireDate = scanner.nextLine();
        System.out.println("Enter where the employee is located (storeID): ");
        int storeID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employee salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employee commission: ");
        int commission = scanner.nextInt();
        scanner.nextLine();
        return new Employee(name, username, password, email, position, hireDate, storeID, salary, commission);
    }

    //add a store
    public static Store readStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter store location: ");
        String location = scanner.nextLine();
        System.out.println("Enter number of employees: ");
        int noOfEmployees = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employees:");
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < noOfEmployees; i++) {
            System.out.println("Enter employee " + (i + 1) + ": ");
            employees.add(readEmployee());
        }
        System.out.println("Enter inventory: ");
        Map<Product, Integer> inventory = new HashMap<>();
        while (true) {
            System.out.println("Enter productID (or 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            //verific daca produsul exista in catalogul brandului
            Product product = null;
            for (Product p : Main.catalogue) {
                if (p.getName().equalsIgnoreCase(input)) {
                    product = p;
                    break;
                }
            }
            System.out.println("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            inventory.put(product, quantity);
        }
        return new Store(location, noOfEmployees, employees, new HashMap<>());
    }


    //check a store's inventory
    public static void checkInventory(Store store) {
        System.out.println("Store ID: " + store.getStoreID());
        System.out.println("Location: " + store.getLocation());
        System.out.println("Inventory: ");
        for (Map.Entry<Product, Integer> entry : store.getInventory().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Quantity: " + quantity);
        }
    }

    //sell a product
    public static void sellProduct(Store store, Product product, int quantity, Customer customer, Employee employee) {
        if (store.getInventory().containsKey(product)) {
            int currentQuantity = store.getInventory().get(product);
            if (currentQuantity >= quantity) {
                store.getInventory().put(product, currentQuantity - quantity);
                System.out.println("Sold " + quantity + " of " + product.getName() + " from store " + store.getLocation());
                double finalPrice = (product.getPrice() * quantity);
                System.out.println("Initial price: " + finalPrice);
                if (customer.getLoyaltyCard().getNoOfPoints() > 1000)
                    finalPrice = finalPrice * 0.9;
                customer.getLoyaltyCard().setNoOfPoints(customer.getLoyaltyCard().getNoOfPoints() + (int) finalPrice);
                Purchase purchase = new Purchase("date", customer.getAccountID(), "in store", employee.getAccountID(), new ArrayList<>(List.of(product)), finalPrice);
                customer.getPurchaseHistory().add(purchase);
                employee.setCommission((int) (employee.getCommission() + finalPrice * 0.1));
                System.out.println("Final price: " + finalPrice);
                System.out.println("Purchase history updated for customer " + customer.getName());
                System.out.println("Commission updated for employee " + employee.getName());
                System.out.println("Updated commission: " + employee.getCommission());
            } else {
                System.out.println("Not enough stock for " + product.getName());
            }
        } else {
            System.out.println("Product not found in store inventory");
        }
    }

    //add service
    public static void addService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter service name: ");
        String name = scanner.nextLine();
        System.out.println("Enter service price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter service duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Employee> qualifiedEmployees = new ArrayList<>();
        while (true) {
            System.out.println("Enter qualified employee accountID (or 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            int accountID = Integer.parseInt(input);
            for (Account account : Main.accounts) {
                if (account.getAccountID() == accountID && account instanceof Employee) {
                    qualifiedEmployees.add((Employee) account);
                    break;
                }
            }
        }
        Service service = new Service(name, price, duration, qualifiedEmployees);
        Main.services.add(service);
    }
    //book appointment

    public static void bookAppointment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter service ID: ");
        int serviceID = scanner.nextInt();
        System.out.println("Enter employee accountID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();
        //verifica daca angajatul e calificat pentru serviciul respectiv
        for (Service service : Main.services) {
            if (service.getServiceID() == serviceID) {
                boolean isQualified = false;
                for (Employee employee : service.getQualifiedEmployees()) {
                    if (employee.getAccountID() == employeeID) {
                        isQualified = true;
                        break;
                    }
                }
                if (!isQualified) {
                    System.out.println("Employee is not qualified for this service");
                    return;
                }
            }
        }
        System.out.println("Enter customer accountID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter date: ");
        String date = scanner.nextLine();

        for (Account account : Main.accounts) {
            if (account.getAccountID() == customerID && account instanceof Customer) {
                Customer customer = (Customer) account;
                for (Service service : Main.services) {
                    if (service.getServiceID() == serviceID) {
                        double finalPrice = service.getPrice();
                        if (customer.getLoyaltyCard().getNoOfPoints() > 1000)
                            finalPrice = finalPrice * 0.9;
                        customer.getLoyaltyCard().setNoOfPoints(customer.getLoyaltyCard().getNoOfPoints() + (int) finalPrice);
                        System.out.println("Final price: " + finalPrice);
                        Appointment appointment = new Appointment(employeeID, serviceID, customerID, date, finalPrice);
                        customer.getAppointmentHistory().add(appointment);
                        break;
                    }
                }
                System.out.println("Appointment booked for customer " + customer.getName());
                System.out.println("Appointment history: ");
                for (Appointment appointment : customer.getAppointmentHistory()) {
                    System.out.println("Appointment ID: " + appointment.getAppointmentID());
                    System.out.println("Service ID: " + appointment.getServiceID());
                    System.out.println("Employee ID: " + appointment.getEmployeeID());
                    System.out.println("Date: " + appointment.getDate());
                    System.out.println("Final price: " + appointment.getFinalPrice());
                }
                break;
            }
        }
    }

    /// UNTESTED vvvvvvvvvvvvvv
    //cancel appointment
    public static void cancelAppointment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter appointment ID: ");
        int appointmentID = scanner.nextInt();
        scanner.nextLine();
        for (Account account : Main.accounts) {
            if (account instanceof Customer) {
                Customer customer = (Customer) account;
                for (Appointment appointment : customer.getAppointmentHistory()) {
                    if (appointment.getAppointmentID() == appointmentID) {
                        customer.getAppointmentHistory().remove(appointment);
                        System.out.println("Appointment cancelled");
                        return;
                    }
                }
            }
        }
        System.out.println("Appointment not found");
    }


    public static void getProfitStore(Store store) {
        double totalSales = 0;
        for (Account account : Main.accounts) {
            if (account instanceof Customer) {
                Customer customer = (Customer) account;
                for (Purchase purchase : customer.getPurchaseHistory()) {
                    for (Employee employee : store.getEmployees()) {
                        if (employee.getAccountID() == purchase.getEmployeeID()) {
                            totalSales += purchase.getFinalPrice();
                            break;
                        }
                    }
                }
            }
        }
        //update the store's value with the total sales in the map
        Main.stores.put(store, (int) totalSales);
    }

    //display the store with the most sales
    public static void displayStoreWithMostSales() {
        Store bestStore = null;
        int maxSales = 0;
        for (Map.Entry<Store, Integer> entry : Main.stores.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                bestStore = entry.getKey();
            }
        }
        if (bestStore != null) {
            System.out.println("Store with the most sales: " + bestStore.getLocation() + ", Sales: " + maxSales);
        } else {
            System.out.println("No stores found");
        }
    }

    //view customer activity history

    public static void viewCustomerActivityHistory(Customer customer){
        System.out.println("Purchase history: ");
        for (Purchase purchase : customer.getPurchaseHistory()) {
            System.out.println("Purchase ID: " + purchase.getPurchaseID());
            System.out.println("Final price: " + purchase.getFinalPrice());
            System.out.println("Products: ");
            for (Product product : purchase.getProducts()) {
                System.out.println("Product name: " + product.getName());
                System.out.println("Product brand: " + product.getBrand());
                System.out.println("Product price: " + product.getPrice());
            }
        }
        //vreau nume pentru service si employee, nu id
        System.out.println("Appointment history: ");
        for (Appointment appointment : customer.getAppointmentHistory()) {
            System.out.println("Appointment ID: " + appointment.getAppointmentID());
            for (Service service : Main.services) {
                if (service.getServiceID() == appointment.getServiceID()) {
                    System.out.println("Service name: " + service.getType());
                    break;
                }
            }
            for(Account account : Main.accounts) {
                if (account.getAccountID() == appointment.getEmployeeID() && account instanceof Employee) {
                    System.out.println("Employee name: " + account.getName());
                    break;
                }
            }
            System.out.println("Date: " + appointment.getDate());
            System.out.println("Final price: " + appointment.getFinalPrice());
        }
    }

    //show loyalty card data for a customer
    public static void showLoyaltyCardData(Customer customer){
        System.out.println("Loyalty card ID: " + customer.getLoyaltyCard().getCardID());
        System.out.println("Points: " + customer.getLoyaltyCard().getNoOfPoints());
    }
    //show most sold products

    //delete reviews that have bad words >:(
    public static void deleteBadReviews(String badWords){
        String[] words = badWords.split(" ");
        for (Review review : Main.reviews) {
            for (String word : words) {
                if (review.getReviewText().contains(word)) {
                    Main.reviews.remove(review);
                    System.out.println("Review deleted");
                    return;
                }
            }
        }
        System.out.println("No bad words found in reviews");
    }
}
