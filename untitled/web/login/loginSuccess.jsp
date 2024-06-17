<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户首页</title>
    <style>
        /* 设置整体容器的样式 */
        #container {
            display: flex;
            flex-direction: column;
            height: 100vh; /* 占据视口高度 */
            margin: 0;
            padding: 0;
        }

        /* 标题区样式 */
        #header {
            /*background-color: #f0f0f0;*/
            padding: 10px;
            text-align: center; /* 如果需要标题居中 */
            border: 1px solid grey; /* 设置边框宽度为1像素，样式为实线，颜色为浅灰色 */
            text-decoration: none; /* 移除链接的下划线 */
        }

        /* 主体区域（包含导航栏和内容区） */
        #main {
            flex: 1; /* 占据剩余空间 */
            display: flex;
            flex-direction: row;
        }

        ul{
            list-style: none;
        }

        a{
            color: black; /* 设置链接颜色为白色 */
            text-decoration: none; /* 移除链接的下划线 */
        }

        /* 导航栏样式 */
        #nav-box {
            flex: 0 0 200px; /* 固定宽度 */
            /*background-color: #f8f9fa;*/
            overflow-y: auto; /* 如果内容过多，允许垂直滚动 */
            border: 1px solid grey; /* 设置边框宽度为1像素，样式为实线，颜色为浅灰色 */
            text-decoration: none; /* 移除链接的下划线 */
        }

        /* 内容区样式 */
        #content-box {
            flex: 1; /* 占据剩余空间 */
            border: 1px solid grey; /* 设置边框宽度为1像素，样式为实线，颜色为浅灰色 */
            text-decoration: none; /* 移除链接的下划线 */

        }

        #content-iframe {
            width: 100%;
            height: 100%;
            border: none;
        }

        body {
            background-image: url("2.png");
            background-repeat: no-repeat; /* 图片不重复 */
            background-size: cover; /* 图片覆盖整个背景 */
        }

    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <h2>新闻发布系统</h2>
        <sapn>
            用户名: ${username}&nbsp;&nbsp;<%--<%= session.getAttribute("username")%>--%>
            <a href="${pageContext.request.contextPath}/Logout.do">退出</a>
        </sapn>
    </div>
    <div id="main">
        <div id="nav-box">
            <nav>
                <h3>新闻浏览</h3>
                <ul>
                    <li><a href="javascript:void(0);" onclick="loadContent('newsManger/newsLan.jsp')">新闻列表</a></li>
                </ul>
            </nav>
        </div>

        <div id="content-box">
            <iframe id="content-iframe" src="about:blank" frameborder="0"></iframe>
        </div>
    </div>
</div>

<script>
    function loadContent(url) {
        document.getElementById('content-iframe').src = url;
    }
</script>
</body>
</html>
