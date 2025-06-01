package Services;

import java.sql.*;
import Connections.DatabaseConnection;
import Models.Customer;
import Models.Employee;
import Models.Manager;
import Models.Product;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    public void createTable() throws SQLException {
        try (Connection con = DatabaseConnection.getInstance();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Accounts (" +
                            "accountID INT AUTO_INCREMENT PRIMARY KEY, " +
                            "type ENUM('Customer', 'Manager', 'Employee') NOT NULL" +
                            ")"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Customers (" +
                            "name VARCHAR(255) NOT NULL, " +
                            "username VARCHAR(255) NOT NULL UNIQUE, " +
                            "password VARCHAR(255) NOT NULL, " +
                            "email VARCHAR(255) NOT NULL UNIQUE, " +
                            "customerID INT PRIMARY KEY, " +
//                            "loyaltyCardID VARCHAR(255), " +
                            "FOREIGN KEY (customerID) REFERENCES Accounts(accountID) ON DELETE CASCADE " +
//                            "FOREIGN KEY (loyaltyCardID) REFERENCES loyalty_cards(loyaltyCardID) ON DELETE SET NULL" +
                            ")"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Managers (" +
                            "managerID INT PRIMARY KEY, " +
                            "name VARCHAR(255) NOT NULL, " +
                            "username VARCHAR(255) NOT NULL UNIQUE, " +
                            "password VARCHAR(255) NOT NULL, " +
                            "email VARCHAR(255) NOT NULL UNIQUE, " +
                            "storeID INT, " +
                            "hireDate DATE, " +
                            "salary DECIMAL(10, 2) NOT NULL, " +
                            "FOREIGN KEY (managerID) REFERENCES Accounts(accountID) ON DELETE CASCADE, " +
                            "FOREIGN KEY (storeID) REFERENCES stores(storeID) ON DELETE SET NULL" +
                            ")"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Employees (" +
                            "employeeID INT PRIMARY KEY, " +
                            "name VARCHAR(255) NOT NULL, " +
                            "username VARCHAR(255) NOT NULL UNIQUE, " +
                            "password VARCHAR(255) NOT NULL, " +
                            "email VARCHAR(255) NOT NULL UNIQUE, " +
                            "storeID INT, " +
                            "hireDate DATE, " +
                            "position VARCHAR(255) NOT NULL, " +
                            "salary DECIMAL(10, 2) NOT NULL, " +
                            "commission DECIMAL(10, 2) DEFAULT 0, " +
                            "rating DECIMAL(3, 2) DEFAULT 0.00, " +
                            "FOREIGN KEY (employeeID) REFERENCES Accounts(accountID) ON DELETE CASCADE, " +
                            "FOREIGN KEY (storeID) REFERENCES stores(storeID) ON DELETE SET NULL" +
                            ")"
            );

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error creating table: " + e.getMessage());
        }
    }

    public void insertCustomer(Customer customer) throws SQLException {
        String accountQuery = "INSERT INTO Accounts (type) VALUES ('Customer')";
        String customerQuery = "INSERT INTO Customers (name, username, password, email, customerID) VALUES (?, ?, ?, ?, ?)";

        Connection con = null;
        try {
            con = DatabaseConnection.getInstance();
            con.setAutoCommit(false); // Start transaction

            // Insert into Accounts table first
            try (PreparedStatement accountPs = con.prepareStatement(accountQuery, Statement.RETURN_GENERATED_KEYS)) {
                accountPs.executeUpdate();

                ResultSet rs = accountPs.getGeneratedKeys();
                if (rs.next()) {
                    int accountID = rs.getInt(1);

                    // Insert into Customers table
                    try (PreparedStatement customerPs = con.prepareStatement(customerQuery)) {
                        customerPs.setString(1, customer.getName());
                        customerPs.setString(2, customer.getUsername());
                        customerPs.setString(3, customer.getPassword());
                        customerPs.setString(4, customer.getEmail());
                        customerPs.setInt(5, accountID);
                        customerPs.executeUpdate();

                        customer.setAccountID(accountID);
                    }
                }
            }

            con.commit(); // Commit transaction

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback(); // Rollback on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new SQLException("Error inserting customer: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true); // Reset auto-commit
                    con.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    public void insertEmployee(Employee employee) throws SQLException {
        String accountQuery = "INSERT INTO Accounts (type) VALUES ('Employee')";
        String employeeQuery = "INSERT INTO Employees (name, username, password, email, employeeID, storeID, hireDate, position, salary, commission) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = null;
        try {
            con = DatabaseConnection.getInstance();
            con.setAutoCommit(false); // Start transaction

            // Insert into Accounts table first
            try (PreparedStatement accountPs = con.prepareStatement(accountQuery, Statement.RETURN_GENERATED_KEYS)) {
                accountPs.executeUpdate();

                ResultSet rs = accountPs.getGeneratedKeys();
                if (rs.next()) {
                    int accountID = rs.getInt(1);

                    // Insert into Employees table
                    try (PreparedStatement employeePs = con.prepareStatement(employeeQuery)) {
                        employeePs.setString(1, employee.getName());
                        employeePs.setString(2, employee.getUsername());
                        employeePs.setString(3, employee.getPassword());
                        employeePs.setString(4, employee.getEmail());
                        employeePs.setInt(5, accountID);
                        employeePs.setInt(6, employee.getStoreID());
                        employeePs.setDate(7, Date.valueOf(employee.getHireDate()));
                        employeePs.setString(8, employee.getPosition());
                        employeePs.setDouble(9, employee.getSalary());
                        employeePs.setDouble(10, employee.getCommission());
                        employeePs.executeUpdate();
                        employee.setAccountID(accountID);
                    }
                }
            }

            con.commit(); // Commit transaction

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback(); // Rollback on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new SQLException("Error inserting employee: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true); // Reset auto-commit
                    con.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    public void insertManager(Manager manager) throws SQLException {
        String accountQuery = "INSERT INTO Accounts (type) VALUES ('Manager')";
        String managerQuery = "INSERT INTO Managers (name, username, password, email, managerID, storeID, hireDate, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance();
            con.setAutoCommit(false); // Start transaction

            // Insert into Accounts table first
            try (PreparedStatement accountPs = con.prepareStatement(accountQuery, Statement.RETURN_GENERATED_KEYS)) {
                accountPs.executeUpdate();

                ResultSet rs = accountPs.getGeneratedKeys();
                if (rs.next()) {
                    int accountID = rs.getInt(1);

                    // Insert into Managers table
                    try (PreparedStatement managerPs = con.prepareStatement(managerQuery)) {
                        managerPs.setString(1, manager.getName());
                        managerPs.setString(2, manager.getUsername());
                        managerPs.setString(3, manager.getPassword());
                        managerPs.setString(4, manager.getEmail());
                        managerPs.setInt(5, accountID);
                        managerPs.setInt(6, manager.getStoreID());
                        managerPs.setDate(7, Date.valueOf(manager.getHireDate()));
                        managerPs.setDouble(8, manager.getSalary());
                        managerPs.executeUpdate();
                        manager.setAccountID(accountID);
                    }
                }
            }

            con.commit(); // Commit transaction

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback(); // Rollback on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new SQLException("Error inserting manager: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true); // Reset auto-commit
                    con.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }
}