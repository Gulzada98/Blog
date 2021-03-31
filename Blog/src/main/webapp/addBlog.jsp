<html>
<head>
    <title>Add Blog</title>
    <%@ include file="template/head.jsp"%>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/4/tinymce.min.js" referrerpolicy="origin"></script>
    <script type="text/javascript">
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp"%>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm-10 offset-1">
            <%
                if(request.getParameter("success")!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Blog added successfully!!!</strong>
            </div>
            <%
                }
            %>
            <%
                if(request.getParameter("error")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Couldn't add blog!!!</strong>
            </div>
            <%
                }
            %>
            <form action="/addBlog" method="post">
                <div class="form-group">
                    <label>
                        TITLE:
                    </label>
                    <input type="text" name="title" class="form-control">
                </div>
                <div class="form-group">
                    <label>
                        CONTENT:
                    </label>
                    <textarea class="form-control" rows="10" name="content" id="mytextarea">
              </textarea>
                </div>
                <div class="form-group">
                    <button class="btn btn-success">ADD BLOG</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>