package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;
import com.group3.trividi.model.Room_Details;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadBooking", value = "/LoadBooking")
public class LoadBooking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Hotel_DAO dao = new Hotel_DAO();
        Hotel_Details hotel_details = dao.getHotel(id);
        List<Room_Details> list_R = dao.getRoomDetails(id);
        request.setAttribute("hotel_details", hotel_details);
        request.setAttribute("listR", list_R);
        request.setAttribute("page", "LoadBooking");
        request.setAttribute("id_hotel", id);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
