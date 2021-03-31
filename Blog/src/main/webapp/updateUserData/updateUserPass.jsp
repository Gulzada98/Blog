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
                Object error = request.getParameter("error");
                if (error != null && error.equals("1")) {
            %>
            <div class="alert alert-danger">
                <strong>Problems with update!</strong>
            </div>
            <%
                }
            %>

            <%
                if (error != null && error.equals("2")) {
            %>
            <div class="alert alert-warning">
                <strong>Password doesn't match!</strong>
            </div>
            <%
                }
            %>
            <%
                if(request.getParameter("success")!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Password changed successfully!!!</strong>
            </div>
            <%
                }
            %>

            <div class="card">
                <%--<img src="images/ava1.jpg" class="card-img-top">--%>
                <img src="<%=user.getPhoto()%>" class="card-img-top">
            </div>

            <form action="updateUserPass" method="post">

                <div class="form-group">
                    <label>EMAIL: </label>
                    <input class="form-control" type="email" name="email" required
                           value="<%=user != null ? user.getEmail():""%>">
               </div>

                <div class="form-group">
                    <label>PASSWORD: </label>
                    <input class="form-control" type="password" name="password1" required>
                </div>

                <div class="form-group">
                    <label>CONFIRM PASSWORD: </label>
                    <input class="form-control" type="password" name="password2" required>
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
