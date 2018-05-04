<%@ page import="java.util.List" %>
<%@ page import="com.po.ChooseSubject" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
    <title>已选课程</title>
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
        <div class="testOnline">
            <h4 align="center">已选课程</h4>
            <br>

            <br>
                <table class="table table-bordered" style="margin: 0 auto;text-align: center;width: 350px">
                    <tr>
                        <td>课程编号</td>
                        <td>课程名称</td>
                        <td>考试类型</td>
                    </tr>
                    <s:iterator value="#request.getSubjectByUserId">
                    <tr>
                        <td><s:property value="subjectNo"/> </td>
                        <td><s:property value="subjectName"/> </td>
                        <td>
                            <a href="getTestingNameAction.action?subjectNo=<s:property value="subjectNo"/>">查看</a>
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
