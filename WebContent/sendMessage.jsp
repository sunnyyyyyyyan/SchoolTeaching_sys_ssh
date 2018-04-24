<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sendMessage</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp" />
    </div>

    <div id="left_column">
        <jsp:include page="left_column.jsp" />
    </div>

    <div id="center_column">
        <div class="sendMessage">
            <h4 align="center">发布通知</h4>
            <br>
            <form action="#">
                <table class="table table-bordered">
                    <tr>
                        <td>发布者：</td>
                        <td>
                            <input type="text" name="author">
                        </td>
                    </tr>
                    <tr>
                        <td>发布时间：</td>
                        <td>
                            <input type="date" name="sendDate">
                            <font size="2" color="red">若手动输入，格式为：yyyy-mm-dd，例如2018-04-04</font>
                        </td>
                    </tr>
                    <tr>
                        <td>标题：</td>
                        <td>
                            <input type="text" name="title">
                            <font size="2" color="red">最多可输入100字</font>
                        </td>
                    </tr>
                    <tr>
                        <td>操作：&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>
                            <input type="submit" value="保存并发布">
                            <font size="2" color="red">在下方输入通知内容点击发布</font>
                        </td>
                    </tr>
                </table>
                <textarea name="content" id="editor"  Style="height:40%;width:99.9%" placeholder="请输入通知内容！"></textarea>
            </form>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
