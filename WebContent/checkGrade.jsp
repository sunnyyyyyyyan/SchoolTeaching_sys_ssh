<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
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
            <p align="center">
                <font  style="font-size: 12px;" color="red"><s:property value="#request.deleteGradeMess" /></font>
            </p>
            <table class="table table-bordered" style="text-align: center">
                <tr>
                    <td>学号</td>
                    <td>成绩类型</td>
                    <td>分数</td>
                    <td>修改分数</td>
                    <td>操作</td>
                </tr>
                <s:iterator value="#request.checkGradeMess">
                    <tr>
                        <td><s:property value="studentId"/> </td>
                        <td><s:property value="gradeType"/></td>
                        <td><s:property value="score"/></td>
                        <td>
                            <form action="#">
                                <input type="text" name="changeScore">
                                <button type="submit">修改</button>
                            </form>

                        </td>
                        <td>
                            <a href="deleteScoreAction.action?studentId=<s:property value="studentId"/> ">删除</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
