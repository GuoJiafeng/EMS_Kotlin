<%--
  Created by IntelliJ IDEA.
  User: BlackBeard丶
  Date: 2017/9/17
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/ShowOneEmpAction" method="post">
  查找一个人：  <input type="text" name="id">
                <input type="submit">
</form>

<form action="/ShowAllEmpAction" method="post">
    查找所有人：  <input type="text" name="pageNum">
    <input type="submit">
</form>
<form action="/DeleteEmpAction" method="post">
    删除一个人：  <input type="text" name="id">
    <input type="submit">
</form>
</body>
</html>
