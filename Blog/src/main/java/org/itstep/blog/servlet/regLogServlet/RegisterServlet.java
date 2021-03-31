package org.itstep.blog.servlet.regLogServlet;

import org.itstep.blog.dao.DbManager;
import org.itstep.blog.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getSession().removeAttribute("USER");
        request.getRequestDispatcher("regLog/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        User user1 = null;
        User user2 = null;

        user1 = new User(
                null,
                email,
                fullname,
                password1
        );

        user2 = DbManager.getUserByEmail(user1.getEmail());


        String redirect = "/register?error=3"; // если юзер с таким email уже существует

        if (user2 == null) {
            if (user1.getPassword().equals(password2)) {
                try {
                    DbManager.createNewUser(user1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                redirect = "/home";
                HttpSession session = request.getSession();
                System.out.println(user1);
                session.setAttribute("USER", user1);
            } else {
                redirect = "/register?password=" + user1.getPassword() + "&error=4";
            }
        }

        response.sendRedirect(redirect);
    }
}
