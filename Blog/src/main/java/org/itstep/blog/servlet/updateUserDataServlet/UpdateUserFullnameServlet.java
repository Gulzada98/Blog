package org.itstep.blog.servlet.updateUserDataServlet;

import org.itstep.blog.dao.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateUserFullname")
public class UpdateUserFullnameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("updateUserData/updateUserFullname.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String redirect = "/updateUserFullname?error";
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");

        boolean update = DbManager.UpdateUserFullName(fullname, email);
        if (update) {
            redirect = "updateUserFullname?success";
        }

        response.sendRedirect(redirect);
    }
}
