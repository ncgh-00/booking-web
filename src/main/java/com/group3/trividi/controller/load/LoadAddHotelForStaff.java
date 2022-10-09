package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadAddHotelForStaff", value = "/LoadAddHotelForStaff")
public class LoadAddHotelForStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffid = request.getParameter("staffid");
        Hotel_DAO dao = new Hotel_DAO();
        List<Hotel_Details> list = dao.getHotels();
        request.setAttribute("listH",list);
        request.setAttribute("staffid", staffid);
        request.getRequestDispatcher("addhotelforstaff.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
