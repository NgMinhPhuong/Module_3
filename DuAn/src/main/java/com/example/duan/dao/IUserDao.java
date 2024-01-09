package com.example.duan.dao;

import com.example.duan.model.User;

import java.util.List;

public interface IUserDao {


    User selectUser();
    List<User> selectAllUser();
}
