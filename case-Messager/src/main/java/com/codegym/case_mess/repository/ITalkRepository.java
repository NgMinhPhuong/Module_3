package com.codegym.case_mess.repository;

import com.codegym.case_mess.model.Talk;

import java.util.List;

public interface ITalkRepository {
    Talk findById(int id);
    String findContentById(int id);
    void createRecord();
    Talk getLastRecord();
    void addContentById(String content, int id, boolean check);
}
