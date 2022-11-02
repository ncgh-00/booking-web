package com.group3.trividi.controller.load;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.model.Account_Info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchAccount", value = "/SearchAccount")
public class SearchAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        User_DAO dao = new User_DAO();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("Account");
        List<Account_Info> list = dao.searchUser(text, acc.getUID());
        PrintWriter out = response.getWriter();
        out.println("<div class=\"table__head\">\n" +
                "            <div class=\"table__cell header__table\">Full Name</div>\n" +
                "            <div class=\"table__cell header__table\">Email</div>\n" +
                "            <div class=\"table__cell header__table\">Phone</div>\n" +
                "            <div class=\"table__cell header__table\">User Name</div>\n" +
                "            <div class=\"table__cell header__table\">Role</div>\n" +
                "            <div class=\"table__cell header__table\">Hotel Manage</div>\n" +
                "            <div class=\"table__cell header__table\">Status</div>\n" +
                "        </div>");
        for (Account_Info o : list) {
            String output = "";
            output += "<div class=\"table__row\">\n" +
                    "                <div class=\"table__cell\" data-label=\"Full Name\">" + o.getFullname() + "</div>\n" +
                    "                <div class=\"table__cell align-center\" data-label=\"Email\">" + o.getEmail() + "</div>\n" +
                    "                <div class=\"table__cell align-center\" data-label=\"Phone\">" + o.getPhone() + "</div>\n" +
                    "                <div class=\"table__cell align-center\" data-label=\"User Name\">" + o.getUsername() + "</div>";

            if (o.getRoleID() == 1)
                output += "<div class=\"table__cell align-center\">\n" +
                        "                    <div class=\"role role-1 \">";
            else if (o.getRoleID() == 2)
                output += "<div class=\"table__cell align-center\">\n" +
                        "                    <div class=\"role role-2 \">";
            else if (o.getRoleID() == 3)
                output += "<div class=\"table__cell align-center\">\n" +
                        "                    <div class=\"role role-3 \">";

            output += "" + o.getRoleName() + "\n" +
                    "                        <div class=\"set-role\">\n" +
                    "                            <a href=\"EditRole?id=" + o.getUID() + "&role=1\" class=\"option\"><p class=\"op-1\">Admin</p></a>\n" +
                    "                            <a href=\"EditRole?id=" + o.getUID() + "&role=2\" class=\"option\"><p class=\"op-2\">Staff</p></a>\n" +
                    "                            <a href=\"EditRole?id=" + o.getUID() + "&role=3\" class=\"option\"><p class=\"op-3\">User</p></a>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n";
            if(o.getRoleID() != 2)
                output += "<div class=\"table__cell align-center\">No</div>";
            else if(o.getRoleID() == 2 && o.getHotelManage() != null)
                output += "<div class=\"table__cell align-center\">"+o.getHotelManage()+"</div>";
            else if(o.getRoleID() == 2 && o.getHotelManage() == null)
                output += "<div class=\"table__cell align-center\"><a href=\"LoadAddHotelForStaff?staffid="+o.getUID()+"\" class=\"add-btn\">Add Hotel</a></div>";
            if(o.isStatus())
                output += "<div class=\"table__cell align-center\" data-label=\"Status\">\n" +
                        "                        <a title=\"Change status\"\n" +
                        "                           href=\"ActivateAccounts?uid="+ o.getUID() +"&check="+o.isStatus()+"&page=LoadAccounts\"\n" +
                        "                           class=\"badge badge-active\">active</a>\n" +
                        "                    </div>\n" +
                        "</div>";
            else
                output += "<div class=\"table__cell align-center\" data-label=\"Status\">\n" +
                        "                        <a title=\"Change status\"\n" +
                        "                           href=\"ActivateAccounts?uid="+ o.getUID() +"&check="+o.isStatus()+"&page=LoadAccounts\"\n" +
                        "                           class=\"badge badge-inactive\">inactive</a>\n" +
                        "                    </div>\n" +
                        "</div>";

            out.println(output);

        }

    }
}
