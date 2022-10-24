package com.group3.trividi.controller.login;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.NameGenerator;
import com.group3.trividi.utils.Validation;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "SignUp", value = "/SignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        Cookie[] cookies = request.getCookies();
        String c_code = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("code")) {
                    c_code = c.getValue();
                    break;
                }
            }
        }
        if (code.equalsIgnoreCase(c_code)) {
            for (Cookie c : cookies) {
                if (c.getName().equals("code")) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
            HttpSession session = request.getSession();
            User_DAO dao = new User_DAO();
            dao.activate((String) session.getAttribute("uid"), false);
            String id = (String) session.getAttribute("id-hotel");
            String page = (String) session.getAttribute("page");
            request.setAttribute("id", id);
            request.setAttribute("page", page);
            request.setAttribute("success", "Your account was cofirm successfully!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("user_name");
        String name = request.getParameter("name");
        String mail = request.getParameter("email");
        String password = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String phone = request.getParameter("phone");
        String page = request.getParameter("page");
        String id_hotel = request.getParameter("id");

        User_DAO dao = new User_DAO();
        if (dao.checkEmail(mail)) {
            request.setAttribute("errorSignup", "Email was used !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (!Validation.validEmail(mail)) {
            request.setAttribute("errorSignup", "Email invalid !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (dao.checkPhone(phone)) {
            request.setAttribute("errorSignup", "Phone was used !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (!Validation.validPhone(phone)) {
            request.setAttribute("errorSignup", "Phone invalid !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (dao.checkUsername(username)) {
            request.setAttribute("errorSignup", "Username was used !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (password.length() < 6) {
            request.setAttribute("errorSignup", "Password must be greater than 6 character !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (!password.equals(repass)) {
            request.setAttribute("errorSignup", "Password and Repassword don't match !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            request.removeAttribute("errorSignup");
            dao.insert(3, username, HashPassword.getHashedPassword(password), name, mail, phone, 0);
            Account a = dao.getUSer(username, HashPassword.getHashedPassword(password));
            String code = NameGenerator.randomIdentifier();

            final String username_mail = "g3trividibooking@gmail.com";
            final String password_mail = "jpfdlekcrgtcosnw";

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username_mail, password_mail);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("g3trividibooking@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("[CONFIRM ACCOUNT]");
                String xxx = "<body style=\"margin-left: 20px; color: #000; font-size: 16.5px; font-family:sans-serif;\">\n" +
                        "    <h2 style=\"margin-left: 50px;\">Trividi Booking System</h2>\n" +
                        "    <p>Hi " + username + ",</p>\n" +
                        "    <p>Welcome to Trividi website!</p>\n" +
                        "    <p>This email was sent to confirm your account.</p>\n" +
                        "    <p><b>Click the button below to confirm your account.</b></p>\n" +
                        "    <a style=\"background-color:#ffa500; padding: 1em 0.8em; font-size: 80%; font-weight: 600; color:#333; border-radius: .25rem; text-decoration: none;\"" +
                        "href=\"http://localhost:8080/Trividi_Project/SignUp?code=" + code + "\">Confirm</a>\n" +
                        "    <p>Thanks,</p>\n" +
                        "    <p>The Trividi Booking System Support Team</p>\n" +
                        "</body>";
                message.setContent(xxx, "text/html");

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            HttpSession s = request.getSession();
            Cookie cookie = new Cookie("code", code);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            s.setAttribute("id-hotel", id_hotel);
            s.setAttribute("page", page);
            s.setAttribute("uid", a.getUID());
            request.setAttribute("success", "Please check your email to confirm your account!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);

        }
    }
}
