package com.codegym.case_mess.controller;

import com.codegym.case_mess.dto.UserContentDTO;
import com.codegym.case_mess.model.User;
import com.codegym.case_mess.service.IHomeService;
import com.codegym.case_mess.service.impl.HomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/home")
public class HomeController extends HttpServlet {
    private IHomeService iHomeService = new HomeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        int id = user.getId();
        List<UserContentDTO> lists = iHomeService.findAllById(id);
        req.setAttribute("lists", lists);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "search":
                searchUser(req, resp);
                break;
        }
    }

    public void searchUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("search");
        User user = (User) req.getSession().getAttribute("user");
        String response = iHomeService.findUserByName(name, user.getId());
        PrintWriter printWriter = resp.getWriter();
        if(response == null) {
            printWriter.println("none");
        } else {
            printWriter.println(response);
        }
    }
}
