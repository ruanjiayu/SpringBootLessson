<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/9
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    单文件上传:  <br>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="提交上传" />
    </form>
    <br>
    多文件上传: <br>
    <form action="/uploads" method="post" enctype="multipart/form-data">
        文件1: <input type="file" name="files" /> <br>
        文件2: <input type="file" name="files" /> <br>
        文件3: <input type="file" name="files" /> <br>
        <button type="submit">提交多文件</button>
    </form>
</body>
</html>
