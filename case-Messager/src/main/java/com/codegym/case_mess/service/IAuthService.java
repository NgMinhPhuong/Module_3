package com.codegym.case_mess.service;


import com.codegym.case_mess.model.User;

public interface IAuthService {
    boolean register(User user);
    User login(String username, String password);
}
