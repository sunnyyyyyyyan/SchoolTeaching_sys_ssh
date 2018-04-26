<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkScore</title>
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
        <div class="checkScore">
            <h2 align="center">成绩列表</h2>
            <br>
            <table class="table table-bordered" style="text-align: center">
                <tr>
                    <td>学号</td>
                    <td>成绩类型</td>
                    <td>分数</td>
                    <td>修改分数</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td>sunny000011110001</td>
                    <td>大作业</td>
                    <td>20</td>
                    <td>
                        <input type="text">修改
                    </td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>sunny000011110001</td>
                    <td>报告</td>
                    <td>9</td>
                    <td>
                        <input type="text">修改
                    </td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>sunny000011110001</td>
                    <td>期中考试</td>
                    <td>19</td>
                    <td>
                        <input type="text">修改
                    </td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>sunny000011110001</td>
                    <td>期末考试</td>
                    <td>45</td>
                    <td>
                        <input type="text">修改
                    </td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>sunny000011110001</td>
                    <td>课堂互动</td>
                    <td>5</td>
                    <td>
                        <input type="text">修改
                    </td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
