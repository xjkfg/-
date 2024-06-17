<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 千伶
  Date: 2024/6/5
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览新闻页面</title>
    <style>
        div{
            width: 800px;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<div>
    <%--浏览完页面需要一个返回按钮--%>
    <form action="${pageContext.request.contextPath}/searchNews.do" method="post">
        <input type="submit" value="返回">
        <c:forEach items="${news}" var="news" varStatus="row" >
            <h3>${news.title}</h3>
            <h4>${news.author}</h4>
            <p>${news.content}</p>
        </c:forEach>
    </form>
</div>
</body>
</html>
