package com.example.demo1;

import sun.rmi.server.Dispatcher;

import java.io.*;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "HelloServlet ", value = "")
public class HelloServlet extends HttpServlet {
    int cnt = 1;
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methos","*");
        response.setHeader("Access-Control-Allow-Headers","*");

        // Hello
        if(cnt % 2 == 0)
        request.setAttribute("name","ba");
        else request.setAttribute("name","hai");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        cnt++;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methos","*");
        resp.setHeader("Access-Control-Allow-Headers","*");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }

    public static void main(String[] args) {
        String [] s = null;
        for(String x : s) System.out.println(x);
    }
}