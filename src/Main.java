import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static List<Product> catalogue = new ArrayList<>();
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Service> services = new ArrayList<>();
    public static Map<Store, Integer> stores = new HashMap<>();
    public static ArrayList <Review> reviews = new ArrayList<>();

    public static void main(String[] args) {
       Product p1 = new Product("blush", "Maybelline", 10.99, "face");
       Product p2 = new Product("eyeliner", "Maybelline", 8.99, "eyes");
       Product p3 = new Product("lipstick", "Maybelline", 12.99, "lips");
       Product p4 = new Product("foundation", "Maybelline", 15.99, "face");

       Manager manager1 = new Manager("Andreea", "andreea", "password", "email", 1, "2023-10-01", 5000);
       Customer customer1 = new Customer ("Maricica", "maricica", "password", "email");
       Employee emp1 = new Employee("Elena", "elenacurecheriu", "password", "email", "makeup artist", "2023-10-01", 1, 3000, 10);
       Employee emp2 = new Employee("Maria", "maria", "password", "email", "skincare specialist", "2023-10-01", 1, 3000, 10);
       Store store1 = new Store("New York", 5, new ArrayList<>(List.of(emp1)), new HashMap<>(Map.of(p1, 10, p2, 20, p3, 15, p4, 5)));

       Service service1 = new Service("makeup", 50.0, 60, new ArrayList<>(List.of(emp1)));
       Service service2 = new Service("skin consultation", 30.0, 30, new ArrayList<>(List.of(emp2)));
       accounts.add(emp1);
       accounts.add(customer1);
       accounts.add(manager1);

       catalogue.add(p1);
       catalogue.add(p2);
       catalogue.add(p3);
       catalogue.add(p4);

       services.add(service1);
       services.add(service2);

       //the value in stores is the current profit


//       ServiceClass.checkInventory(store1);
//       ServiceClass.sellProduct(store1, p2, 2, customer1, emp1);
//        ServiceClass.addService();

//        for (Service service : services) {
//            System.out.println();
//            System.out.println("Service ID: " + service.getServiceID());
//            System.out.println("Service Type: " + service.getType());
//            System.out.println("Service Price: " + service.getPrice());
//            System.out.println("Service Duration: " + service.getDuration());
//            System.out.println("Qualified Employees: ");
//            for (Employee employee : service.getQualifiedEmployees())
//                System.out.println("Employee Name: " + employee.getName() + ", Position: " + employee.getPosition());
//            System.out.println();
//        }
//        ServiceClass.bookAppointment();

        Appointment appointment1 = new Appointment(3, 1, 2, "2023-10-01", 500);
//        customer1.getAppointmentHistory().add(appointment1);
//        System.out.println(customer1.getAppointmentHistory());

//        ServiceClass.cancelAppointment();

//        System.out.println(customer1.getAppointmentHistory());

//        ServiceClass.displayStoreWithMostSales();

        ProductReview review1 = new ProductReview(2, "2023-10-01", "Bad product :(", 2, 1);
        reviews.add(review1);

        ServiceClass.deleteBadReviews("Bad"); //este case sensitive, have to fix


    }
}

