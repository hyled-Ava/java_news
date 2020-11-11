<%--
  Created by IntelliJ IDEA.
  User: hyled
  Date: 2020/11/10
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<div id="login">
    <h1>新闻管理系统</h1>
    <form method="post" action="userlogin">
        <input type="text" required="required" placeholder="用户名" name="username"></input>
        <input type="password" required="required" placeholder="密码" name="passwd"></input>
        <button class="but" type="submit">登录</button>
        <a href="userRegister.jsp" class="buta">注册</a>

    </form>
</div>
</body>
</html>
<style>
    html {
        width: 100%;
        height: 100%;
        overflow: hidden;
        font-style: italic;
    }

    body {
        width: 100%;
        height: 100%;
        font-family: 'Open Sans', sans-serif;
        margin: 0;
        background-color: #4A374A;
    }

    #login {
        position: absolute;
        top: 50%;
        left: 50%;
        margin: -150px 0 0 -150px;
        width: 300px;
        height: 300px;
    }

    #login h1 {
        color: #fff;
        text-shadow: 0 0 10px;
        letter-spacing: 1px;
        text-align: center;
    }

    h1 {
        font-size: 2em;
        margin: 0.67em 0;
    }

    input {
        width: 278px;
        height: 18px;
        margin-bottom: 10px;
        outline: none;
        padding: 10px;
        font-size: 13px;
        color: #fff;
        text-shadow: 1px 1px 1px;
        border-top: 1px solid #312E3D;
        border-left: 1px solid #312E3D;
        border-right: 1px solid #312E3D;
        border-bottom: 1px solid #56536A;
        border-radius: 4px;
        background-color: #2D2D3F;
    }

    .but {
        width: 100px;
        min-height: 20px;
        position: relative;
        top: 17px;
        background-color: #4a77d4;
        border: 1px solid #3762bc;
        color: #fff;
        padding: 9px 14px;
        font-size: 15px;
        box-sizing: border-box;
        line-height: normal;
        border-radius: 5px;
        margin: 0;
    }

    .buta {
        display: inline-block;
        width: 100px;
        min-height: 20px;
        position: relative;
        top: 17px;
        background-color: #4a77d4;
        border: 1px solid #3762bc;
        color: #fff;
        padding: 9px 14px;
        font-size: 15px;
        box-sizing: border-box;
        line-height: normal;
        border-radius: 5px;
        margin: 0;
    }
</style>

