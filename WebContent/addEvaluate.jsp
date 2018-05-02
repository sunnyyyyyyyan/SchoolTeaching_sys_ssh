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
    <title>添加学评</title>
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
        <div class="addEvaluate">
            <h3 align="center">添加学评</h3>
            <br>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.addEvaluateMess"/> </font>
            </p>
            <form action="addEvaluateAction.action" method="post">
                <table class="table table-bordered" style="width: 500px;margin: 0 auto;">
                    <tr>
                        <td>
                            <font color="red">*</font>课程编号
                        </td>
                        <td>
                            <input type="text" name="subjectNo">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <font color="red">*</font>学评题号：
                        </td>
                        <td>
                            <input type="text" name="evaluateQuestionId">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <font color="red">*</font>学评题目
                        </td>
                        <td>
                            <input type="text" name="evaluateContent">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            满意度选项
                        </td>
                        <td>
                            <input type="checkbox" name="selectA" value="非常满意">&nbsp;非常满意&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="selectB" value="较满意">&nbsp;较满意&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="selectC" value="满意">&nbsp;满意&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="selectD" value="不满意">&nbsp;不满意
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="reset">重置</button>
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
