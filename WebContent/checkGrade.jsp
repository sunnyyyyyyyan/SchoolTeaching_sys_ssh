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
    <title>查看成绩</title>
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
            <h3 align="center">成绩列表</h3>
            <br>
            <p align="center">
                <font  style="font-size: 12px;" color="red"><s:property value="#request.deleteGradeMess" /></font>
            </p>
            <p align="center">
                <font  style="font-size: 12px;" color="red"><s:property value="#request.changeScoreMess" /></font>
            </p>
            <table class="table table-bordered" style="text-align: center;">
                <tr>
                    <td>学号</td>
                    <td>成绩类型</td>
                    <td>成绩</td>
                    <td>修改成绩</td>
                    <td>操作</td>
                </tr>
                <s:iterator value="#request.checkAllGradeMess">
                    <tr>
                        <td><s:property value="studentId"/> </td>
                        <td><s:property value="gradeType"/></td>
                        <td><s:property value="score"/></td>
                        <td>
                            <form action="changeScoreAction.action" method="post">
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
        <div id='page_next'>
            当前是第<s:property value="#request.checkPage.pageNow" />页，共<s:property value="#request.checkPage.totalPage" />页
            &nbsp;&nbsp;
            <s:if test="#request.checkPage.hasFirst">
                <a href="checkAllGradeAction.action?pageNow=1" target="_parent">首页</a>
            </s:if>
            <s:if test="#request.checkPage.hasPre">
                <a href="checkAllGradeAction.action?pageNow=<s:property value="#request.checkPage.pageNow-1"/> "
                   target="_parent">上一页</a>
            </s:if>
            <s:if test="#request.checkPage.hasNext">
                <a href="checkAllGradeAction.action?pageNow=<s:property value="#request.checkPage.pageNow+1" />"
                   target="_parent">下一页</a>
            </s:if>
            <s:if test="#request.checkPage.hasLast">
                <a href="checkAllGradeAction.action?pageNow=<s:property value="#request.checkPage.totalPage"/>"
                   target="_parent">尾页</a>
            </s:if>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
