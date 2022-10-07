package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.model.City;
import com.group3.trividi.model.Hotel_Category;
import com.group3.trividi.utils.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

@MultipartConfig
@WebServlet(name = "EditHotel", value = "/EditHotel")
public class EditHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String des = request.getParameter("description");
        String category = request.getParameter("category");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String numOfStar = request.getParameter("numOfStar");
        String city = request.getParameter("city");
//        String image = request.getParameter("image");
        Part file =   request.getPart("image");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:/Lesson Material/SWP/booking-web/src/main/webapp/images/"+imageFileName;

        try {

            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        Hotel_DAO dao = new Hotel_DAO();
        String idh = request.getParameter("idhotel");

        dao.editHotel(idh, name,des, category, phone, address, numOfStar, city, imageFileName);
        response.sendRedirect("LoadMyHotel");

    }
}
