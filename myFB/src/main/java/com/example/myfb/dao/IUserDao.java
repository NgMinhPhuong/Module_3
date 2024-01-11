package com.example.myfb.dao;

import com.example.myfb.model.User;

import java.util.List;

public interface IUserDao {


    User selectUser();
    List<User> selectAllUser();
}
