package com.codegym.apjexam__c0923i1_nguyenminhphuong.repository;

import com.codegym.apjexam__c0923i1_nguyenminhphuong.jdbcconnection.JdbcConnection;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository {
    private static final String FIND_BY_ID = "select * from class where id = ?";

    private static final String FIND_ALL = "select * from class";
    public Class findById(int id){
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_ID);){
            preparedStatement.setString(1, id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Class cl = new Class();
                cl.setId(Integer.parseInt(rs.getString("id")));
                cl.setName(rs.getString("name"));
                return cl;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Class> findAll(){
        List<Class> lists = new ArrayList<>();
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL);){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Class cl = new Class();
                cl.setId(Integer.parseInt(rs.getString("id")));
                cl.setName(rs.getString("name"));
                lists.add(cl);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
