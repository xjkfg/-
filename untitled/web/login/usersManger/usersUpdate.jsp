<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--数据回显，修改页面--%>
<html>
<head>
    <title>修改页面</title>
    <style>
        div{
            width:800px;
            margin: 100px auto;
        }

    </style>

</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/updateUser.do" method="post" >
        <table>
            <c:forEach items="${userlist}" var="user" varStatus="row" >
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="username" value="${user.username}" /></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password " name="password" value="${user.password}" /></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="text" name="gender" value="${user.gender}"/><br></td>
                </tr>
                <tr>
                    <td>职业</td>
                    <td><input type="text" name="profession" value="${user.profession}"/></td>
                </tr>
                <tr>
                    <td>爱好</td>
                    <td><input type="text" name="favor" value="${user.favor}"/></td>
                </tr>
                <tr>
                    <td>个人简介</td>
                    <td><input type="text" name="description" value="${user.description}"/></td>
                </tr>
                <tr>
                    <td>用户权限</td>
                    <td><input type="text" name="role" value="${user.status}"/></td>
                </tr>
                <tr>
                    <td>用户状态</td>
                    <td><input type="text" name="status" value="${user.role}"/></td>
                </tr>
                <tr>
                    <td>
                        <form action="${pageContext.request.contextPath}/updateUser.do" method="get">
                            <input type="submit" value="修改">
                            <input type="hidden" name="userChange" value="${user.username}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
    </form>
</div>

</body>
</html>
