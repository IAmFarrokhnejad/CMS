/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coffeeshopmanagementsystempartthree;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

/**
 *
 * @author afr51
 */
class CoffeeShopManagementSystem {

    public static Connection connection;
    public static SimpleDateFormat fmt;

    // Check methods (check if an entry exists in the database or not)
    // Check if an Employee exists
    public static boolean checkEmployee(int emp_id) {
        String sql = "SELECT count(*) FROM Employee WHERE emp_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, emp_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoffeeShopManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check if a Product exists
    public static boolean checkProduct(int product_id) {
        String sql = "SELECT count(*) FROM Product WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, product_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoffeeShopManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check if an Order exists
    public static boolean checkOrder(int order_id) {
        String sql = "SELECT count(*) FROM `Order` WHERE order_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, order_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoffeeShopManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check if a Customer exists
    public static boolean checkCustomer(int customer_id) {
        String sql = "SELECT count(*) FROM Customer WHERE customer_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, customer_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoffeeShopManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check if a Transaction exists
    public static boolean checkTransaction(int transaction_id) {
        String sql = "SELECT count(*) FROM Transaction WHERE transaction_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transaction_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoffeeShopManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Methods for Employee class
    public static void addEmployee(int emp_id, String name, String surname, char gender, String position,
            float salary) {
        try {
            // Prepare the SQL statement
            String sql = "INSERT INTO Employee (emp_id, name, surname, gender, position, salary) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, emp_id);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setString(4, String.valueOf(gender));
            statement.setString(5, position);
            statement.setFloat(6, salary);

            // Execute the SQL statement
            statement.executeUpdate();

            System.out.println("Employee added successfully to the database.");

        } catch (SQLException e) {
            System.out.println("Error adding employee to the database: " + e.getMessage());
        } 
    }

    public static void editEmployee(int emp_id, String name, String surname, char gender, String position,
            float salary) {
        try {

            String sql = "UPDATE Employee SET name = ?, surname = ?, gender = ?, position = ?, salary = ? WHERE emp_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, String.valueOf(gender));
            statement.setString(4, position);
            statement.setFloat(5, salary);
            statement.setInt(6, emp_id);

            statement.executeUpdate();

            System.out.println("Employee details updated successfully in the database.");

        } catch (SQLException e) {
            System.out.println("Error updating employee details in the database: " + e.getMessage());
        }
    }

    public static void deleteEmployee(int emp_id) {
        try {

            String sql = "DELETE FROM Employee WHERE emp_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, emp_id);

            statement.executeUpdate();

            System.out.println("Employee deleted successfully from the database.");

        } catch (SQLException e) {
            System.out.println("Error deleting employee from the database: " + e.getMessage());
        }
    }

    // Methods for Product class
    public static void addProduct(int product_id, String name, float price, String category, int stock) {
        try {

            String sql = "INSERT INTO Product (product_id, name, price, category, stock) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product_id);
            statement.setString(2, name);
            statement.setFloat(3, price);
            statement.setString(4, category);
            statement.setInt(5, stock);

            statement.executeUpdate();

            System.out.println("Product added successfully to the database.");

        } catch (SQLException e) {
            System.out.println("Error adding product to the database: " + e.getMessage());
        }
    }

    public static void editProduct(int product_id, String name, float price, String category, int stock) {
        try {

            String sql = "UPDATE Product SET name = ?, price = ?, category = ?, stock = ? WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, price);
            statement.setString(3, category);
            statement.setInt(4, stock);
            statement.setInt(5, product_id);

            statement.executeUpdate();

            System.out.println("Product details updated successfully in the database.");

        } catch (SQLException e) {
            System.out.println("Error updating product details in the database: " + e.getMessage());
        }
    }

    public static void deleteProduct(int product_id) {
        try {

            String sql = "DELETE FROM Product WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product_id);

            statement.executeUpdate();

            System.out.println("Product deleted successfully from the database.");

        } catch (SQLException e) {
            System.out.println("Error deleting product from the database: " + e.getMessage());
        }
    }

    // Methods for Order class
    public static void addOrder(int order_id, int emp_id, Date order_date, float total_amount) {
        try {

            String sql = "INSERT INTO `Order` (order_id, emp_id, order_date, total_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order_id);
            statement.setInt(2, emp_id);
            statement.setDate(3, new java.sql.Date(order_date.getTime()));
            statement.setFloat(4, total_amount);

            statement.executeUpdate();

            System.out.println("Order added successfully to the database.");

        } catch (SQLException e) {
            System.out.println("Error adding order to the database: " + e.getMessage());
        }
    }

    public static void editOrder(int order_id, int emp_id, Date order_date, float total_amount) {
        try {

            String sql = "UPDATE `Order` SET emp_id = ?, order_date = ?, total_amount = ? WHERE order_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, emp_id);
            statement.setDate(2, new java.sql.Date(order_date.getTime()));
            statement.setFloat(3, total_amount);
            statement.setInt(4, order_id);

            statement.executeUpdate();

            System.out.println("Order details updated successfully in the database.");

        } catch (SQLException e) {
            System.out.println("Error updating order details in the database: " + e.getMessage());
        }
    }

    public static void deleteOrder(int order_id) {
        try {

            String sql = "DELETE FROM `Order` WHERE order_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order_id);

            statement.executeUpdate();

            System.out.println("Order deleted successfully from the database.");

        } catch (SQLException e) {
            System.out.println("Error deleting order from the database: " + e.getMessage());
        }
    }

    // Methods for Customer class
    public static void addCustomer(int customer_id, String name, String surname, String email, String phone) {
        try {

            String sql = "INSERT INTO Customer (customer_id, name, surname, email, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customer_id);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setString(4, email);
            statement.setString(5, phone);

            statement.executeUpdate();

            System.out.println("Customer added successfully to the database.");

        } catch (SQLException e) {
            System.out.println("Error adding customer to the database: " + e.getMessage());
        }
    }

    public static void editCustomer(int customer_id, String name, String surname, String email, String phone) {
        try {

            String sql = "UPDATE Customer SET name = ?, surname = ?, email = ?, phone = ? WHERE customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setInt(5, customer_id);

            statement.executeUpdate();

            System.out.println("Customer details updated successfully in the database.");

        } catch (SQLException e) {
            System.out.println("Error updating customer details in the database: " + e.getMessage());
        }
    }

    public static void deleteCustomer(int customer_id) {
        try {

            String sql = "DELETE FROM Customer WHERE customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customer_id);

            statement.executeUpdate();

            System.out.println("Customer deleted successfully from the database.");

        } catch (SQLException e) {
            System.out.println("Error deleting customer from the database: " + e.getMessage());
        }
    }

    // Methods for Transaction class
    public static void addTransaction(int transaction_id, int order_id, int product_id, int quantity) {
        try {

            String sql = "INSERT INTO `Transaction` (transaction_id, order_id, product_id, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transaction_id);
            statement.setInt(2, order_id);
            statement.setInt(3, product_id);
            statement.setInt(4, quantity);

            statement.executeUpdate();

            System.out.println("Transaction added successfully to the database.");

        } catch (SQLException e) {
            System.out.println("Error adding transaction to the database: " + e.getMessage());
        }
    }

    public static void editTransaction(int transaction_id, int order_id, int product_id, int quantity) {
        try {

            String sql = "UPDATE `Transaction` SET order_id = ?, product_id = ?, quantity = ? WHERE transaction_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order_id);
            statement.setInt(2, product_id);
            statement.setInt(3, quantity);
            statement.setInt(4, transaction_id);

            statement.executeUpdate();

            System.out.println("Transaction details updated successfully in the database.");

        } catch (SQLException e) {
            System.out.println("Error updating transaction details in the database: " + e.getMessage());
        }
    }

    public static void deleteTransaction(int transaction_id) {
        try {

            String sql = "DELETE FROM `Transaction` WHERE transaction_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transaction_id);

            statement.executeUpdate();

            System.out.println("Transaction deleted successfully from the database.");

        } catch (SQLException e) {
            System.out.println("Error deleting transaction from the database: " + e.getMessage());
        }
    }

    // Create methods for each class
    public static void createEmployee() {
        addEmployee(1, "John", "Doe", 'M', "Barista", 2000.00f);
        addEmployee(2, "Alice", "Smith", 'F', "Manager", 3000.00f);
        addEmployee(3, "Michael", "Johnson", 'M', "Barista", 1800.00f);
        addEmployee(4, "Emily", "Brown", 'F', "Cashier", 1800.00f);
        addEmployee(5, "David", "Wilson", 'M', "Chef", 2500.00f);
    }

    public static void createProduct() {
        addProduct(1, "Espresso", 2.50f, "Beverage", 100);
        addProduct(2, "Cappuccino", 3.00f, "Beverage", 80);
        addProduct(3, "Croissant", 2.00f, "Food", 50);
        addProduct(4, "Chocolate Cake", 4.50f, "Dessert", 30);
    }

    public static void createOrder() throws ParseException {
        try {
            addOrder(1, 2, fmt.parse("2024-05-01"), 15.50f);
            addOrder(2, 1, fmt.parse("2024-05-02"), 8.00f);
            addOrder(3, 4, fmt.parse("2024-05-02"), 6.00f);

        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createCustomer() {
        addCustomer(1, "Emma", "Johnson", "emma@example.com", "123-456-7890");
        addCustomer(2, "Daniel", "Martinez", "daniel@example.com", "987-654-3210");
        addCustomer(3, "Sophia", "Lee", "sophia@example.com", "456-789-0123");
    }

    public static void createTransaction() {
        addTransaction(1, 1, 1, 2);
        addTransaction(2, 2, 2, 1);
        addTransaction(3, 3, 3, 2);
        addTransaction(4, 1, 4, 1);
    }

    // Date-to-string convertor for DatePicker
    public static String dateToString(Date d_date) {
        String temp_date, conv_date = null;
        temp_date = fmt.format(d_date);
        // Required format is like: May 15, 2021
        switch (temp_date.substring(3, 5)) {
            case "01":
                conv_date = "January " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "02":
                conv_date = "February " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "03":
                conv_date = "March " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "04":
                conv_date = "April " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "05":
                conv_date = "May " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "06":
                conv_date = "June " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "07":
                conv_date = "July " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "08":
                conv_date = "August " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "09":
                conv_date = "September " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "10":
                conv_date = "October " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "11":
                conv_date = "November " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
            case "12":
                conv_date = "December " + temp_date.substring(0, 2) + ", " +
                        temp_date.substring(6, 10);
                break;
        }
        return conv_date;
    }

    /**
     * @param args the command line arguments
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        try {

            CoffeeShopManagementSystem.initializeConnection();
            fmt = new SimpleDateFormat("dd-MM-yyyy");

            createProduct();
            createCustomer();
            createEmployee();
            createOrder();
            createTransaction();

            new Menu().setVisible(true);

            System.out.printf("\n");
        } catch (ParseException ex) {
            Logger.getLogger(CoffeeShopManagementSystem.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void initializeConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/coffeeshop";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Exit the application if the connection fails
        }
    }

}
