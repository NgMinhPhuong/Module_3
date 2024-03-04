package com.codegym.case_mess.service.impl;

import com.codegym.case_mess.model.User;
import com.codegym.case_mess.repository.IUserRepository;
import com.codegym.case_mess.repository.impl.UserRepository;
import com.codegym.case_mess.service.IAuthService;

public class AuthService implements IAuthService {
    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public boolean register(User user) {
        return iUserRepository.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        if(iUserRepository.findByUsernameAndPassword(username, password) != null){
            return iUserRepository.findByUsernameAndPassword(username, password);
        }
        return null;
    }


}
