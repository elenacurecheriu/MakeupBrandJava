package Main;
import Models.*;
import Services.AccountService;
import Services.ProductService;
import Services.StoreService;

import java.sql.SQLException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {
//        ProductService productService = new ProductService();
//        productService.createTable();
//
//        Product p1 = new Product("lipstick", "Rom&nd", 12.99, "lips");
//        Product p2 = new Product("eyeliner", "Maybelline", 9.99, "eyes");
//        productService.insertProduct(p1);
//        productService.insertProduct(p2);
//
//        System.out.println("p1 id: " + p1.getProductID());
//        System.out.println("p2 id: " + p2.getProductID());
//
//        Product p3 = productService.getProductByID(5);
//
//        System.out.println("Product with ID 5: " + p3.getName() + ", Brand: " + p3.getBrand() +
//                ", Price: " + p3.getPrice() + ", Category: " + p3.getCategory() +
//                ", Rating: " + p3.getRating() + ", Quantity Sold: " + p3.getQuantitySold());

//        List<Product> products = productService.getAllProducts();
//        for (Product product : products) {
//            System.out.println("ID: " + product.getProductID() + ", Name: " + product.getName() +
//                    ", Brand: " + product.getBrand() + ", Price: " + product.getPrice() +
//                    ", Category: " + product.getCategory() + ", Rating: " + product.getRating() +
//                    ", Quantity Sold: " + product.getQuantitySold());
//        }



//        StoreService storeService = new StoreService();
//
//        storeService.createTable();
//        storeService.insertStore("New York");
//        storeService.insertStore("Los Angeles");
//
//        storeService.deleteStore(2);
//

//        System.out.println("Stores in the database:");
//
//        List<Store> stores = storeService.getAllStores();
//        for (Store store : stores) {
//            System.out.println("ID: " + store.getStoreID() + ", Location: " + store.getLocation() +
//                    ", No. of Employees: " + store.getNoOfEmployees());
//        }

        AccountService accountService = new AccountService();

        accountService.createTable();
        Customer customer = new Customer("Maricica", "maricica", "password", "email");
        Employee employee = new Employee("Elena", "elenacurecheriu", "password", "email", "makeup artist", "2023-10-01", 1, 3000, 10);
        Manager manager = new Manager("Andreea", "andreea", "password", "email", 1, "2023-10-01", 5000);
//        accountService.insertEmployee(employee); //when inserting an employee, update noOfEmployees in the store
        accountService.insertManager(manager);

    }
}

