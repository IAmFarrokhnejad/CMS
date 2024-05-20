/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeeshopmanagementsystempartone;

import java.io.Serializable;

/**
 *
 * @author MortezaFarrokhnejad
 */
public class Employee implements Serializable{
    private int emp_id;
    private String name;
    private String surname;
    private char gender;
    private String position;
    private float salary;

    // Constructor
    public Employee(int emp_id, String name, String surname, char gender, String position, float salary) {
        this.emp_id = emp_id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.position = position;
        this.salary = salary;
    }

    
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [emp_id=" + emp_id + ", name=" + name + ", surname=" + surname + ", gender=" + gender
                + ", position=" + position + ", salary=" + salary + "]";
    }
    
}
