package com.example.baitapquanlysanphammvc.model;

public class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
