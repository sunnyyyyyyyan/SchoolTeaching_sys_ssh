<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>教学评价</title>
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
        <div class="getMessInChoose">
            <h4 align="center">教学评价</h4>
            <br>

            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.getEvaluateTestMess"/> </font>
            </p>
                <table class="table table-bordered" style="width: 500px;margin: 0 auto;text-align: center">
                    <tr>
                        <td>课程编号</td>
                        <td>课程名称</td>
                        <td>授课教师姓名</td>
                        <td>操作</td>
                    </tr>
                    <s:iterator value="#request.getMessInChoose">
                    <tr>
                        <td><s:property value="subjectNo"/> </td>
                        <td><s:property value="subjectName"/></td>
                        <td><s:property value="username"/></td>
                        <td>
                            <a href="getEvaluateTestAction.action?subjectNo=<s:property value="subjectNo"/>">评教</a>
                        </td>
                    </tr>
                    </s:iterator>
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
