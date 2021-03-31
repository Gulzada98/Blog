<%@ page import="java.util.List" %>
<%@ page import="org.itstep.blog.entity.Blog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="template/head.jsp" %>

</head>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp" %>
</div>

<div class="container mt-3">
    <div class="row">
        <div class="col-sm-12">

            <%
                List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
                if (blogs != null) {
                    for (Blog b : blogs) {
            %>

            <div class="container bg-info" style="margin-bottom: 3rem">
                <h1 class="display-4"><%=b.getTitle()%>
                </h1>
                <p class="lead"><%=b.getContent()%>
                </p>
                <hr class="my-4">
                <b>Posted by <%=b.getAuthor().getFullName()%> at <%=b.getPostDate()%>
                </b>
                <p style="padding-bottom: 10px"><%=b.getAuthor().getFullName()%> was online at <%=b.getPostDate()%>
                </p>

                <%
                    if (user != null && user.getEmail().equals(b.getAuthor().getEmail())) {
                %>

                <div style="padding-bottom: 10px">
                    <div class="form-group">
                        <form action="/deleteBlog" method="post">
                            <input type="hidden" name="id" value="<%=b.getId()%>">
                            <button class="btn btn-success" style="width: 100px" onclick="showAlert()">Delete</button>
                        </form>

                        <form action="/editBlog" method="get">
                            <input type="hidden" name="blogId" value="<%=b.getId()%>">
                            <button class="btn btn-success" style="width: 100px">Edit</button>
                        </form>
                    </div>
                </div>
                <%
                    }
                %>

            </div>
            <%
                    }
                }
            %>


        </div>

    </div>
</div>

<script type="text/javascript">
    function showAlert() {
        alert("Are you sure?");
    }

   /* function showAlert()  {

        var result = confirm("Are you sure?");

        if(result)  {
            alert("Blog deleted!");
        } else {
            return result;
        }
    }*/
</script>
</body>
</html>
