<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除用户</title>
    <style>
        div{
            width:800px;
            margin: 100px auto;
        }

    </style>
    <script type="text/javascript">
        window.onload = function() {
            var deletionStatus = '<%= request.getAttribute("deleteSuccess") %>';

            if (deletionStatus === 'deleteSuccess') {
                alert("删除成功");
            }
        };
    </script>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/queryList.do" method="post" >
        <input type="text" name="queryUsername" placeholder="输入查询用户名">
        <input type="submit" value="查询">
        <input type="hidden" name="userManger" value="2">
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
                    <form action="${pageContext.request.contextPath}/deleteUser.do" method="post">
                        <input type="submit" value="删除" onclick="on()">
                        <input type="hidden" name="userChange" value="${user.username}">
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>

    <script>
        function on(){
            alert("确认删除");
        }
    </script>
</body>
</html>
