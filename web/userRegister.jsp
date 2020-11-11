<%--
  Created by IntelliJ IDEA.
  User: hyled
  Date: 2020/11/10
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <title>注册</title>
</head>
<body>
<div>
    <form class="form1" action="register" method="post">
        <p>昵称：</p>
        <input type="text" placeholder="请填入" name="name">
        <p>用户名：</p>
        <input type="text" placeholder="请填入" name="username">
        <p>密码：</p>
        <input type="text" placeholder="请填入" name="password">
        <p>性别：</p>
        <input type="text" placeholder="请填入" name="sex">
        <p>简介：</p>
        <input type="text" placeholder="请填入" name="hoby">
        <p><input type="submit" value="注册"></p>

    </form>
</div>
</body>
</html>
<style>
    .html, body {
        background-color: burlywood;
    }
</style>
