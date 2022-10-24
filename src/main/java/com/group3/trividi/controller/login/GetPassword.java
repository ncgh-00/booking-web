package com.group3.trividi.controller.login;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.Validation;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "GetPassword", value = "/GetPassword")
public class GetPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //jpfdlekcrgtcosnw
        String email = request.getParameter("email");
        if(!Validation.validEmail(email)){
            request.setAttribute("error", "The mail is invalid!");
            request.getRequestDispatcher("getpassword.jsp").forward(request,response);
            return;
        }
        User_DAO dao = new User_DAO();
        Account acc = dao.getUserByEmail(email);
        if (acc == null){
            request.setAttribute("error", "The email has not been used on the website yet!");
            request.getRequestDispatcher("getpassword.jsp").forward(request,response);

        } else {
            String newpass = HashPassword.generatePassword(8);
            dao.resetPassword(newpass,email);
            final String username = "g3trividibooking@gmail.com";
            final String password = "jpfdlekcrgtcosnw";

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("g3trividibooking@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email)
                );
                message.setSubject("[RESET PASSWORD]");
                String xxx = "<body style=\"margin-left: 20px; color: #000; font-size: 16.5px;\">\n" +
                        "    <h2 style=\"margin-left: 50px;\">Trividi Booking System Password Reset</h2>\n" +
                        "    <p>Hi "+acc.getUsername()+",</p>\n" +
                        "    <p>We heard that you lost your account password.</p>\n" +
                        "    <p>But don't worry! We have sent you a new password in this email, you can change it on our website.</p>\n" +
                        "    <p><b>Your new password is: "+newpass+"</b></p>\n" +
                        "    <p><a href=\"http://localhost:8080/Trividi_Project/login.jsp\">Click here </a>to login!</p>\n" +
                        "    <p>Thanks,</p>\n" +
                        "    <p>The Trividi Booking System Support Team</p>\n" +
                        "</body>";
                message.setContent(xxx,"text/html");

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            request.setAttribute("success", "Email was sent! Please check your email!");
            request.getRequestDispatcher("getpassword.jsp").forward(request,response);
        }
    }
}
