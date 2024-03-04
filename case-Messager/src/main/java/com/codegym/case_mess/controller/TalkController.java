package com.codegym.case_mess.controller;

import com.codegym.case_mess.dto.UserTalkDTO;
import com.codegym.case_mess.model.User;
import com.codegym.case_mess.service.ITalkService;
import com.codegym.case_mess.service.impl.TalkService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/talk")
public class TalkController extends HttpServlet {
    private ITalkService iTalkService = new TalkService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser1 = Integer.parseInt(req.getParameter("idUser1"));
        int idUser2 = Integer.parseInt(req.getParameter("idUser2"));
        int idTalk = iTalkService.findIDByUser1_idAndUser2_id(idUser1, idUser2);
        UserTalkDTO userTalkDTO = iTalkService.getContent(idUser1, idUser2);
        req.setAttribute("idTalk", idTalk);
        req.setAttribute("userTalkDTO", userTalkDTO);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/talk.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "autoUpdate":
                autoUpdate(req, resp);
                break;
            default:
                addContent(req, resp);
                break;
        }
    }

    public void autoUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUser2 = Integer.parseInt(req.getParameter("idUser2"));
        int idTalk = Integer.parseInt(req.getParameter("idTalk"));
        User user = (User) req.getSession().getAttribute("user");
        String check = iTalkService.checkNewData(idTalk, user, idUser2);
        PrintWriter printWriter = resp.getWriter();
        if(check != null){
            printWriter.println(check);
        } else{
            printWriter.println("none");
        }
    }
    public void addContent(HttpServletRequest req, HttpServletResponse resp){
        int idTalk = Integer.parseInt(req.getParameter("idTalk"));
        User user = (User) req.getSession().getAttribute("user");
        String username = user.getUsername();
        String content = req.getParameter("contentTalk");
        iTalkService.addContent(idTalk,username, content);
    }
}
