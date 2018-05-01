<%@ page import="java.util.List" %>
<%@ page import="com.po.ChooseSubject" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
        <div class="startTesting">
                <%
                    String user = (String)ActionContext.getContext().getSession().get("userId");
                    String subjectName = (String)ActionContext.getContext().getSession().get("testSubName");
                %>
            <table class="table table-bordered">
                <tr height="50px">
                    <td>学号：</td>
                    <td><%=user %></td>
                </tr>
                <tr height="50px">
                    <td>考试课程：</td>
                    <td><%=subjectName%></td>
                </tr>
                <tr height="50px">
                    <td>考试时间：</td>
                    <td>30分钟</td>
                </tr>
                <tr height="50px">
                    <td>注意：</td>
                    <td>考试时不得退出</td>
                </tr>
            </table>

           <%-- <form action="checkTestingAction.action" method="post">
                <%
                    for(int i=0;i<testing.size();i++){
                        Test oneQuestion = (Test)testing.get(i);
                %>
                <%=oneQuestion.getQuestionId() %>.【<%=oneQuestion.getQuestionType()%>】
                <%=oneQuestion.getQuestionConcent() %>&nbsp;(<%=oneQuestion.getSetGrade()%>分)</br>
                <%
                    if(oneQuestion.getQuestionType().equals("选择")){
                        List<Test> selecting = (List<Test>)ActionContext.getContext().getSession().get("selecting");
                        for(int j=0;j<selecting.size();j++){
                            Test oneselect = selecting.get(j);
                            if(oneselect.getQuestionId().equals(oneQuestion.getQuestionId())){
                %>
                &nbsp;<input type="radio" name="nowAnswer<%=i %>" value="A">A.&nbsp;<%=oneselect.getSelectA() %></br>
                &nbsp;<input type="radio" name="nowAnswer<%=i %>" value="B">B.&nbsp;<%=oneselect.getSelectB() %></br>
                &nbsp;<input type="radio" name="nowAnswer<%=i %>" value="C">C.&nbsp;<%=oneselect.getSelectC() %></br>
                &nbsp;<input type="radio" name="nowAnswer<%=i %>" value="D">D.&nbsp;<%=oneselect.getSelectD() %></br></br>
                <%
                            }
                        }
                    }
                    if(oneQuestion.getQuestionType().equals("判断")){
                %>
                &nbsp;<input type="radio" name="nowAnswer<%=i %>" value="T">T</br>
                &nbsp;<input type="radio" name="nowAnswer<%=i %>" value="F">F</br></br>
                <%
                        }
                    }
                %>
                <input type="submit" value="提交">
            </form>
            <%
                }
            %>--%>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
