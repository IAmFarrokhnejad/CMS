/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeeshopmanagementsystempartthree;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author afr51
 */
class Order implements Serializable{
    private int order_id;
    private int emp_id;
    private Date order_date;
    private float total_amount;

    // Constructor
    public Order(int order_id, int emp_id, Date order_date, float total_amount) {
        this.order_id = order_id;
        this.emp_id = emp_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "Order [order_id=" + order_id + ", emp_id=" + emp_id + ", order_date=" + order_date + ", total_amount="
                + total_amount + "]";
    }

}