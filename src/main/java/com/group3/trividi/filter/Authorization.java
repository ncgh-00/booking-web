package com.group3.trividi.filter;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.utils.Validation;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Authorization")
public class Authorization implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getServletPath();
        User_DAO dao = new User_DAO();
        HttpSession session = req.getSession();
        String role;
        if(session.getAttribute("role") == null){
            role = "4";
        }else role = session.getAttribute("role").toString();
        System.out.println(role);
        System.out.println(path);
        boolean isPermit = Validation.authorization(dao.listFunction(role),path);

        if(!isPermit){
            res.sendRedirect("index.jsp");
            return;
        }
        chain.doFilter(request, response);
    }
}
