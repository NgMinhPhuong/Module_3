package com.codegym.case_mess.repository.impl;

import com.codegym.case_mess.connection.JdbcConnection;
import com.codegym.case_mess.model.Talk;
import com.codegym.case_mess.repository.ITalkRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TalkRepository implements ITalkRepository {
    private static final String FIND_BY_ID = "select * from talk where id = ?";

    private static final String CREATE_RECCORD = "insert into talk(content) values(null)";

    private static final String FIND_CONTENT_BY_ID = "select content from talk where id = ?";

    private static final String GET_LAST_RECORD = "SELECT * FROM talk ORDER BY id DESC LIMIT 1";
    private static final String ADD_CONTENT_BY_ID = "update talk set content = concat(content, ?) where id = ?";

    private static final String CREATE_DATA_START = "update talk set content = ? where id = ?";
    @Override
    public Talk findById(int id) {
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_BY_ID);){
            preparedStatement.setString(1, id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Talk talk = new Talk();
                talk.setId(Integer.parseInt(rs.getString("id")));
                talk.setContent(rs.getString("content"));
                return talk;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String findContentById(int id) {
        try(Connection c = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(FIND_CONTENT_BY_ID);){
            preparedStatement.setString(1, id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String s = rs.getString("content");
                return s;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void createRecord() {
        try(Connection c = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(CREATE_RECCORD);){
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Talk getLastRecord() {
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(GET_LAST_RECORD);){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Talk talk = new Talk();
                talk.setId(Integer.parseInt(rs.getString("id")));
                talk.setContent(rs.getString("content"));
                return talk;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public void addContentById(String content, int id, boolean checkNull) {
        String sql = "";
        if(checkNull){
            sql = CREATE_DATA_START;
        } else {
            sql = ADD_CONTENT_BY_ID;
        }
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
