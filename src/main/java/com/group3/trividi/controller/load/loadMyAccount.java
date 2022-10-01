package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Booking_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loadMyAccount", value = "/loadMyAccount")
public class loadMyAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("Account");
        Booking_DAO booking = new Booking_DAO();
        List<Booking> listB = booking.getBook(acc.getUID());
        request.setAttribute("listB", listB);
        request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
