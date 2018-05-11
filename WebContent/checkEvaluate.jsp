<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>uploadFile</title>
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
        <div class="uploadFile">
            <h4 align="center" style="padding-top: 50px">学评题目列表</h4>
            <br>
                <table class="table table-bordered" >
                    <tr>
                        <td>课程编号</td>
                        <td>题号</td>
                        <td>题目</td>
                        <td>A</td>
                        <td>B</td>
                        <td>C</td>
                        <td>D</td>
                    </tr>
                    <s:iterator value="#request.checkEvaluate">
                        <tr>
                            <td><s:property value="subjectNo"/></td>
                            <td><s:property value="evaluateQuestionId"/></td>
                            <td><s:property value="evaluateContent"/></td>
                            <td><s:property value="selectA"/></td>
                            <td><s:property value="selectB"/></td>
                            <td><s:property value="selectC"/></td>
                            <td><s:property value="selectD"/></td>
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
