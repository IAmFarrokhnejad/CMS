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
class Transaction implements Serializable{
    private int transaction_id;
    private int order_id;
    private int product_id;
    private int quantity;

    // Constructor
    public Transaction(int transaction_id, int order_id, int product_id, int quantity) {
        this.transaction_id = transaction_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Transaction [transaction_id=" + transaction_id + ", order_id=" + order_id + ", product_id=" + product_id
                + ", quantity=" + quantity + "]";
    }

    
}
