package com.codegym.case_mess.test;

import com.codegym.case_mess.connection.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public void read(){
        try(Connection c = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement("select * from talk where id = 10")){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String s = rs.getString("content");
                String [] arr = s.split("\\n");
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(){
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement("update talk set content = concat(content, 'abc\n') where id = 10")){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);
        System.out.println(now.isEqual(now));
    }
}
