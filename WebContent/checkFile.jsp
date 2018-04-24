<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkFile</title>
    <link rel="stylesheet" href="css/global.css">
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
        <div class="checkFile">
            <h2 align="center">所有文件列表</h2>
            <br>
            <table class="table table-bordered" style="text-align: center">
                <thead>
                    <tr>
                        <td>文件名</td>
                        <td>上传日期</td>
                        <td>上传者</td>
                        <td>文件描述</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>软件工程.txt</td>
                        <td>2018-04-04</td>
                        <td>sunny</td>
                        <td>课件</td>
                        <td>
                            <a href="#">删除</a>
                            <a href="#">下载</a>
                        </td>
                    </tr>
                    <tr>
                        <td>需求分析.pdf</td>
                        <td>2018-04-04</td>
                        <td>sunny</td>
                        <td>课件</td>
                        <td>
                            <a href="#">删除</a>
                            <a href="#">下载</a>
                        </td>
                    </tr>
                    <tr>
                        <td>面向对象.pdf</td>
                        <td>2018-04-04</td>
                        <td>sunny</td>
                        <td>课件</td>
                        <td>
                            <a href="#">删除</a>
                            <a href="#">下载</a>
                        </td>
                    </tr>
                </tbody>

            </table>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
