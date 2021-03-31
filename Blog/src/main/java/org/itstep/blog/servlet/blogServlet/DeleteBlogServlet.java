package org.itstep.blog.servlet.blogServlet;

import org.itstep.blog.dao.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteBlog")
public class DeleteBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String redirect = "/deleteBlog?error";
        boolean delete = DbManager.deleteBlogById(id);

        if(delete){
            redirect = "/home?success";
        }

        response.sendRedirect(redirect);
    }
}
