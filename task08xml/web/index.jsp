<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 22.08.2021
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>task08</title>
</head>
<body>
<center>
    <h1>File Upload</h1>
    <form method="post" action="UploadServlet" enctype="multipart/form-data">
<%--                <input type="hidden" name="command" value="parse_upload_file"/>--%>
        Select file to upload: <input type="file" name="xmlFile" size="60" accept="text/xml"/><br/><br>
        Select model for parse XML file
        <select name="parserType">
            <option value="DOM">DOM</option>
            <option value="SAX">SAX</option>
            <option value="StAX">StAX</option>
        </select><br>
        <br/> <input type="submit" value="Parse"/>
    </form>
</center>
</body>
</html>
