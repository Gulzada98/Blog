package org.itstep.blog.filter;

import org.itstep.blog.dao.DbManager;
import org.itstep.blog.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession();

        User currentUser = null;

        User user = (User) req.getSession().getAttribute("USER");

        if (user != null) {
            currentUser = DbManager.getUserByEmail(user.getEmail());
            if(currentUser.getPassword().equals(user.getPassword())) {
                req.getSession().setAttribute("USER", currentUser);
            } else{
                req.getSession().removeAttribute("USER");
            }
        }

        //

        chain.doFilter(request, response);

    }
}
