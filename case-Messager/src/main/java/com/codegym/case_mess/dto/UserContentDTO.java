package com.codegym.case_mess.dto;

import com.codegym.case_mess.model.Talk;
import com.codegym.case_mess.model.User;

public class UserContentDTO {
    private User user;
    private Talk talk;
    public UserContentDTO(){}

    public UserContentDTO(User user, Talk talk) {
        this.user = user;
        this.talk = talk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }
}
