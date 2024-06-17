<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改新闻</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/updateNews.do" method="post" >
        <table>
            <c:forEach items="${news}" var="news" varStatus="row" >
            <tr>
                <td>标题</td>
                <td><input type="text" name="title" value="${news.title}" /></td>
            </tr>
            <tr>
                <td>作者</td>
                <td><input type="text " name="author" value="${news.author}" /></td>
            </tr>
            <tr>
                <td>状态</td>
                <td><input type="text" name="state" value="${news.state}"/><br></td>
            </tr>
            <tr>
                <td>新闻类别</td>
                <td><input type="text" name="category" value="${news.category}"/></td>
            </tr>

            <tr>
                <td>新闻封面图片</td>
                <td><input type="text" name="coverUrl" value="${news.coverUrl}"/></td>
            </tr>
            <tr>
                <td>新闻正文</td>
                <td><input type="text" name="content" value="${user.content}"/></td>
            </tr>
            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/updateUser.do" method="post">
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
