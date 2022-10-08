package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Statistic_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

@WebServlet(name = "LoadStatistic", value = "/LoadStatistic")
public class LoadStatistic extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year =  request.getParameter("year");
        String month = request.getParameter("month");
        Statistic_DAO dao = new Statistic_DAO();
        HashMap<String,Double> ls =  dao.getData(year,month);
        System.out.println(ls.size());
        request.setAttribute("map", ls);
        request.setAttribute("allProfit", dao.getAllProfits());
        request.setAttribute("allBooks",dao.getNumberOfBooks());
        request.setAttribute("dayProfit",dao.getTotalInDay().getTotal());
        request.setAttribute("dayBook", dao.getTotalInDay().getNumberBooks());
        request.setAttribute("timeUpdate", LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute());
        request.getRequestDispatcher("profit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
