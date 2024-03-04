package com.codegym.apjexam__c0923i1_nguyenminhphuong.model;

public class Student {
    private int id;
    private int class_id;
    private String name;
    private String dateOfBirth;
    private String email;
    private String address;
    private String phone;
    public Student(){}

    public Student(int id, int class_id, String name, String dateOfBirth, String email, String address, String phone) {
        this.id = id;
        this.class_id = class_id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
