package Services;

import java.sql.*;
import Connections.DatabaseConnection;
import Models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public void createTable() throws SQLException {
        try (Connection con = DatabaseConnection.getInstance();
            Statement stmt = con.createStatement()) {
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Products (" +
                    "productID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "brand VARCHAR(255) NOT NULL, " +
                    "price DECIMAL(10, 2) NOT NULL, " +
                    "category VARCHAR(255) NOT NULL, " +
                    "rating DECIMAL(3, 2) DEFAULT 0.00, " +
                    "quantitySold INT DEFAULT 0" +
                    ")"

            );
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error creating Products table: " + e.getMessage());
        }
    }

    public void insertProduct(Product product) throws SQLException {
        String query = "INSERT INTO Products (name, brand, price, category) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getBrand());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                product.setProductID(rs.getInt(1));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error inserting product: " + e.getMessage());
        }
    }

    public Product getProductByID(int productID) throws SQLException {
        String query = "SELECT * FROM Products WHERE productID = ?";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getString("category")
                );
            } else {
                return null; // No product found with the given ID
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving product: " + e.getMessage());
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        String query = "SELECT * FROM Products";
        try (Connection con = DatabaseConnection.getInstance();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product(
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getString("category")
                );
                products.add(product);
            }
            return products;
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving products: " + e.getMessage());
        }
    }

    public void updateProduct(int productId, String name, String brand, double price, String category) throws SQLException {
        String query = "UPDATE Products SET name = ?, brand = ?, price = ?, category = ? WHERE productID = ?";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setString(4, category);
            ps.setInt(5, productId);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating product: " + e.getMessage());
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Products WHERE productID = ?";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error deleting product: " + e.getMessage());
        }
    }
}
