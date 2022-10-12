package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Rate_DAO;
import com.group3.trividi.model.Rate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadComment", value = "/LoadComment")
public class LoadComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(request.getParameter("amount_cmt"));
        String id_hotel = request.getParameter("id_hotel");
        Rate_DAO dao = new Rate_DAO();
        List<Rate> list = dao.getRate(id_hotel,offset);
        PrintWriter out = response.getWriter();
        for (Rate r : list) {
            String output = "";
            output += "";
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
