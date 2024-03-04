package com.example.demo1;


import java.io.*;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}