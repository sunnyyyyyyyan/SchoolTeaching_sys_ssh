<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29 0029
  Time: 下午 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>添加题目</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="js/left_column_tab.js" type="text/javascript"></script>
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
        <div class="addQuestion">
            <h3 align="center">添加题目</h3>
            <br>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.addQuestionMess"/> </font>
            </p>
            <form action="addQuestionAction.action" method="post">
                <table class="table table-bordered" style="margin: 0 auto; text-align: center;width: 500px">
                    <tr>
                        <td>试题名：</td>
                        <td><input type="text" name="testName"></td>
                    </tr>
                    <tr>
                        <td>科目：</td>
                        <td><input type="radio" name="subName" value="软件工程">软件工程
                            <input type="radio" name="subName" value="Web">Web
                            <input type="radio" name="subName" value="java">java
                        </td>
                    </tr>
                    <tr>
                        <td>题号：</td>
                        <td><input type="text" name="questionId"></td>
                    </tr>
                    <tr>
                        <td>题型：</td>
                        <td>
                            <input type="radio" name="type" value="选择" onclick="clickType('select')">选择
                            <input type="radio" name="type" value="判断" onclick="clickType('judge')">判断
                        </td>
                    </tr>
                    <tr>
                        <td>题目：</td>
                        <td>
                            <input type="text" name="concent">
                        </td>
                    </tr>
                </table>
                <br>
                <table class="table table-bordered" id="selection"  style="margin: 0 auto; text-align: center;width: 500px">
                    <tr>
                        <td>选项A：</td>
                        <td><input type="text" name="selectA"></td>
                    </tr>
                    <tr>
                        <td>选项B：</td>
                        <td><input type="text" name="selectB"></td>
                    </tr>
                    <tr>
                        <td>选项C：</td>
                        <td><input type="text" name="selectC"></td>
                    </tr>
                    <tr>
                        <td>选项D：</td>
                        <td><input type="text" name="selectD"></td>
                    </tr>
                </table>
                <br>
                <table class="table table-bordered" style="margin: 0 auto; text-align: center;width: 500px">
                    <tr>
                        <td>答案：</td>
                        <td><input type="text" name="answer"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>答案填A/B/C/D/T/F</td>
                    </tr>
                    <tr>
                        <td>分值：</td>
                        <td><input type="text" name="setGrade"></td>
                    </tr>
                    <tr>
                        <td colspan="2" >
                            <input type="submit" value="增加">&nbsp;
                            <input type="reset" value="重置">
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
