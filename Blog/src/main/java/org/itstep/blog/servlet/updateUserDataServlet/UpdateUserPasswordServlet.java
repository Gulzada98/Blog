package org.itstep.blog.servlet.updateUserDataServlet;

import org.itstep.blog.dao.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserPass")
public class UpdateUserPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("updateUserData/updateUserPass.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect;
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2)) {
            boolean update = DbManager.UpdateUserPassword(password1, email);
            if (update) {
                redirect = "updateUserPass?success";
            } else {
                redirect = "/updateUserPass?error=1"; // ERROR
            }
        } else {
            redirect = "/updateUserPass?error=2"; // passwords dont match
        }

        response.sendRedirect(redirect);
    }
}
