package com.example.apjexamc0923i1.model.entity;

public class Employee {
    int id;
    String name;
    String email;
    String address;
    String phoneNumber;
    String salary;
    String Department;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Employee(){};
    public Employee(String email,String name,  String address, String phoneNumber, String salary, String department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        Department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return Department;
    }
}
