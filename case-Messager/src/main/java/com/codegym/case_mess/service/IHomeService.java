package com.codegym.case_mess.service;

import com.codegym.case_mess.dto.UserContentDTO;
import com.codegym.case_mess.model.User;

import java.util.List;

public interface IHomeService {
    List<UserContentDTO> findAllById(int id);
    String findUserByName(String name, int idUser1);
}
