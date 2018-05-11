<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>录入成绩</title>
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
            <h3 align="center" style="padding-top: 120px">录入成绩</h3>
            <br>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.addGradeMess"/> </font>
            </p>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.getSubjectNameByTeacherIdMess"/> </font>
            </p>
            <form action="addGradeAction.action" method="post" >
                <table class="table table-bordered" style="margin:0 auto;width: 400px;">
                    <tr>
                        <td>
                            学号：
                        </td>
                        <td>
                            <input type="text" name="studentId" required="required">
                        </td>
                    </tr>
                    <tr>
                        <td>课程编号与名称：</td>
                        <td>
                            <select name="subjectNo" id="subjectNo" style="height: 30px">
                                <s:iterator value="#request.getSubjectNameByTeacherId">
                                <option name="subjectNo" value="<s:property value="subjectNo"/>"><s:property value="subjectNo"/>：<s:property value="subjectName"/> </option>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            考试类型：
                        </td>
                        <td>
                            <select name="gradeType" id="gradeType" style="height: 30px">
                                <s:iterator value="#request.getSubjectNameByTeacherId_1">
                                    <option name="gradeType" value="<s:property value="gradeTypeName"/>"><s:property value="gradeTypeName"/></option>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            成绩：
                        </td>
                        <td>
                            <input type="text" name="score"  required="required">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit">录入</button>
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
