package com.codegym.case_mess.repository;

import com.codegym.case_mess.model.User_Talk;

import java.util.List;

public interface IUserTalkRepository {
    List<User_Talk> findAll();
    List<User_Talk> findAllById(int id);
    int findIdContentByUser1_idAnd_User2_id(int idUser1, int idUser2);
    void createRecord(int user1_id, int user2_id, int talk_id);

}

