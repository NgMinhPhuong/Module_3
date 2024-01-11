package com.example.apjexamc0923i1.controller;

import com.example.apjexamc0923i1.model.entity.Employee;
import com.example.apjexamc0923i1.model.service.IEmployeeService;
import com.example.apjexamc0923i1.model.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "")
public class EmployeeController extends HttpServlet {
    IEmployeeService iEmployeeService;

    @Override
    public void init() throws ServletException {
        iEmployeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        List<Employee> employees;
        if(action == null) action = "";
        String s = "";
        switch (action){
            case "search":
                s = "view/detail.jsp";
                String key = req.getParameter("key");
                employees = iEmployeeService.search(key);
                req.setAttribute("employees", employees);
                break;
            case "edit":
                String email = req.getParameter("email");
                req.setAttribute("employee", iEmployeeService.getEmployeeByEmail(email));
                s = "view/edit.jsp";
                break;
            case "add":
                s = "view/add.jsp";
                break;
            case "delete":
                s = "view/delete.jsp";
                break;
            default:
                s = "view/detail.jsp";
                employees = iEmployeeService.getAll();
                req.setAttribute("employees", employees);
                break;
        }
        RequestDispatcher rd = req.getRequestDispatcher(s);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action){
            case "edit":
                System.out.println(req.getParameter("name"));
                String email = req.getParameter("email");
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                String phoneNumber = req.getParameter("phonenumber");
                String salary = req.getParameter("salary");
                String department = req.getParameter("department");
                Employee employee = new Employee(email,name,address,phoneNumber,salary,department);
                iEmployeeService.edit(employee);
                break;
            case "add":
                String email1 = req.getParameter("email");
                String name1 = req.getParameter("name");
                String address1 = req.getParameter("address");
                String phoneNumber1 = req.getParameter("phonenumber");
                String salary1 = req.getParameter("salary");
                String department1 = req.getParameter("department");
                Employee employee1 = new Employee(email1,name1,address1,phoneNumber1,salary1,department1);
                iEmployeeService.add(employee1);
                break;
            case "delete":
                String email2 = req.getParameter("email");
                iEmployeeService.delete(email2);
                break;
        }
        resp.sendRedirect("/");
    }
}

