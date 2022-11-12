package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;
import com.group3.trividi.utils.Validation;

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
@WebServlet(name = "EditHotel", value = "/EditHotel")
public class EditHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel_DAO hotel = new Hotel_DAO();
        String idh = request.getParameter("idh");
        Hotel_Details h = hotel.getHotel(idh);
        request.setAttribute("hotel", h);
        request.getRequestDispatcher("edithotel.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String des = request.getParameter("description");
        String category = request.getParameter("category");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String numOfStar = request.getParameter("numOfStar");
        String city = request.getParameter("city");
        String lng = request.getParameter("lng");
        String lat = request.getParameter("lat");

        Hotel_DAO dao = new Hotel_DAO();
        String idh = request.getParameter("idhotel");
        Hotel_Details h = dao.getHotel(idh);

        if (lat == null) {
            lat = "";
        } else if (!Validation.validLocation(lat)) {
            request.setAttribute("hotel", h);
            request.setAttribute("error", "Location is invalid");
            request.getRequestDispatcher("edithotel.jsp").forward(request, response);
            return;
        }

        if (lng == null) {
            lng = "";
        } else if (!Validation.validLocation(lng)) {
            request.setAttribute("hotel", h);
            request.setAttribute("error", "Location is invalid");
            request.getRequestDispatcher("edithotel.jsp").forward(request, response);
            return;
        }


        if (phone == null) {
            phone = "";
        } else if (!Validation.validPhone(phone)) {
            request.setAttribute("hotel", h);
            request.setAttribute("error", "Phone is invalid");
            request.getRequestDispatcher("edithotel.jsp").forward(request, response);
            return;
        }
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

        dao.editHotel(idh, name, des, category, phone, address, numOfStar, city, lng, lat, imageFileName);
        response.sendRedirect("LoadMyHotel#managehotel");

    }
}
