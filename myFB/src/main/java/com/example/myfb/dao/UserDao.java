package com.example.myfb.dao;

import com.example.myfb.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "01666553995";

    private final String SELECT_ALL_USERS = "select * from users";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public User selectUser() {

        return new User();
    }

    @Override
    public List<User> selectAllUser() {
        List<User> lists = new ArrayList<>();
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(SELECT_ALL_USERS);){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("user_id");
                String name = rs.getString("username");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String school = rs.getString("school");
                String adress = rs.getString("adress");
                User user = new User(id, name, gender, age, school, adress);
                lists.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
