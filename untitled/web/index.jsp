<%--
  Created by IntelliJ IDEA.
  User: 千伶
  Date: 2024/5/31
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <style>
        .welcome{
            border: darkgray;
            border-style: solid;
            width: 200px; /* 示例宽度 */
            padding: 0px 10px 10px 20px;
            margin: 200px auto ;
            font-size: 20px;
            font-family: 微软雅黑;
            border-radius: 30px;
            text-align: center;
        }

        a{
            text-decoration: none;
            color:black;
            font-size: 20px;
            font-family: 微软雅黑;
        }

        body {
            background-image: url("login.jpg");
            background-repeat: no-repeat; /* 图片不重复 */
            background-size: cover; /* 图片覆盖整个背景 */
        }
    </style>
</head>
<body>
<div class="welcome">
    <h3>欢迎登录</h3>
    <a href="admin/login.jsp">登录</a><br>
    <a href="admin/register.jsp">注册</a>
</div>
<%--

1.为程序添加过滤器
2.把操作和在一起，进行跳转
3.用户界面的查看新闻（新闻的数据回显）
4.删除用户后，重新进行查询显示数据列表

--%>
</body>
</html>
