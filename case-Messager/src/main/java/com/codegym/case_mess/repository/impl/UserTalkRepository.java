package com.codegym.case_mess.repository.impl;

import com.codegym.case_mess.connection.JdbcConnection;
import com.codegym.case_mess.model.User_Talk;
import com.codegym.case_mess.repository.IUserTalkRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTalkRepository implements IUserTalkRepository {
    private static final String FIND_ALL = "select * from user_talk";
    private static final String FIND_ALL_BY_ID = "select * from user_talk where user1_id = ? or user2_id = ?";

    private static final String FIND_IDCONTENT_BY_USER1ID_AND_USER2ID = "select * from user_talk where (user1_id = ? and user2_id = ?) or (user2_id = ? and user1_id = ?)";
    private static final String CREATE_RECORD = "insert into user_talk(user1_id,user2_id,talk_id) values(?,?,?)";

    @Override
    public List<User_Talk> findAll() {
        List<User_Talk> lists = new ArrayList<>();
        try (Connection c = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User_Talk userTalk = new User_Talk();
                userTalk.setId(Integer.parseInt(rs.getString("id")));
                userTalk.setTalk_id(Integer.parseInt(rs.getString("talk_id")));
                userTalk.setUser1_id(Integer.parseInt(rs.getString("user1_id")));
                userTalk.setUser2_id(Integer.parseInt(rs.getString("user2_id")));
                lists.add(userTalk);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }

    @Override
    public List<User_Talk> findAllById(int id) {
        List<User_Talk> lists = new ArrayList<>();
        try (Connection c = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL_BY_ID);) {
            preparedStatement.setString(1, id + "");
            preparedStatement.setString(2,id+"");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User_Talk userTalk = new User_Talk();
                userTalk.setId(Integer.parseInt(rs.getString("id")));
                userTalk.setUser1_id(Integer.parseInt(rs.getString("user1_id")));
                userTalk.setUser2_id(Integer.parseInt(rs.getString("user2_id")));
                userTalk.setTalk_id(Integer.parseInt(rs.getString("talk_id")));
                lists.add(userTalk);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }

    @Override
    public int findIdContentByUser1_idAnd_User2_id(int idUser1, int idUser2) {
        try (Connection c = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(FIND_IDCONTENT_BY_USER1ID_AND_USER2ID)) {
            preparedStatement.setString(1, idUser1 + "");
            preparedStatement.setString(2, idUser2 + "");
            preparedStatement.setString(3, idUser1 + "");
            preparedStatement.setString(4, idUser2 + "");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idContent = Integer.parseInt(rs.getString("talk_id"));
                return idContent;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public void createRecord(int user1_id, int user2_id, int talk_id) {
        try (Connection c = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(CREATE_RECORD)) {
                preparedStatement.setString(1, user1_id+"");
                preparedStatement.setString(2, user2_id+"");
                preparedStatement.setString(3, talk_id+"");
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
