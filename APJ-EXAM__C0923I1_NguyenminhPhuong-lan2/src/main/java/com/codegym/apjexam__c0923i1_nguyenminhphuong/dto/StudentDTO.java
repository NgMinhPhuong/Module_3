package com.codegym.apjexam__c0923i1_nguyenminhphuong.dto;

public class StudentDTO {
    private int id;
    private String class_name;
    private String name;
    private String dateOfBirth;
    private String email;
    private String address;
    private String phone;
    public StudentDTO(){}

    public StudentDTO(int id, String class_name, String name, String dateOfBirth, String email, String address, String phone) {
        this.id = id;
        this.class_name = class_name;
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

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
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
