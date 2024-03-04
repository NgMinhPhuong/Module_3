package com.codegym.case_mess.repository.impl;

import com.codegym.case_mess.connection.JdbcConnection;
import com.codegym.case_mess.model.User;
import com.codegym.case_mess.repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String FIND_BY_USERNAME_AND_PASSWORD = "select * from user where username = ? and password = ?";
    private static final String FIND_BY_ID = "select * from user where id = ?";
    private  static  final String FIND_BY_NAME = "select * from user where name like ?";

    private static final String ADD_USER = "insert into user(username,password,name,image) values(?,?,?,?)";
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_USERNAME_AND_PASSWORD)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setImage(rs.getString("image"));
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User findById(int id) {
        try(Connection c = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_ID)){
            preparedStatement.setString(1, id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setImage(rs.getString("image"));
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> findAllByName(String name, int idUserNow) {
        List<User> list = new ArrayList<>();
        try(Connection c = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_NAME)){
            preparedStatement.setString(1,"%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                int id = Integer.parseInt(rs.getString("id"));
                if(id != idUserNow) {
                    user.setId(id);
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setName(rs.getString("name"));
                    user.setImage(rs.getString("image"));
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  list;
    }

    @Override
    public boolean addUser(User user) {
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(ADD_USER)){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getImage());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
