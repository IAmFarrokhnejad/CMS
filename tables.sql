-- Create the database
CREATE DATABASE coffeeshop;

-- Use the database
USE coffeeshop;

-- Create table for Employee class
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    gender CHAR(1),
    position VARCHAR(50),
    salary FLOAT
);

-- Create table for Product class
CREATE TABLE Product (
    product_id INT PRIMARY KEY,
    name VARCHAR(50),
    price FLOAT,
    category VARCHAR(50),
    stock INT
);

-- Create table for Order class
CREATE TABLE `Order` (
    order_id INT PRIMARY KEY,
    emp_id INT,
    order_date DATE,
    total_amount FLOAT,
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create table for Customer class
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(15)
);

-- Create table for Transaction class
CREATE TABLE `Transaction` (
    transaction_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert sample data into Employee table
INSERT INTO Employee (emp_id, name, surname, gender, position, salary)
VALUES (1, 'John', 'Doe', 'M', 'Barista', 2000.00),
       (2, 'Alice', 'Smith', 'F', 'Manager', 3000.00),
       (3, 'Michael', 'Johnson', 'M', 'Barista', 1800.00),
       (4, 'Emily', 'Brown', 'F', 'Cashier', 1800.00),
       (5, 'David', 'Wilson', 'M', 'Chef', 2500.00);

-- Insert sample data into Product table
INSERT INTO Product (product_id, name, price, category, stock)
VALUES (1, 'Espresso', 2.50, 'Beverage', 100),
       (2, 'Cappuccino', 3.00, 'Beverage', 80),
       (3, 'Croissant', 2.00, 'Food', 50),
       (4, 'Chocolate Cake', 4.50, 'Dessert', 30);

-- Insert sample data into Order table
INSERT INTO `Order` (order_id, emp_id, order_date, total_amount)
VALUES (1, 2, '2024-05-01', 15.50),
       (2, 1, '2024-05-02', 8.00),
       (3, 4, '2024-05-02', 6.00);

-- Insert sample data into Customer table
INSERT INTO Customer (customer_id, name, surname, email, phone)
VALUES (1, 'Emma', 'Johnson', 'emma@example.com', '123-456-7890'),
       (2, 'Daniel', 'Martinez', 'daniel@example.com', '987-654-3210'),
       (3, 'Sophia', 'Lee', 'sophia@example.com', '456-789-0123');

-- Insert sample data into Transaction table
INSERT INTO `Transaction` (transaction_id, order_id, product_id, quantity)
VALUES (1, 1, 1, 2),
       (2, 2, 2, 1),
       (3, 3, 3, 2),
       (4, 1, 4, 1);
