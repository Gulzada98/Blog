<%@ page import="org.itstep.blog.entity.Blog" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Add Blog</title>
    <%@ include file="template/head.jsp" %>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/4/tinymce.min.js" referrerpolicy="origin"></script>
    <script type="text/javascript">
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp" %>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm-10 offset-1">

            <%
                if (request.getParameter("error") != null) {
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Couldn't change blog!!!</strong>
            </div>
            <%
                }
            %>

            <%
                List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
                Long id = (Long) request.getAttribute("id");
                if (blogs != null) {
                    for (Blog b : blogs) {
                        if (b.getId() == id) {
            %>

            <form action="/editBlog" method="post">
                <div class="form-group">
                    <label>
                        TITLE:
                    </label>
                    <input type="text" name="title" class="form-control" value="<%=b.getTitle()%>">
                    <input type="hidden" name="resBlogId" value="<%=b.getId()%>">
                </div>
                <div class="form-group">
                    <label>
                        CONTENT:
                    </label>
                    <textarea class="form-control" rows="10" name="content"
                              id="mytextarea"><%=b.getContent()%></textarea>
                </div>
                <div class="form-group mt-2">
                    <button class="btn btn-success">Save changes</button>
                </div>
            </form>
            <%
                        }
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>