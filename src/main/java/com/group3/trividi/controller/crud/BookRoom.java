package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Booking_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.DateProcessor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookRoom", value = "/BookRoom")
public class BookRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dateS = request.getParameter("dateS");
        String dateE = request.getParameter("dateE");
        String id_hotel = request.getParameter("id");
        String number = request.getParameter("numofroom");
        String idType = request.getParameter("roomtype");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        int numberR = Integer.parseInt(number);
        int id_Type = Integer.parseInt(idType);
        Account acc = (Account) session.getAttribute("Account");
        if(acc == null) {

        }

        DateProcessor tool = new DateProcessor();
        System.out.println(dateS);
        System.out.println(tool.isLogicDate(dateS));
        if (DateProcessor.duration(dateS, dateE) <= 0 || !tool.isLogicDate(dateS) ) {
            request.setAttribute("error", "Date is not valid!");
            request.getRequestDispatcher("LoadBooking?id_hotel=" + id_hotel).forward(request, response);
            return;
        }

        Booking_DAO dao = new Booking_DAO();
        dao.insertBook(id_Type,
                acc.getUID(),
                dateS,
                dateE,
                numberR,
                dao.getCost(id_Type));
        response.sendRedirect("LoadMyAccount");

    }
}
