package com.example.productdiscount;
import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String price =  request.getParameter("price");
        String discount = request.getParameter("discount");
        double pricee =  Double.parseDouble(price);
        double discountt =  Double.parseDouble(discount);
        response.getWriter().write("Discount Amount: " + discountt + "%\n");
        response.getWriter().write("Discount Price: " + pricee * discountt * 0.01);

    }

}