package com.group3.trividi.filter;


import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.StringCutter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {


    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        Cookie[] cookies = req.getCookies();
        boolean check = false;
        String uid = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("uid")) {
                    uid = c.getValue();
                    check = true;
                    break;
                }
            }
            if (check) {
                User_DAO dao = new User_DAO();
                Account acc;
                HttpSession session = req.getSession();
                acc = dao.getUSer(uid);
                session.setAttribute("Account", acc);
                session.setAttribute("role", acc.getRoleID());
                session.setAttribute("name", StringCutter.cut(acc.getFullname()));
            }

        }


        chain.doFilter(request, response);
    }
}
