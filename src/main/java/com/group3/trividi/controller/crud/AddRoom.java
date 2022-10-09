package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
@MultipartConfig
@WebServlet(name = "AddRoom", value = "/AddRoom")
public class AddRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idh = request.getParameter("idh");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String cost = request.getParameter("cost");
        String discount = request.getParameter("discount");

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
        System.out.println("id hotel ne nhe: "+idh);
        dao.addRoom(idh, name, imageFileName, description, cost, discount);
        response.sendRedirect("LoadMyHotel#manageroom");

    }
}
