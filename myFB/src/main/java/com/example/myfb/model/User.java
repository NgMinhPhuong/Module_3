package com.example.myfb.model;

public class User {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String school;
    private String adress;

    public User(){}
    public User(int id, String name, String gender, int age, String school, String adress) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.school = school;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSchool() {
        return school;
    }

    public String getAdress() {
        return adress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
