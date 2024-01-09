package com.example.demosadasdasd;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


public class HelloServlet {
    static String url = "jdbc:mysql://localhost:3306/test";
    static String username = "root";
    static String pw = "01666553995";

    public static void main(String[] args) {
        Connection c = null;
        try {
            String sql = "select * from orders where id = ?";
            c = DriverManager.getConnection(url, username, pw);
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, null);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("order_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}