<%--
  Created by IntelliJ IDEA.
  User: hyled
  Date: 2020/11/10
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.*" %>
<%@ page import="com.dao.UsersDao" %>
<html>
<head>
    <title>showmessage</title>
</head>
<%! int id; %>
<% Users users;
    UsersDao userdao = new UsersDao();
    id = (int) session.getAttribute("id");
    users = userdao.selectById(id);
%>
<p>用户名：</p><%=users.getname()%>
<p>性别：</p><%=users.getSex()%>
<p>个人简介：</p><%=users.gethoby()%>
<%--<p>用户名：</p><%=users.getUsername()%>--%>
<%--<p>用户名：</p><%=users.getUsername()%>--%>
<%--<p>用户名：</p><%=users.getUsername()%>--%>


<%--<%! String M ; %>--%>
<%--HttpSession session =request.getSession();--%>
<%--session.setAttribute("username",user);--%>
<%--<body>--%>
<%--<p>it is a message</p>--%>
<%--<%--%>
<%--    M= session.getAttribute("username").toString();--%>
<%--    out.print(M);--%>
<%--    %>--%>
<%--it is <%= M %>--%>
<%--it is ${session.getAttribute("username").toString()}--%>
</body>
</html>
