package com.codegym.case_mess.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        if(servletPath.equals("/login")){
            filterChain.doFilter(request, response);
            return;
        }
        if (request.getServletPath().endsWith(".js")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (request.getServletPath().endsWith(".css")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getServletPath().endsWith(".png")) {
            filterChain.doFilter(request, response);
            return;
        }

        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(request,response);

    }
}
