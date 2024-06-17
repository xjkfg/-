<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员导航栏</title>
    <style>
        body{
            font-size: 18px;
            font-family: 微软雅黑;
        }
        ul{
            list-style: none;
            font-size: 20px;
        }

        #container {
            display: flex;
            flex-direction: row;
            height: 100vh; /* 占据视口高度 */
            margin: 0;
            padding: 0;
        }

        #nav-box {
            flex: 0 0 200px; /* 固定宽度，例如200px */
            background-color: #f8f9fa; /* 可选：添加背景色以便区分 */
            overflow-y: auto; /* 如果内容过多，允许垂直滚动 */
        }

        #content-box {
            flex: 1; /* 占据剩余空间 */
            padding: 20px; /* 内容区添加内边距 */
        }

        #content-iframe {
            width: 100%;
            height: 100%;
            border: none; /* 移除iframe边框 */
        }
    </style>
</head>
<body>
<div id="container">
<div  id="nav-box">
    <h3>用户管理</h3>
    <ul>
        <li>用户列表</li>
        <li>删除用户</li>
        <li>修改用户</li>
        <li>重置密码</li>
        <li>禁用账号</li>
        <li><a href="javascript:void(0);" onclick="loadContent('usersManger/userList.jsp')">userList</a></li>
        <li><a href="javascript:void(0);" onclick="loadContent('course.jsp')">Course</a></li>
    </ul>
    <h3>新闻管理</h3>
    <ul>
        <li>发布新闻</li>
        <li>修改新闻</li>
        <li>删除新闻</li>
    </ul>
</div>
</div>
<div id="content-box">
    <iframe id="content-iframe" src="about:blank" frameborder="0" scrolling="no" width="100%" height="500px"></iframe>
</div>

<script>
    function loadContent(url) {
        document.getElementById('content-iframe').src = url;
    }
</script>
</body>
</html>
