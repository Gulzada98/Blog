package org.itstep.blog.servlet.blogServlet;

import org.itstep.blog.dao.DbManager;
import org.itstep.blog.entity.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editBlog")
public class EditBlogServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long blogId = Long.parseLong(request.getParameter("blogId"));
        request.setAttribute("id", blogId);
        List<Blog> blogs = null;
        blogs = DbManager.GetAllBlogs();
        request.setAttribute("blogs", blogs);
        request.getRequestDispatcher("editBlog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Long blogId = Long.parseLong(request.getParameter("resBlogId"));

        String redirect = "/editBlog?error";

        boolean flag = DbManager.updateBlog(title, content, blogId);
        if (flag) {
            redirect = "/home";
        }

        response.sendRedirect(redirect);
    }
}