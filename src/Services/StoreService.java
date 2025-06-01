package Services;

import java.sql.*;
import Connections.DatabaseConnection;
import Models.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreService {
    public void createTable() throws SQLException {
        try (Connection con = DatabaseConnection.getInstance();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Stores (" +
                            "storeID INT PRIMARY KEY AUTO_INCREMENT," +
                            "location VARCHAR(255) NOT NULL," +
                            "noOfEmployees INT DEFAULT 0" +
                            ")"

            );
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error creating Stores table: " + e.getMessage());
        }
    }

    public void insertStore(String location) throws SQLException {
        String query = "INSERT INTO Stores (location) VALUES (?)";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, location);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error inserting store: " + e.getMessage());
        }
    }

    public List<Store> getAllStores() throws SQLException {
        String query = "SELECT * FROM Stores";
        try (Connection con = DatabaseConnection.getInstance();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            List<Store> stores = new ArrayList<>();
            while (rs.next()) {
                Store store = new Store(
                        rs.getString("location"),
                        rs.getInt("noOfEmployees")
                );
                stores.add(store);
            }
            return stores;
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving stores: " + e.getMessage());
        }
    }

    public Store updateStore(int storeID, String location, int noOfEmployees) throws SQLException {
        String query = "UPDATE Stores SET location = ?, noOfEmployees = ? WHERE storeID = ?";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, location);
            ps.setInt(2, noOfEmployees);
            ps.setInt(3, storeID);
            ps.executeUpdate();
            return new Store(location, noOfEmployees);
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating store: " + e.getMessage());
        }
    }

    public void deleteStore(int storeID) throws SQLException {
        String query = "DELETE FROM Stores WHERE storeID = ?";
        try (Connection con = DatabaseConnection.getInstance();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, storeID);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error deleting store: " + e.getMessage());
        }
    }
}
