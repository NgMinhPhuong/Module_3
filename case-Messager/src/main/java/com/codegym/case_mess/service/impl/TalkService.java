package com.codegym.case_mess.service.impl;

import com.codegym.case_mess.connection.JdbcConnection;
import com.codegym.case_mess.dto.UserTalkDTO;
import com.codegym.case_mess.model.Talk;
import com.codegym.case_mess.model.User;
import com.codegym.case_mess.repository.ITalkRepository;
import com.codegym.case_mess.repository.IUserRepository;
import com.codegym.case_mess.repository.IUserTalkRepository;
import com.codegym.case_mess.repository.impl.TalkRepository;
import com.codegym.case_mess.repository.impl.UserRepository;
import com.codegym.case_mess.repository.impl.UserTalkRepository;
import com.codegym.case_mess.service.ITalkService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TalkService implements ITalkService {
    private LocalDateTime oldTime = LocalDateTime.now();
    private static final String PATTERN_TIME = "dd/MM/yyyy HH:mm:ss";
    private IUserTalkRepository iUserTalkRepository = new UserTalkRepository();
    private IUserRepository iUserRepository = new UserRepository();
    private ITalkRepository iTalkRepository = new TalkRepository();


    public void setOldTimeWhenStartApplication(String content, User user2){
        if (content == null) return;
        String [] arrContent = content.split("\n");
        String sttTime = arrContent[arrContent.length - 1].substring(user2.getUsername().length(), user2.getUsername().length() + 19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_TIME);
        LocalDateTime dateTime = LocalDateTime.parse(sttTime, formatter);
        oldTime = dateTime;
    }
    @Override
    public UserTalkDTO getContent(int idUser1, int idUser2) {
        UserTalkDTO userTalkDTO = new UserTalkDTO();
        User user1 = iUserRepository.findById(idUser1);
        User user2 = iUserRepository.findById(idUser2);
        int idContent = iUserTalkRepository.findIdContentByUser1_idAnd_User2_id(idUser1,idUser2);
        if(idContent == 0){
            iTalkRepository.createRecord();
            Talk lastTalkRecord = iTalkRepository.getLastRecord();
            iUserTalkRepository.createRecord(idUser1, idUser2, lastTalkRecord.getId());
            idContent = iUserTalkRepository.findIdContentByUser1_idAnd_User2_id(idUser1, idUser2);
        }
        String content = iTalkRepository.findContentById(idContent);
        List<String> listContent = new ArrayList<>();
        if(content != null) {
            String[] arrContent = content.split("\n");
            if(arrContent[arrContent.length - 1].startsWith(user2.getUsername())){
                setOldTimeWhenStartApplication(content, user2);
            }
            for(String s : arrContent){
                listContent.add(s);
            }
        }

        userTalkDTO.setUser1(user1);
        userTalkDTO.setUser2(user2);
        userTalkDTO.setContent(listContent);
        return userTalkDTO;
    }

    @Override
    public void addContent(int idTalk, String username, String content) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        String newContent =  username + formattedDateTime + content + "\n";
        String checkContent = iTalkRepository.findContentById(idTalk);
        if(checkContent == null) {
            iTalkRepository.addContentById(newContent, idTalk, true);
        } else {
            iTalkRepository.addContentById(newContent, idTalk, false);
        }
    }

    @Override
    public String checkNewData(int idTalk, User user1, int idUser2) {
        Talk talk = iTalkRepository.findById(idTalk);
        User user2 = iUserRepository.findById(idUser2);
        if(talk.getContent() == null) return null;
        String [] arrContent = talk.getContent().split("\n");
        if(!arrContent[arrContent.length - 1].startsWith(user1.getUsername())){
            String sttTime = arrContent[arrContent.length - 1].substring(user2.getUsername().length(), user2.getUsername().length() + 19);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_TIME);
            LocalDateTime dateTime = LocalDateTime.parse(sttTime, formatter);
            if (!dateTime.isEqual(oldTime)) {
                oldTime = dateTime;
                return arrContent[arrContent.length - 1].substring(user2.getUsername().length() + 19);
            }
        }
        return null;
    }

    @Override
    public int findIDByUser1_idAndUser2_id(int idUser1, int idUser2) {
        return iUserTalkRepository.findIdContentByUser1_idAnd_User2_id(idUser1, idUser2);
    }


}
