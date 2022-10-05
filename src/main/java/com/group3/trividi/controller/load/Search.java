package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("hotel");
        String greater = request.getParameter("cost_filter");
        String city = request.getParameter("search-by-city");
        String cate = request.getParameter("search-by-category");
        if(name == null ||name.trim().isEmpty()) name = "";
        if(cate == null ||cate.trim().isEmpty()) cate = "";
        String cost = request.getParameter("cost");
        if(cost == null || cost.trim().isEmpty()) cost = "-1";
        int price = Integer.parseInt(cost);
        Hotel_DAO dao = new Hotel_DAO();
        List<Hotel_Details> ls = dao.searchHotels(name,city,cate);
        //search
        if(greater != null && !greater.trim().isEmpty() && price > 0){
                List<Hotel_Details> invalidList = new ArrayList<>();
                for(Hotel_Details ht : ls){
                    System.out.println((1-ht.getDiscount()/100.0)*ht.getCost()/24000);
                    if (greater.equalsIgnoreCase("great")){

                        if((1-ht.getDiscount()/100.0)*ht.getCost()/24000>price) continue;
                    }else if (greater.equalsIgnoreCase("low")){
                        if((1-ht.getDiscount()/100.0)*ht.getCost()/24000 < price) continue;
                    }
                    invalidList.add(ht);

                }
                ls.removeAll(invalidList);


        }


        request.setAttribute("listH",ls);
        request.setAttribute("search",1);
        request.setAttribute("page","index.jsp");
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
