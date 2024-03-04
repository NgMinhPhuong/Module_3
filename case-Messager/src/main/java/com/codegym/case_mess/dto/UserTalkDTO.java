package com.codegym.case_mess.dto;

import com.codegym.case_mess.model.User;

import java.util.List;

public class UserTalkDTO {
    private User user1;
    private User user2;
    List<String> content;
    public UserTalkDTO(){}

    public UserTalkDTO(User user1, User user2, List<String> content) {
        this.user1 = user1;
        this.user2 = user2;
        this.content = content;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
