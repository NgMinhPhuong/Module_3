package com.cg.module03casestudy.filter;

import com.cg.module03casestudy.model.dto.UserDto;
import com.cg.module03casestudy.model.entity.Role;

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
        System.out.println("servletPath: " + servletPath);
        String loginPath = request.getContextPath() + "/login";
        System.out.println("ContextPath: " + loginPath);
        String forbiddenPath = request.getContextPath() + "/error/403";
        UserDto userDto =  (UserDto) request.getSession().getAttribute("userLogged");
        boolean isStartWithLoginUrls = servletPath.startsWith("/login");
        boolean isStartWithRoleUrls = servletPath.startsWith("/role");
        boolean isStartWithUserUrls = servletPath.startsWith("/user");

        if (isStartWithLoginUrls) {
            filterChain.doFilter(request, response);
        }

        if (!isStartWithLoginUrls && userDto == null) {
            System.out.println("false");
            response.sendRedirect(loginPath);
            return;
        }

        if (!isStartWithLoginUrls && userDto != null) {
            String roleDesc = userDto.getRoleDesc();
            System.out.println("role: " + roleDesc);
            if ((isStartWithRoleUrls || isStartWithUserUrls)
                    && roleDesc.equals("Nhân viên")) {
                response.sendRedirect(forbiddenPath);
                return;
            }

            filterChain.doFilter(request, response);
        }

    }
}
