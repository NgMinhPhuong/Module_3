package com.example.test;

public class modelTest {
    int id;
    modelTest(int a){
        id = a;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "modelTest{" +
                "id=" + id +
                '}';
    }
}
