<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <style>
        .forms{
            border: darkgray;
            border-style: solid;
            width: 500px; /* 示例宽度 */
            padding: 0px 10px 10px 20px;
            margin: 300px auto ;
            font-size: 20px;
            font-family: 微软雅黑;
            border-radius: 30px;
        }
        .f{
            padding: 2px 10px 10px 10px;
            line-height: 50px;
            width: 500px; /* 示例宽度 */
        }

        a{
            text-decoration: none;
            color:black;
            font-size: 20px;
            font-family: 微软雅黑;
        }

        input[type="text"] {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
            width: 500px; /* 设置宽度为700像素 */
            height: 50px;/*高度为50像素*/
        }
        input[type="password"] {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
            width: 500px; /* 设置宽度为700像素 */
            height: 50px;/*高度为50像素*/
        }
        input[type="submit"] {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: none; /* 添加边框，以便看到输入框的边界 */
            width: 300px; /* 设置宽度为300像素 */
            padding: 20px 20px;
            font-size: 20px;
            text-align: center;
        }
        select {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
            width: 500px; /* 设置下拉菜单的宽度 */
            height: 50px; /* 设置下拉菜单的高度 */
            font-size: 18px; /* 设置下拉菜单中选项的字体大小 */
            padding: 5px; /* 设置下拉菜单内部填充，影响选项的显示高度 */
        }

        body {
            background-image: url("../login.jpg");
            background-repeat: no-repeat; /* 图片不重复 */
            background-size: cover; /* 图片覆盖整个背景 */
        }
    </style>
</head>
<body>
<div class="forms">
    <h3 >用户登录</h3>
    <form class="f"  action="${pageContext.request.contextPath}/login.do" method="post">
        <label >用户名：</label> <br>
        <input type="text" name="username" ><br>

        <label >密码：</label> <br>
        <input type="password" name="password"><br><br>

        <input type="submit" value="登录">
        <label><a href="admin/register.jsp">注册</a></label>
    </form>
</div>
</body>

</html>
