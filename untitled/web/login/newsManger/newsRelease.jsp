<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新闻</title>
    <script type="text/javascript">
        window.onload = function() {
            var addNewsStatus = '<%= request.getAttribute("addNewsSuccess") %>';
            if (addNewsStatus === 'addNewsSuccess') {
                alert("发布成功");
            }
        };
    </script>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/AddNews.do" enctype="multipart/form-data" method="post">
        <lable>标题：</lable>
        <input type="text" name="title"> <br>
        <lable>作者：</lable>
        <input type="text" name="author"> <br>
        <lable>状态：</lable>
        <select name="state">
            <option value="在架">在架</option>
            <option value="下架">下架</option>
        </select><br>
        <lable>新闻类别：</lable>
        <label><input type="checkbox" name="category" value="时政">时政</label>
        <label><input type="checkbox" name="category" value="娱乐">娱乐</label>
        <label><input type="checkbox" name="category" value="学习">学习</label><br>
        <lable>封面：</lable>
        <input type="file" name="coverUrl" value="请选择封面"> <br>
        <label>文本：</label>
        <textarea name="content" id="content" cols="30" rows="10"></textarea><br>
        <input type="submit" value="发布文章">
    </form>
</div>
</body>
</html>
