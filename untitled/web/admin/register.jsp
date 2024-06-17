<%--
  Created by IntelliJ IDEA.
  User: 千伶
  Date: 2024/5/31
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .forms{
            border: darkgray;
            border-style: solid;
            width: 500px;
            padding: 0px 10px 10px 20px;
            margin: 100px auto ;
            font-size: 20px;
            font-family: 微软雅黑;
            border-radius: 30px;
        }
        .f{
            line-height: 30px;
        }

        input[type="text"] {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
            font-size: 20px; /* 设置下拉菜单中选项的字体大小 */
            width: 400px; /* 设置宽度为300像素 */
            height: 40px;/*高度为50像素*/
        }
        input[type="password"] {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
            font-size: 20px; /* 设置下拉菜单中选项的字体大小 */
            width: 400px; /* 设置宽度为300像素 */
            height: 40px;/*高度为50像素*/
        }
        select {
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
            width: 400px; /* 设置下拉菜单的宽度 */
            height: 40px; /* 设置下拉菜单的高度 */
            font-size: 18px; /* 设置下拉菜单中选项的字体大小 */
            padding: 5px; /* 设置下拉菜单内部填充，影响选项的显示高度 */
        }
        textarea{
            background-color: transparent; /* 设置背景颜色为透明 */
            border: 1px solid #ccc; /* 添加边框，以便看到输入框的边界 */
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
    <h3 >用户注册</h3>
    <form class="f"  action="${pageContext.request.contextPath}/register.do" method="post">
        <label >用户名：</label> <br>
        <input type="text" name="username" width="300px"><br>
        <label >密码：</label> <br>
        <input type="password" name="password"><br>
        <label >确认密码：</label> <br>
        <input type="password" name="q_password"><br>
        <label >性别:</label>
        <label><input type="radio" name="gender" value="男">男</label>
        <label><input type="radio" name="gender" value="女">女</label><br>
        <label >职业:</label>
        <select name="profession">
            <option value="教师">教师</option><br>
            <option value="学生">学生</option><br>
        </select><br>
        <label >兴趣爱好:</label>
        <label><input type="checkbox" name="favor" value="学习">学习</label>
        <label><input type="checkbox" name="favor" value="读书">读书</label>
        <label><input type="checkbox" name="favor" value="看报">看报</label>
        <label><input type="checkbox" name="favor" value="编程">编程</label>
        <label><input type="checkbox" name="favor" value="算法">算法</label><br>
        <label >个人说明：</label> <br>
        <textarea name="description" cols="70" rows="10"> </textarea><br>
        <input type="submit" value="立即注册">
        <input type="submit" value="已有账号？登录">
    </form>
</div>
</body>
</html>
