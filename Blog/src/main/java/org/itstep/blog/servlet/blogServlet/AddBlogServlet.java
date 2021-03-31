package org.itstep.blog.servlet.blogServlet;

import org.itstep.blog.dao.DbManager;
import org.itstep.blog.entity.Blog;
import org.itstep.blog.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addBlog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("USER");

        if (currentUser != null) {
            request.setAttribute("user", currentUser);
            request.getRequestDispatcher("addBlog.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        User author = (User) request.getSession().getAttribute("USER");

        Blog blog = new Blog(null, title, content, author);

        String redirect = "/addBlog?error";

        if (author != null) {
            boolean flag = DbManager.createNewBlog(blog);
            if (flag) {
                redirect = "/home?success";
            }
        }
        response.sendRedirect(redirect);
    }
}
