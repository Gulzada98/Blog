package org.itstep.blog.servlet.updateUserDataServlet;

import org.itstep.blog.dao.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@WebServlet("/updateAva")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = ""
)
public class UserAvaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/updateUserFullname?error";
        Part part = request.getPart("avatar");
        try (InputStream fileInput = part.getInputStream()) {
            String path = getServletContext().getRealPath("/images");
            File file = new File(path + "/" + part.getSubmittedFileName());
            Files.copy(fileInput, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            //request.getSession().setAttribute("filePath", file);

            Long userId = Long.parseLong( request.getParameter("userID"));
            boolean update = DbManager.UpdateUserPhoto("images/" + part.getSubmittedFileName(), userId);
            if(update){
                redirect = "/updateUserFullname?success";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        response.sendRedirect(redirect);


        //request.getRequestDispatcher("updateUserData/updateUserFullname.jsp").forward(request, response);
        //response.sendRedirect("/updateUserFullname");

    }
}
