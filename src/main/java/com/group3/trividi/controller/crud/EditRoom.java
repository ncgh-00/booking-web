package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Room_Details;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(name = "EditRoom", value = "/EditRoom")
public class EditRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idr");
        Hotel_DAO dao = new Hotel_DAO();
        Room_Details r = dao.getRoomByid(id);
        System.out.println(r);
        request.setAttribute("r", r);
        request.getRequestDispatcher("editroom.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");

        String des = request.getParameter("description");
        String cost = request.getParameter("cost");
        String discount = request.getParameter("discount");

        Part file = request.getPart("image");

        String imageFileName = file.getSubmittedFileName();
            String uploadPath = "D:/Documents/1.FPT/FA22/SWP391/Trividi_Project/src/main/webapp/images/" + imageFileName;

            try {

                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = file.getInputStream();

                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        Hotel_DAO dao = new Hotel_DAO();
        String idr = request.getParameter("idroom");

        dao.editRoom(idr, name, des, cost, discount, imageFileName);
        response.sendRedirect("LoadMyHotel#manageroom");
    }
}
