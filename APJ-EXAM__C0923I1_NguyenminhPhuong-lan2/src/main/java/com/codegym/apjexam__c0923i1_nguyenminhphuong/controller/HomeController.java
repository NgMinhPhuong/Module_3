package com.codegym.apjexam__c0923i1_nguyenminhphuong.controller;

import com.codegym.apjexam__c0923i1_nguyenminhphuong.dto.StudentDTO;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.model.Class;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.model.Student;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.service.HomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home")
public class HomeController extends HttpServlet {
    private HomeService homeService = new HomeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "add":
                showAdd(req, resp);
                break;
            case "edit":
                showEdit(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "search":
                showSearch(req, resp);
                break;
            default:
                showHome(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch (action){
            case "add":
                add(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "delete":
                break;
        }
    }

    public void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentDTO> list = homeService.findAll();
        req.setAttribute("lists",list);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/home.jsp");
        rd.forward(req, resp);
    }

//    add---------------------------------------

    public void showAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Class> listClassName = homeService.findAllClass();
        req.setAttribute("listClassName", listClassName);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/add.jsp");
        rd.forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int class_id = Integer.parseInt(req.getParameter("class_id"));
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Student student = new Student(1, class_id, name, dateOfBirth, email, address, phone);
        homeService.add(student);
        resp.sendRedirect("/home");
    }


//    edit-------------------------------------------

    public void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        StudentDTO studentDTO = homeService.findStudentDTOById(id);
        List<Class> listClassName = homeService.findAllClass();
        req.setAttribute("listClassName", listClassName);
        req.setAttribute("studentDTO", studentDTO);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/edit.jsp");
        rd.forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int class_id = Integer.parseInt(req.getParameter("class_id"));
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Student student = new Student(id, class_id, name, dateOfBirth, email, address, phone);
        homeService.editStudent(student);
        resp.sendRedirect("/home");
    }

//    delete-------------------------

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        homeService.delete(id);
        resp.sendRedirect("/home");
    }


//    search-----------------------------
    public void showSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<StudentDTO> lists = homeService.findAllByName(name);
        req.setAttribute("lists", lists);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/home.jsp");
        rd.forward(req, resp);
    }
}
