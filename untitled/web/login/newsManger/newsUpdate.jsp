<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 千伶
  Date: 2024/6/4
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改新闻</title>
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
    <form action="${pageContext.request.contextPath}/queryNewsList.do" method="post">
        <input type="text" name="queryNews">
        <input type="submit" value="搜索">
        <input type="hidden" name="newsChange" value="2">
    </form>

    <table >
        <tr>
            <td>标题</td>
            <td>作者</td>
            <td>状态</td>
            <td>新闻类别</td>
            <td>新闻封面新闻</td>
            <td>新闻正文</td>
            <td>点击次数</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${newsList}" var="news" varStatus="row" >

            <tr>
                <td>${news.title}</td>

                <td>${news.author}</td>

                <td>${news.state}</td>

                <td>${news.category}</td>

                <td><img src="img/${news.coverUrl}" width="80" height="60"></td>

                <td>${news.content}</td>

                <td>${news.viewCount}</td>

                <td>
                    <form action="${pageContext.request.contextPath}/updateNews.do" method="get">
                        <input type="submit" value="修改">
                        <input type="hidden" name="newsManger" value="${news.author}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
