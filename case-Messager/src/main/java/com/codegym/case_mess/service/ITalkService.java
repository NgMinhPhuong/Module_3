package com.codegym.case_mess.service;

import com.codegym.case_mess.dto.UserTalkDTO;
import com.codegym.case_mess.model.User;

import java.util.List;

public interface ITalkService {
     UserTalkDTO getContent(int idUser1, int idUser2);
     void addContent(int id, String username, String content);
     String checkNewData(int idTalk, User user, int idUser2);

     int findIDByUser1_idAndUser2_id(int idUser1, int idUser2);


}
