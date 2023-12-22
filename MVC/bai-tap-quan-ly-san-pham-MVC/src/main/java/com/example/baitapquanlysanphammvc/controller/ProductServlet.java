package com.example.baitapquanlysanphammvc.controller;

import com.example.baitapquanlysanphammvc.model.Product;
import com.example.baitapquanlysanphammvc.service.ProductService;
import com.example.baitapquanlysanphammvc.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
        }
    }
    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        Product p = new Product(id,name,Double.parseDouble(price));
        this.productService.addProduct(p);
        RequestDispatcher rd = request.getRequestDispatcher("product/add.jsp");
        rd.forward(request,response);
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        this.productService.deleteProduct(id);
        RequestDispatcher rd = request.getRequestDispatcher("product/delete.jsp");
        rd.forward(request, response);
    }

    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        Product p = new Product(id,name,Double.parseDouble(price));
        this.productService.update(p);
        RequestDispatcher rd = request.getRequestDispatcher("product/edit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                viewProducts(req, resp);
                break;
            default:
                listProducts(req, resp);
                break;
        }

    }

    public void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("product/add.jsp");
        rd.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        String id = request.getParameter("id");
        RequestDispatcher rd;
        Product p = this.productService.findById(id);
        if(p == null){
            rd = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", p);
            rd = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        RequestDispatcher rd;
        Product p = this.productService.findById(id);
        if(p == null){
            rd = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", p);
            rd = request.getRequestDispatcher("product/delete.jsp");
        }
        rd.forward(request, response);
    }

    public void viewProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        Product p = this.productService.findById(id);
        RequestDispatcher rd;
        if(p == null){
            rd = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", p);
            rd = request.getRequestDispatcher("product/view.jsp");
        }
        rd.forward(request, response);
    }

    public void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Product> products = this.productService.findAll();
        RequestDispatcher rd = request.getRequestDispatcher("product/list.jsp");
        request.setAttribute("products",products);
        rd.forward(request, response);
    }

}
