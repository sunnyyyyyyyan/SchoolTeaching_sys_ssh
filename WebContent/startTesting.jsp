<%@ page import="java.util.List" %>
<%@ page import="com.po.ChooseSubject" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.po.Test" %><%--
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
    <title>开始考试</title>
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
        <%
            String user = (String)ActionContext.getContext().getSession().get("userId");
            String subjectName = (String)ActionContext.getContext().getSession().get("subjectName");
            List<Test> list = (List<Test>)ActionContext.getContext().get("startTesting");
            if (list==null){
        %>
                <p align="center" style="color: red;">
                    <%=subjectName %> 暂无考试试题
                </p>
        <%
            }
            else {
        %>
            <div class="startTesting_left">
                <table class="table table-bordered">
                    <tr>
                        <td>学号：</td>
                        <td><%=user %></td>
                    </tr>
                    <tr>
                        <td>考试课程：</td>
                        <td><%=subjectName %></td>
                    </tr>
                    <tr>
                        <td>考试时间：</td>
                        <td>30分钟</td>
                    </tr>
                    <tr>
                        <td><font color="red"> 注意：</font></td>
                        <td><font color="red"> 考试时不得退出</font></td>
                    </tr>
                </table>
            </div>
            <div class="startTesting_right">
                <form action="checkTestingAction.action" method="post">
                    <table class="table table-bordered" >
                        <%
                            for (int i = 0; i < list.size(); i++) {
                                Test test = list.get(i);
                                if (test.getQuestionType().equals("选择")){
                        %>
                                    <s:iterator value="#request.startTesting">
                                        <tr>
                                            <td>
                                                <s:property value="questionId"/>. <s:property value="questionType"/>(<s:property value="setGrade"/>分)&nbsp;&nbsp;
                                                <s:property value="questionContent"/> <br><br>
                                                <input type="radio" name="nowAnswer<%=i %>" value="A">A: <s:property value="selectA"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="radio" name="nowAnswer<%=i %>" value="B">B: <s:property value="selectB"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="radio" name="nowAnswer<%=i %>" value="C">C: <s:property value="selectC"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="radio" name="nowAnswer<%=i %>" value="D">D: <s:property value="selectD"/>
                                            </td>
                                        </tr>
                                    </s:iterator>
                        <%
                                }
                                if (test.getQuestionType().equals("判断")) {
                        %>
                                    <s:iterator value="#request.startTesting">
                                        <tr>
                                            <td>
                                                <s:property value="questionId"/>. <s:property value="questionType"/>(<s:property value="setGrade"/>分)&nbsp;&nbsp;
                                                <s:property value="questionContent"/> <br><br>
                                                <input type="radio" name="nowAnswer<%=i %>" value="T">T&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="radio" name="nowAnswer<%=i %>" value="F">F
                                            </td>
                                        </tr>
                                    </s:iterator>
                        <%
                                }
                            }
                        %>
                        <tr>
                            <td>
                                <button type="submit">提交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        <%
            }
        %>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
