package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.NameGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddHotel", value = "/AddHotel")
public class AddHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel_DAO h = new Hotel_DAO();
        User_DAO u = new User_DAO();
        h.addHotel(NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier());
        h.addRoom(h.getIDHotel(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), "0", "0");

        String username = NameGenerator.randomIdentifier();
        String pass = HashPassword.generatePassword(8);
        u.randomUser(2, username, pass);
        u.addHotelforStaff(u.getIDUser(), h.getIDHotel());
        request.setAttribute("username", username);
        request.setAttribute("pass", pass);
        request.setAttribute("show", 1);
        request.getRequestDispatcher("LoadHotels").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel_DAO h = new Hotel_DAO();
        User_DAO u = new User_DAO();
        h.addHotel(NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier());
        h.addRoom(h.getIDHotel(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), NameGenerator.randomIdentifier(), "0", "0");
        String uid = request.getParameter("uid");
        u.addHotelforStaff(uid, h.getIDHotel());
        response.sendRedirect("LoadHotels");


    }
}
