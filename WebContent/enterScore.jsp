<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>enterScore</title>
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
        <div class="enterScore">
            <h2 align="center">录入成绩</h2>
            <br>
            <form action="#">
                <table class="table table-bordered" style="margin:0 auto;text-align: center; width: 400px;">
                    <tr>
                        <td>
                            学号：
                            <input type="text">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            成绩类型：
                            <select name="scoreType" id="scoreType">
                                <option value="大作业">大作业</option>
                                <option value="报告">报告</option>
                                <option value="课堂互动">课堂互动</option>
                                <option value="期中考试">期中考试</option>
                                <option value="期末考试">期末考试</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            分数：
                            <input type="text">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button>录入</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
