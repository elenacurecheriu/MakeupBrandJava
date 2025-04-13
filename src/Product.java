import java.util.Scanner;

public class Product {
    private static int noOfProducts = 0;
    private int productID;
    private String name;
    private String brand;
    private double price;
    private String category;
    private double rating;

    static
    {
        noOfProducts = 0;
    }

    {
        noOfProducts++;
    }

    public Product()
    {
        this.productID = noOfProducts;
        this.name = "Default Product Name";
        this.brand = "Default Brand";
        this.price = 0.0;
        this.category = "Default Category";
        this.rating = 0.0;
    }

    public Product(String productName, String productBrand, double productPrice, String productCategory, double productRating){
        this.productID = noOfProducts;
        this.name = productName;
        this.brand = productBrand;
        this.price = productPrice;
        this.category = productCategory;
        this.rating = productRating;
    }

    public Product(Product obj)
    {
        this.productID = obj.productID;
        this.name = obj.name;
        this.brand = obj.brand;
        this.price = obj.price;
        this.category = obj.category;
        this.rating = obj.rating;
    }

    public int getProductID() {
        return productID;
    }

//    public static void setProductID(int productID) {
//        Product.productID = productID;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

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
        System.out.println("Enter product rating: ");
        double rating = scanner.nextDouble();
        return new Product(name, brand, price, category, rating);
    }
}
