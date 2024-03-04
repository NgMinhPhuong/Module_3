package com.codegym.case_mess.service.impl;

import com.codegym.case_mess.dto.UserContentDTO;
import com.codegym.case_mess.model.User;
import com.codegym.case_mess.model.User_Talk;
import com.codegym.case_mess.repository.ITalkRepository;
import com.codegym.case_mess.repository.IUserRepository;
import com.codegym.case_mess.repository.IUserTalkRepository;
import com.codegym.case_mess.repository.impl.TalkRepository;
import com.codegym.case_mess.repository.impl.UserRepository;
import com.codegym.case_mess.repository.impl.UserTalkRepository;
import com.codegym.case_mess.service.IHomeService;

import java.util.ArrayList;
import java.util.List;

public class HomeService implements IHomeService {
    private IUserTalkRepository iUserTalkRepository = new UserTalkRepository();
    private IUserRepository iUserRepository = new UserRepository();
    private ITalkRepository iTalkRepository = new TalkRepository();
    @Override
    public List<UserContentDTO> findAllById(int id) {
        List<UserContentDTO> userContentDTOList = new ArrayList<>();
        List<User_Talk> userTalkList = iUserTalkRepository.findAllById(id);
        userTalkList.forEach(userTalk -> {
            UserContentDTO userContentDTO = new UserContentDTO();
            if (userTalk.getUser1_id() == id){
                userContentDTO.setUser(iUserRepository.findById(userTalk.getUser2_id()));
                userContentDTO.setTalk(iTalkRepository.findById(userTalk.getUser2_id()));
            } else {
                userContentDTO.setUser(iUserRepository.findById(userTalk.getUser1_id()));
                userContentDTO.setTalk(iTalkRepository.findById(userTalk.getUser1_id()));
            }
            userContentDTOList.add(userContentDTO);
        });
        return userContentDTOList;
    }

    @Override
    public String findUserByName(String name, int idUser1) {
        if(name == "") return null;
        List<User> lists = iUserRepository.findAllByName(name,idUser1);
        String s = "";
        for(User user : lists){
            s += "<a href=\"/talk?idUser1=" + idUser1 + "&idUser2=" + user.getId() + "\""
            + "<div class=\"line\"><div class=\"line1\"><img src=\"" + user.getImage() + "\">"
            + "<h2>" + user.getName() + "</h2></div></div></a>";
        }
        return s;
    }
}
