package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account_Info;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadHotels", value = "/LoadHotels")
public class LoadHotels extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel_DAO dao = new Hotel_DAO();
        User_DAO daouser = new User_DAO();
        List<Account_Info> listA = daouser.getStaff();
        List<Hotel_Details> listH = dao.getHotels();
        request.setAttribute("listH", listH);
        request.setAttribute("listA", listA);
        request.getRequestDispatcher("managehotel.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
