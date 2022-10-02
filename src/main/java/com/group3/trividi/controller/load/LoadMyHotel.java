package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Booking_DAO;
import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.model.Booking;
import com.group3.trividi.model.Hotel_Details;
import com.group3.trividi.model.Room_Details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadMyHotel", value = "/LoadMyHotel")
public class LoadMyHotel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("Account");
        System.out.println(acc.getIdHotel());
        Hotel_DAO hotel = new Hotel_DAO();

        String id = String.valueOf(acc.getIdHotel());

        Hotel_Details hotel_details = hotel.getHotel(id);
        request.setAttribute("hotel",hotel_details);

        List<Room_Details> listRD = hotel.getRoomDetails(id);
        request.setAttribute("listA", listRD);

        Booking_DAO booking = new Booking_DAO();
        List<Booking> listMB = booking.getBooks(id);
        request.setAttribute("listMB", listMB);

        request.getRequestDispatcher("MyHotel.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
