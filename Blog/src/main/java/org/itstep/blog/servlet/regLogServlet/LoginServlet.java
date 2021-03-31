package org.itstep.blog.servlet.regLogServlet;

import org.itstep.blog.dao.DbManager;
import org.itstep.blog.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("regLog/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = null;

        user = DbManager.getUserByEmail(email);

        String redirect = "/login?error=1"; // если юзера нет

        if (user != null) {
            if (user.getPassword().equals(password)) {
                redirect = "/home";
                HttpSession session = request.getSession();
                System.out.println(user);
                session.setAttribute("USER", user);
            } else {
                redirect = "/login?email=" + user.getEmail() + "&error=2";
            }
        }

        response.sendRedirect(redirect);
    }
}
