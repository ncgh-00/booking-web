package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchHotel", value = "/SearchHotel")
public class SearchHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("hotelname");
        Hotel_DAO dao = new Hotel_DAO();
        List<Hotel_Details> list = dao.searchHotels(name, "", "");
        PrintWriter out = response.getWriter();
        out.println("<div class=\"table__head\">\n" +
                "            <div class=\"table__cell header__table\">Hotel's Name</div>\n" +
                "            <div class=\"table__cell header__table\">Description</div>\n" +
                "            <div class=\"table__cell header__table\">Category</div>\n" +
                "            <div class=\"table__cell header__table\">Phone</div>\n" +
                "            <div class=\"table__cell header__table\">Address</div>\n" +
                "            <div class=\"table__cell header__table\">Number Of Star</div>\n" +
                "            <div class=\"table__cell header__table\">City</div>\n" +
                "            <div class=\"table__cell header__table\">Status</div>\n" +
                "            <div class=\"table__cell header__table\">priority</div>\n" +
                "        </div>");
        for (Hotel_Details a: list) {
            String output = "<div class=\"table__row\">\n" +
                    "            <div class=\"table__cell\">"+a.getName()+"</div>\n" +
                    "            <div class=\"table__cell\">"+a.getDes()+"</div>\n" +
                    "            <div class=\"table__cell align-center\">"+a.getCategory()+"</div>\n" +
                    "            <div class=\"table__cell align-center\">"+a.getPhone()+"</div>\n" +
                    "            <div class=\"table__cell\">"+a.getAddress()+"</div>\n" +
                    "            <div class=\"table__cell align-center\">"+a.getStar()+"</div>\n" +
                    "            <div class=\"table__cell align-center\">"+a.getCity()+"</div>";

            if (a.isStatus())
                output += "<div class=\"table__cell align-center\">\n" +
                        "                <a href=\"ActivateHotel?id="+a.getId()+"&check="+a.isStatus()+"&page=LoadHotels\"\n" +
                        "                   class=\"badge badge-active\" title=\"Change status\">Active</a>\n" +
                        "            </div>";
            else
                output += "<div class=\"table__cell align-center\">\n" +
                        "                    <a href=\"ActivateHotel?id="+a.getId()+"&check="+a.isStatus()+"&page=LoadHotels\"\n" +
                        "                       class=\"badge badge-inactive\" title=\"Change status\">Inactive</a>\n" +
                        "                </div>";
            if (a.getPriority()==1) output += "<div class=\"table__cell align-center\">\n" +
                    "                <div class=\"priority priority-1\">";
            else if (a.getPriority()==2) output += "<div class=\"table__cell align-center\">\n" +
                    "                <div class=\"priority priority-2\">";
            else if (a.getPriority()==3) output += "<div class=\"table__cell align-center\">\n" +
                    "                <div class=\"priority priority-3\">";
            else if (a.getPriority()==4) output += "<div class=\"table__cell align-center\">\n" +
                    "                <div class=\"priority priority-4\">";
            else if (a.getPriority()==5) output += "<div class=\"table__cell align-center\">\n" +
                    "                <div class=\"priority priority-5\">";

            output += "<div class=\"set-priority\">\n" +
                    "                        <a href=\"EditPriority?id="+a.getId()+"&priority=1\" class=\"option\"><p class=\"op-1\">Priority: 1</p></a>\n" +
                    "                        <a href=\"EditPriority?id="+a.getId()+"&priority=2\" class=\"option\"><p class=\"op-2\">Priority: 2</p></a>\n" +
                    "                        <a href=\"EditPriority?id="+a.getId()+"&priority=3\" class=\"option\"><p class=\"op-3\">Priority: 3</p> </a>\n" +
                    "                        <a href=\"EditPriority?id="+a.getId()+"&priority=4\" class=\"option\"><p class=\"op-4\">Priority: 4</p></a>\n" +
                    "                        <a href=\"EditPriority?id="+a.getId()+"&priority=5\" class=\"option\"><p class=\"op-5\">Priority: 5</p></a>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>";
            out.println(output);

        }
    }
}
