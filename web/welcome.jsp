<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
<html>
<script type="text/javascript">
    function change(nid) {
        var ele = document.getElementById(nid);
        var child = ele.children;

        if (child[0].getAttribute('hidden')) {
            child[0].removeAttribute("hidden")

        } else {

            child[0].setAttribute('hidden', 'net')

        }


    }


</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>管理中心</title>

<body background="https://gitee.com/hyled-Ava/image2020/raw/master/20201111114852.jpeg">
<div style="text-align:center"><i><H3>欢迎来到新闻管理系统</H3></i></div>
<div style="width:15%;height:700px;border:2px solid #000000;float:left;border-radius:0px;">
    <ul style="list-style:none;font-size:20px; text-align:center; line-height:50px">
        <li id='a' onClick="change('a')">个人管理
            <ul style="list-style:none;font-size:20px;" hidden='net' style="text-align:left">
                <li><a href="showmessage.jsp" target="right"
                       style="text-decoration:none; padding:8px;background-color:#99CCFF;border:2px;border-color: #000000;color:#FFFFFF">个人信息</a>
                </li>
                <li><a href="changePassword.jsp" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">密码修改</a></li>
            </ul>
        </li>
        <li id='c' onClick="change('c')">用户管理
            <ul style="list-style:none;font-size:20px;" hidden='net' style="text-align:left">
                <li><a href="admin.AdminDeal?user=adminaabb&thing=6" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">账户创建</a></li>

                <li><a href="admin.AdminDeal?user=adminaabb&thing=7" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">密码重置</a></li>

                <li><a href="admin.AdminDeal?user=adminaabb&thing=9" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">权限修改</a></li>
            </ul>
        </li>
        <li id='b' onClick="change('b')">新闻管理
            <ul style="list-style:none;font-size:20px;" hidden='net' style="text-align:left">
                <li><a href="/news_war_exploded/ckeditor_new/ckeditor/ckeditor.html" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">创建新闻稿</a></li>
                <li><a href="admin.AdminDeal?user=adminaabb&thing=4" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">管理新闻</a></li>
                <li><a href="admin.AdminDeal?user=adminaabb&thing=5" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">发布新闻</a></li>
                <li><a href="admin.AdminDeal?user=adminaabb&thing=8" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">删除新闻</a></li>

                <li><a id="hiden" href="admin.AdminDeal?user=adminaabb&thing=8" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">删除新闻1</a></li>
            </ul>
        </li>


        <li id='d' onClick="change('d')">系统设置
            <ul style="list-style:none;font-size:20px;" hidden='net' style="text-align:left">
                <li><a href="https://www.csdn.net/" target="right"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">功能设置</a></li>
                <li><a href="/"
                       style="text-decoration:none; padding:8px; background-color:#99CCFF; color:#FFFFFF">退出系统</a></li>
            </ul>
        </li>

    </ul>
</div>

<iframe name="right"></iframe>
</body>
</html>

<style>
    iframe {
        width: 82.5%;
        height: 700px;
        float: right;
        border: 2px solid #000000;
        border-radius: 2px;
    }

    body {
        background-color: #FFFFFF;
    }

    #a {
        width: 75%;
        background-color: #99CCFF;
        color: white;
        font-size: 25px;
        padding: 14px 20px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    #b {
        width: 75%;
        background-color: #99CCFF;
        color: white;
        font-size: 25px;
        padding: 14px 20px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    #c {
        width: 75%;
        background-color: #99CCFF;
        color: white;
        font-size: 25px;
        padding: 14px 20px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    #d {
        width: 75%;
        background-color: #99CCFF;
        color: white;
        font-size: 25px;
        padding: 14px 20px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    body, td, th {
        font-family: 新宋体;
        font-size: medium;
        color: #000000;
    }
</style>