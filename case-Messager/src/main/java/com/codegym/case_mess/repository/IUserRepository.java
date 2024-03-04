package com.codegym.case_mess.repository;

import com.codegym.case_mess.model.User;

import java.util.List;

public interface IUserRepository {
    User findByUsernameAndPassword(String username, String password);
    User findById(int id);
    List<User> findAllByName(String name, int idUserNow);
    boolean addUser(User user);
}
