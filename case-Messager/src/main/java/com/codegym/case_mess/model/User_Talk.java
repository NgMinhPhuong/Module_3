package com.codegym.case_mess.model;

public class User_Talk {
    private int id;
    private int talk_id;
    private int user1_id;
    private int user2_id;
    public User_Talk(){}

    public User_Talk(int id, int talk_id, int user1_id, int user2_id) {
        this.id = id;
        this.talk_id = talk_id;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(int talk_id) {
        this.talk_id = talk_id;
    }

    public int getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(int user1_id) {
        this.user1_id = user1_id;
    }

    public int getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(int user2_id) {
        this.user2_id = user2_id;
    }
}
