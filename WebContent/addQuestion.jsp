<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
    <title>添加试题</title>
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
            <h4 align="center" style="padding-top: 50px">增加试题</h4>
            <br>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.addQuestionMess"/> </font>
            </p>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.getSubjectNameByTeacherIdMess"/> </font>
            </p>
            <form action="addQuestionAction.action" method="post">
                <table class="table table-bordered" style="margin: 0 auto; text-align: center;width: 500px">
                    <tr>
                        <td>考试类型：</td>
                        <td>
                            <select name="testName" id="testName" style="height: 30px">
                                <s:iterator value="#request.getSubjectNameByTeacherId_1">
                                    <option name="testName" value="<s:property value="gradeTypeName"/>"><s:property value="gradeTypeName"/></option>
                                </s:iterator>
                            </select>
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
                        <td>题号：</td>
                        <td><input type="text" name="questionId" required="required"></td>
                    </tr>
                    <tr>
                        <td>题型：</td>
                        <td>
                            <input type="radio" name="questionType" value="选择" onclick="clickType('select')">选择
                            <input type="radio" name="questionType" value="判断" onclick="clickType('judge')">判断
                        </td>
                    </tr>
                    <tr>
                        <td>题目：</td>
                        <td>
                            <input type="text" name="questionContent" required="required">
                        </td>
                    </tr>
                </table>
                <br>
                <table class="table table-bordered" id="selection"  style="margin: 0 auto; text-align: center;width: 300px">
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
                        <td colspan="2"><font color="red">选择题型答案填A/B/C/D，判断题型答案填T/F</font></td>
                    </tr>
                    <tr>
                        <td>分值：</td>
                        <td><input type="text" name="setGrade"></td>
                    </tr>
                    <tr>
                        <td colspan="2" >
                            <button type="submit">增加</button> &nbsp;&nbsp;
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
