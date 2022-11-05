package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Rate_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.model.Rate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadComment", value = "/LoadComment")
public class LoadComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(request.getParameter("amount_cmt"));
        String id_hotel = request.getParameter("id_hotel");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("Account");
        Rate_DAO dao = new Rate_DAO();
        List<Rate> list = dao.getRate(id_hotel, offset);
        PrintWriter out = response.getWriter();
        for (Rate r : list) {
            String output = "<div class=\"num_comment review-item\">\n" +
                    "                    <div class=\"review-heading\">\n" +
                    "                        <div class=\"row\">\n" +
                    "                            <i class=\"user-icon fas fa-user\"></i>\n" +
                    "                            <h3 class=\"name\">" + r.getFullname() + "</h3>\n" +
                    "                            <p class=\"date\">" + r.getDate() + "</p>\n" +
                    "                        </div>\n";


            if (acc != null && r.getUID().equalsIgnoreCase(acc.getUID())) {
                output += "<div class=\"row\">\n" +
                        "                                <a class=\"delete-rate icon\" href=\"DeleteRate?id_rate=" + r.getId_rate() + "&id_hotel=" + r.getID_Hotel() + "\"><i class=\"fa-solid fa-trash-can\"></i></a>\n" +
                        "                            </div>";
            }

            output += "</div>\n" +
                    "                    <div class=\"stars\">";
            for (int i = 1; i <= r.getStars(); i++) {
                output += "<i class=\"fas fa-star\"></i>";
            }
            output += "</div>\n" +
                    "                    <div class=\"comment\">" + r.getComment() + "</div>\n" +
                    "                    </div>";

            out.println(output);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
