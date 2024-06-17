<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
    <style>
        div{
            width:800px;
            margin: 100px auto;
        }
    </style>
    <script type="text/javascript">
        window.onload = function() {
            var updateSuccess = '<%= request.getAttribute("updateSuccess") %>';

            if (updateSuccess == 'updateSuccess') {
                alert("修改成功");
            }
        };
    </script>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/queryList.do" method="post" >
        <input type="text" name="queryUsername" placeholder="输入查询用户名">
        <input type="submit" value="查询">
        <input type="hidden" name="userManger" value="3">
    </form>

    <table >
        <tr>
            <td>姓名</td>
            <td>密码</td>
            <td>性别</td>
            <td>职业</td>
            <td>爱好</td>
            <td>个人简介</td>
            <td>用户权限</td>
            <td>用户状态</td>
            <td>删除</td>
        </tr>

        <c:forEach items="${userlist}" var="user" varStatus="row" >

            <tr>
                <td>${user.username}</td>

                <td>${user.password}</td>

                <td>${user.gender}</td>

                <td>${user.profession}</td>

                <td>${user.favor}</td>

                <td>${user.description}</td>

                <td>${user.status}</td>

                <td>${user.role}</td>

                <td>
                    <form action="${pageContext.request.contextPath}/updateUser.do" method="get">
                        <input type="submit" value="修改">
                        <input type="hidden" name="userChange" value="${user.username}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
