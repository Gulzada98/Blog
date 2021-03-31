package org.itstep.blog.servlet;

import org.itstep.blog.dao.DbManager;
import org.itstep.blog.entity.Blog;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Blog> blogs = null;
        blogs = DbManager.GetAllBlogs();
        request.setAttribute("blogs", blogs);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

// register
// login
//