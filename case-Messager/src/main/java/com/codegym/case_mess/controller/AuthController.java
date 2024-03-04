package com.codegym.case_mess.controller;

import com.codegym.case_mess.model.User;
import com.codegym.case_mess.service.IAuthService;
import com.codegym.case_mess.service.impl.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class AuthController extends HttpServlet {
    private IAuthService iAuthService = new AuthService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "logout":
                logout(req, resp);
                break;
            default:
                showLogin(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "login":
                login(req, resp);
                break;
            case "register":
                register(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
            default:
        }

    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = iAuthService.login(username, password);
        if(user != null){
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/home");
            return;
        }
        resp.sendRedirect("/login?error=true");
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }

    public void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("error") != null)
            req.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/login1.jsp");
        rd.forward(req,resp);
    }

    public void register(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        User user = new User(1, username, password, name, image);
        iAuthService.register(user);
    }

}
