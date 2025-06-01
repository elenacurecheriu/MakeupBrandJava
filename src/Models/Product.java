package Models;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private int productID;
    private String name;
    private String brand;
    private double price;
    private String category;
    private double rating;
    private int quantitySold;


    public Product()
    {
        this.name = "Default Models.Product Name";
        this.brand = "Default Brand";
        this.price = 0.0;
        this.category = "Default Category";
        this.rating = 0.0;
        this.quantitySold = 0;
    }

    public Product(String productName, String productBrand, double productPrice, String productCategory){
        this.name = productName;
        this.brand = productBrand;
        this.price = productPrice;
        this.category = productCategory;
        this.rating = 0.0;
        this.quantitySold = 0;
    }

    public Product(Product obj)
    {
        this.productID = obj.productID;
        this.name = obj.name;
        this.brand = obj.brand;
        this.price = obj.price;
        this.category = obj.category;
        this.rating = obj.rating;
        this.quantitySold = obj.quantitySold;
    }

    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

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

    public int getQuantitySold() { return quantitySold; }

    public void setQuantitySold(int quantitySold) { this.quantitySold = quantitySold; }

    public int compareTo (Product other)
    {
        return Integer.compare(other.quantitySold, this.quantitySold);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID && Double.compare(price, product.price) == 0 && Double.compare(rating, product.rating) == 0 && quantitySold == product.quantitySold && Objects.equals(name, product.name) && Objects.equals(brand, product.brand) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, brand, price, category, rating, quantitySold);
    }
}
