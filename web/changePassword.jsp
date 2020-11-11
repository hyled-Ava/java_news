<%-- 
    Document   : register
    Created on : 2020-11-4, 14:45:25
    Author     : netpr1s0ner
--%>
<%@page import="java.util.*" %>
<%@page import="java.sql.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>信息修改</title>
</head>
<body>
<div style="text-align: center">
    <br><br>
    <i><h1>change your information</h1></i>
    <br><br>
    <form style="text-align: center" action="changePassword" method="post">
        <label>旧密码 </label><input name="oldpassword" placeholder="input your oldpassword"><br><br>
        <label>新密码 </label><input name="password" type="password" placeholder="input your password"><br><br>
        <label>确认密码 </label><input name="password" type="checkpassword" placeholder="check your password"><br><br>
        <input type="submit" value=" 提 交 ">


    </form>
</div>

</body>
</html>
