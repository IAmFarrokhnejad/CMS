/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeeshopmanagementsystemparttwo;

import java.io.Serializable;

/**
 *
 * @author MortezaFarrokhnejad
 */
class Customer implements Serializable {
    private int customer_id;
    private String name;
    private String surname;
    private String email;
    private String phone;

    // Constructor
    public Customer(int customer_id, String name, String surname, String email, String phone) {
        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [customer_id=" + customer_id + ", name=" + name + ", surname=" + surname + ", email=" + email
                + ", phone=" + phone + "]";
    }
}
