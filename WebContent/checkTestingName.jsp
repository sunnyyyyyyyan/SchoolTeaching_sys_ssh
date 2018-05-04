<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.po.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="com.po.ChooseSubject" %><%--
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
    <title>考试</title>
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
        <div class="checkTeachingName_top">
                <button type="button" class="btn btn-default" name="Submit" style="float: right;width:50px;" onclick="javascript:history.back(-1);" value="返回" >返回</button>
            <br>
            <h4 align="center">考试类型</h4>
            <br>
            <%
                String subjectName = (String)ActionContext.getContext().getSession().get("subjectName");
                List<ChooseSubject> list1 = (List<ChooseSubject>)ActionContext.getContext().get("showSubjectByUserIdTestName");
                if (list1==null)
                {
            %>
                    <p align="center" >
                        <font  style="font-size: 12px;" color="red"><s:property value="subjectNo"/>暂无考试类型！</font>
                    </p>
            <%
                }
                else
                {
            %>
            <form action="getTestingListAction.action?subjectNo=<s:property value="subjectNo"/>" method="post">
                <table class="table table-bordered" style="width: 400px;margin: 0 auto;">
                    <tr>
                        <td>课程编号</td>
                        <td>课程名称</td>
                        <td>考试类型</td>
                        <td>考试</td>
                    </tr>
                    <tr>

                        <td><s:property value="subjectNo"/></td>
                        <td><%=subjectName%></td>
                        <td>
                            <select name="testName" id="testName">
                                <s:iterator value="#request.showSubjectByUserIdTestName">
                                    <option name="testName" value="<s:property value="username"/>"><s:property value="username"/></option>
                                </s:iterator>
                            </select>
                        </td>
                        <td>
                            <button>开始考试</button>
                        </td>
                    </tr>
            </table>
            </form>
            <%
                }
            %>
        </div>
        <hr>
        <div class="checkTeachingName_content">
                <%
                    String user = (String)ActionContext.getContext().getSession().get("userId");
                    List<Test> list = (List<Test>)ActionContext.getContext().get("getTestingList");
                    if (list==null){
                %>
                <p align="center" style="color: red;">
                    <font  style="font-size: 12px;" color="red"><s:property value="#request.getTestingListMess"/> </font>
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
                            <td>课程编号：</td>
                            <td><s:property value="subjectNo"/></td>
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

    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
