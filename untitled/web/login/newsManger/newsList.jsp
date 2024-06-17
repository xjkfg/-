<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻列表</title>
    <style>
        div{
            width: 800px;
            margin: 100px auto;
        }
    </style>

    <script>

    </script>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/queryNewsList.do" method="post">
        <input type="text" name="queryNews">
        <input type="submit" value="搜索">
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
            <td>删除</td>
            <td>修改</td>
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
                    <form action="${pageContext.request.contextPath}/deleteNews.do" method="post">
                        <input type="submit" value="删除">
                        <input type="hidden" name="newsManger" value="${news.author}">
                    </form>
                </td>
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
