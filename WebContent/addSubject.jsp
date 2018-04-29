<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29 0029
  Time: 下午 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>添加课程</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/global.css">
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
        <div class="addSubject">
            <h3 align="center">添加课程</h3>
            <br>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.addSubjectMess"/> </font>
            </p>
            <br>
            <form action="addSubjectAction.action" method="post">
                <table class="table table-bordered" style="margin:0 auto;text-align: center; width: 400px;">
                    <tr>
                        <td>
                            课程编号：
                        </td>
                        <td>
                            <input type="text" name="subjectNo">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            课程名称：
                        </td>
                        <td>
                            <input type="text" name="subjectName">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">提交</button>
                            <button type="reset" t>重置</button>
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
