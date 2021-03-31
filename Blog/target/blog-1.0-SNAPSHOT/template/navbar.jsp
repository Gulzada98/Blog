<%@ page import="org.itstep.blog.entity.User" %>
<%
    User user = (User) request.getSession().getAttribute("USER");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">BLOG</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <%
                    if(user !=null){

                %>

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="/updateUser"><%=user.getFullName()%></a>--%>
<%--                </li>--%>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
                        <%=user.getFullName()%>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/updateUserFullname">Edit fullname</a></li>
                        <li><a class="dropdown-item" href="/updateUserPass">Edit Password</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/addBlog">Add Blog</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/logout">Log out</a>
                </li>

                <%
                    } else{
                %>

                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>

                <%
                    }
                %>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
