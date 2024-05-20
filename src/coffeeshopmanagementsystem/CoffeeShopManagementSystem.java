/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coffeeshopmanagementsystempartone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MortezaFarrokhnejad
 */
class CoffeeShopManagementSystem {

    // Define lists to store data
    private static List<Employee> employees = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();

    // Methods for Employee class
    public static void addEmployee(int emp_id, String name, String surname, char gender, String position,
            float salary) {
        employees.add(new Employee(emp_id, name, surname, gender, position, salary));
    }

    public static void editEmployee(int emp_id, String name, String surname, char gender, String position,
            float salary) {
        for (Employee employee : employees) {
            if (employee.getEmp_id() == emp_id) {
                employee.setName(name);
                employee.setSurname(surname);
                employee.setGender(gender);
                employee.setPosition(position);
                employee.setSalary(salary);
                break;
            }
        }
    }

    public static void deleteEmployee(int emp_id) {
        employees.removeIf(employee -> employee.getEmp_id() == emp_id);
    }

    public static void listEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static void backupEmployees() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreEmployees() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            employees = (List<Employee>) ois.readObject();
        }
    }

    // Methods for Product class
    public static void addProduct(int product_id, String name, float price, String category, int stock) {
        products.add(new Product(product_id, name, price, category, stock));
    }

    public static void editProduct(int product_id, String name, float price, String category, int stock) {
        for (Product product : products) {
            if (product.getProduct_id() == product_id) {
                product.setName(name);
                product.setPrice(price);
                product.setCategory(category);
                product.setStock(stock);
                break;
            }
        }
    }

    public static void deleteProduct(int product_id) {
        products.removeIf(product -> product.getProduct_id() == product_id);
    }

    public static void listProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static void backupProducts() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.ser"))) {
            oos.writeObject(products);
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreProducts() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.ser"))) {
            products = (List<Product>) ois.readObject();
        }
    }

    // Methods for Order class
    public static void addOrder(int order_id, int emp_id, Date order_date, float total_amount) {
        orders.add(new Order(order_id, emp_id, order_date, total_amount));
    }

    public static void editOrder(int order_id, int emp_id, Date order_date, float total_amount) {
        for (Order order : orders) {
            if (order.getOrder_id() == order_id) {
                order.setEmp_id(emp_id);
                order.setOrder_date(order_date);
                order.setTotal_amount(total_amount);
                break;
            }
        }
    }

    public static void deleteOrder(int order_id) {
        orders.removeIf(order -> order.getOrder_id() == order_id);
    }

    public static void listOrders() {
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public static void backupOrders() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("orders.ser"))) {
            oos.writeObject(orders);
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreOrders() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orders.ser"))) {
            orders = (List<Order>) ois.readObject();
        }
    }

    // Methods for Customer class
    public static void addCustomer(int customer_id, String name, String surname, String email, String phone) {
        customers.add(new Customer(customer_id, name, surname, email, phone));
    }

    public static void editCustomer(int customer_id, String name, String surname, String email, String phone) {
        for (Customer customer : customers) {
            if (customer.getCustomer_id() == customer_id) {
                customer.setName(name);
                customer.setSurname(surname);
                customer.setEmail(email);
                customer.setPhone(phone);
                break;
            }
        }
    }

    public static void deleteCustomer(int customer_id) {
        customers.removeIf(customer -> customer.getCustomer_id() == customer_id);
    }

    public static void listCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public static void backupCustomers() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.ser"))) {
            oos.writeObject(customers);
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreCustomers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.ser"))) {
            customers = (List<Customer>) ois.readObject();
        }
    }

    // Methods for Transaction class
    public static void addTransaction(int transaction_id, int order_id, int product_id, int quantity) {
        transactions.add(new Transaction(transaction_id, order_id, product_id, quantity));
    }

    public static void editTransaction(int transaction_id, int order_id, int product_id, int quantity) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransaction_id() == transaction_id) {
                transaction.setOrder_id(order_id);
                transaction.setProduct_id(product_id);
                transaction.setQuantity(quantity);
                break;
            }
        }
    }

    public static void deleteTransaction(int transaction_id) {
        transactions.removeIf(transaction -> transaction.getTransaction_id() == transaction_id);
    }

    public static void listTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    public static void backupTransactions() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transactions.ser"))) {
            oos.writeObject(transactions);
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreTransactions() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transactions.ser"))) {
            transactions = (List<Transaction>) ois.readObject();
        }
    }

    // Test methods for each class
    public static void test_Employee() {
        try {
            addEmployee(1, "John", "Doe", 'M', "Barista", 2000.00f);
            addEmployee(2, "Alice", "Smith", 'F', "Manager", 3000.00f);
            addEmployee(3, "Michael", "Johnson", 'M', "Barista", 1800.00f);
            addEmployee(4, "Emily", "Brown", 'F', "Cashier", 1800.00f);
            addEmployee(5, "David", "Wilson", 'M', "Chef", 2500.00f);
            listEmployees();
            editEmployee(2, "Alice", "Doe", 'F', "Manager", 3500.00f);
            listEmployees();
            backupEmployees();
            deleteEmployee(3);
            listEmployees();
            restoreEmployees();
            listEmployees();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void test_Product() {
        try {
            addProduct(1, "Espresso", 2.50f, "Beverage", 100);
            addProduct(2, "Cappuccino", 3.00f, "Beverage", 80);
            addProduct(3, "Croissant", 2.00f, "Food", 50);
            addProduct(4, "Chocolate Cake", 4.50f, "Dessert", 30);
            listProducts();
            editProduct(2, "Cappuccino", 3.50f, "Beverage", 90);
            listProducts();
            backupProducts();
            deleteProduct(3);
            listProducts();
            restoreProducts();
            listProducts();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void test_Order() throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        try {
            addOrder(1, 2, fmt.parse("2024-05-01"), 15.50f);
            addOrder(2, 1, fmt.parse("2024-05-02"), 8.00f);
            addOrder(3, 4, fmt.parse("2024-05-02"), 6.00f);
            listOrders();
            editOrder(2, 1, fmt.parse("2024-05-03"), 10.00f);
            listOrders();
            backupOrders();
            deleteOrder(3);
            listOrders();
            restoreOrders();
            listOrders();
        } catch (IOException | ClassNotFoundException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void test_Customer() {
        try {
            addCustomer(1, "Emma", "Johnson", "emma@example.com", "123-456-7890");
            addCustomer(2, "Daniel", "Martinez", "daniel@example.com", "987-654-3210");
            addCustomer(3, "Sophia", "Lee", "sophia@example.com", "456-789-0123");
            listCustomers();
            editCustomer(2, "Daniel", "Brown", "daniel@example.com", "987-654-3210");
            listCustomers();
            backupCustomers();
            deleteCustomer(3);
            listCustomers();
            restoreCustomers();
            listCustomers();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void test_Transaction() {
        try {
            addTransaction(1, 1, 1, 2);
            addTransaction(2, 2, 2, 1);
            addTransaction(3, 3, 3, 2);
            addTransaction(4, 1, 4, 1);
            listTransactions();
            editTransaction(2, 1, 3, 3);
            listTransactions();
            backupTransactions();
            deleteTransaction(3);
            listTransactions();
            restoreTransactions();
            listTransactions();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        test_Customer();
        test_Employee();
        test_Order();
        test_Product();
        test_Transaction();
    }

}
