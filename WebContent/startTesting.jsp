<%@ page import="java.util.List" %>
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
    <script type="text/javascript">
        var maxtime = 30 * 60; //一个小时，按秒计算，自己调整!
        function CountDown() {
            if (maxtime >= 0) {
                minutes = Math.floor(maxtime / 60);
                seconds = Math.floor(maxtime % 60);
                msg = "距离考试结束还有" + minutes + "分" + seconds + "秒";
                document.all["timer"].innerHTML = msg;
                if (maxtime == 5 * 60)alert("还剩5分钟");
                --maxtime;
            } else{
                clearInterval(timer);
                alert("时间到，结束!");
            }
        }
        timer = setInterval("CountDown()", 1000);
    </script>
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
                    <%=subjectName %> 暂无考试试题！
                </p>
        <%
            }
            else {

        %>
            <div class="startTesting_left">
                <table class="table table-bordered">
                    <tr>
                        <td colspan="2" id="timer" style="color:red"></td>
                    </tr>
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
                        <td colspan="2"><font color="red"> 注意：考试时不得退出</font></td>
                    </tr>
                </table>
            </div>
            <div class="startTesting_right">
                <form action="checkTestingAction.action" method="post">
                        <table class="table table-bordered" >
                            <%
                                for (int i = 0; i < list.size(); i++)
                                {
                                    Test test = list.get(i);
                            %>
                            <tr>
                                <td>
                                    <%=test.getQuestionId()%>.【<%=test.getQuestionType()%>】(<%=test.getSetGrade()%>)&nbsp;
                                    <%=test.getQuestionContent()%>
                                    <br><br>
                                    <%
                                        if (test.getQuestionType().equals("选择"))
                                        {
                                    %>
                                            <input type="radio" name="nowAnswer<%=i %>" value="A">A: <%=test.getSelectA()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" name="nowAnswer<%=i %>" value="B">B: <%=test.getSelectB()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" name="nowAnswer<%=i %>" value="C">C: <%=test.getSelectC()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" name="nowAnswer<%=i %>" value="D">D: <%=test.getSelectD()%>
                                    <%
                                        }
                                        if (test.getQuestionType().equals("判断"))
                                        {
                                    %>
                                            <input type="radio" name="nowAnswer<%=i %>" value="T">T&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" name="nowAnswer<%=i %>" value="F">F
                                    <%
                                        }
                                    %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            <tr>
                                <td align="center">
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
