/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeeshopmanagementsystempartone;

import java.io.Serializable;

/**
 *
 * @author afr51
 */
class Product implements Serializable {
    private int product_id;
    private String name;
    private float price;
    private String category;
    private int stock;

    // Constructor
    public Product(int product_id, String name, float price, String category, int stock) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [product_id=" + product_id + ", name=" + name + ", price=" + price + ", category=" + category
                + ", stock=" + stock + "]";
    }

    
}


