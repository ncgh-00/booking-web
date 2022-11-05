package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadMoreHotel", value = "/LoadMoreHotel")
public class LoadMoreHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(request.getParameter("amount_hotel"));
        System.out.println(offset);
        Hotel_DAO dao = new Hotel_DAO();
        List<Hotel_Details> hotel = dao.LoadMoreHotel(offset);
        System.out.println(hotel.size());
        PrintWriter out = response.getWriter();
        String output = "";
        for (Hotel_Details h : hotel){
           output  += ("<div class=\"box num-hotel\">\n" +
                   "                <img src=\""+h.getImage()+"\" alt=\"\">\n" +
                   "                <div class=\"content\">\n" +
                   "                    <h3><i class=\"fas fa-map-marker-alt\"></i> "+h.getCity()+" </h3>\n" +
                   "                    <p>"+h.getName()+"</p>\n" +
                   "                    <div class=\"stars\">");
           for (int i = 1 ; i<=h.getStar();i++){
               output += "<i class=\"fas fa-star\"></i>";
           }
            double total = Math.ceil(h.getCost()*(1-h.getDiscount()/100)/24000);
            double cost = Math.ceil(h.getCost()/24000);
            output += " </div> <div class=\"price\"> "+total+" $ <span> "+cost+" $</span>\n" +
                    "                    </div>\n" +
                    "                    <a href=\"LoadBooking?id="+h.getId()+"\" class=\"btn\">book now</a>\n" +
                    "                </div>\n" +
                    "            </div>";

        }
        out.println(output);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
