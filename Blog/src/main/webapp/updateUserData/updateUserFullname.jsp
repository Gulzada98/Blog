<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="../template/head.jsp" %>

</head>
<body>
<%@include file="../template/navbar.jsp" %>

<div class="container mt-5">
    <div class="row">
        <div class="col-sm-4 offset-4">
            <%
                if (request.getParameter("error") != null) {
            %>
            <div class="alert alert-danger">
                <strong>Problems with update!</strong>
            </div>
            <%
                }
            %>
            <%
                if (request.getParameter("success") != null) {
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Photo changed successfully!!!</strong>
            </div>
            <%
                }
            %>

            <div class="row">
                <div class="col-sm-6 offset-3">
                    <%--                    <%--%>
                    <%--                        String filePath = (String) request.getAttribute("filePath");--%>
                    <%--                        if (filePath == null) {--%>
                    <%--                            filePath = "/images/ava1.jpg";--%>
                    <%--                        }--%>
                    <%--                    %>--%>

                    <div class="card">
<%--                        <img src="images/ava1.jpg" class="card-img-top">--%>
                        <img src="<%=user.getPhoto()%>" class="card-img-top">
                    </div>
                    <form action="/updateAva" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" name="userID" value=<%=user.getId() %>>
                            <input type="file" class="form-control-file" id="exampleFormControlFile1"
                                   name="avatar">
                        </div>

                        <div class="form-group mt-2">
                            <button class="btn btn-success">Update Avatar</button>
                        </div>

                    </form>

                    <%--                    <div id="touxiang">--%>
                    <%--                        <img class="userinfo-head" src="<%=user.getPhoto() %>" alt='avatar' width="100" height="100"--%>
                    <%--                             id="showimg">--%>
                    <%--                    </div>--%>
                </div>
            </div>


            <form action="updateUserFullname" method="post">

                <div class="form-group">
                    <label>EMAIL: </label>
                    <input class="form-control" type="email" name="email" required readonly
                           value="<%=user != null ? user.getEmail():""%>">
                </div>

                <div class="form-group">
                    <label>FULLNAME: </label>
                    <input class="form-control" type="text" name="fullname" required
                           value="<%=user != null ? user.getFullName():""%>">
                </div>

                <div class="form-group mt-2">
                    <button class="btn btn-success">Save changes</button>
                </div>
            </form>

        </div>
    </div>

</div>


</body>
</html>
