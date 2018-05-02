<%@ page import="java.util.List" %>
<%@ page import="com.po.Evaluate" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
        <div class="doEvaluate">
            <h3 align="center">教学评价</h3>
            <br>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="subjectNo"/><s:property value="#request.getMessInChooseMess"/> </font>
            </p>
            <%
                List<Evaluate> list = (List<Evaluate>)ActionContext.getContext().get("getEvaluateTest");
                if (list==null)
                {
            %>
            <p align="center" style="color: red;">
                暂无评教题目！
            </p>
            <%
                }
                else
                {
            %>
            <form action="doEvaluateAction.action" method="post">
                <table class="table table-bordered" style="width: 500px;margin: 0 auto;">
            <%
                    for (int i = 0; i < list.size(); i++)
                    {
                        Evaluate evaluate = list.get(i);
            %>
                        <tr>
                            <td>
                                <%=evaluate.getEvaluateQuestionId() %>. <%=evaluate.getEvaluateContent()%>
                                <br>
                                <br>
                                <input type="radio" name="nowAnswer<%=i %>" value="<%=evaluate.getSelectA()%>"> <%=evaluate.getSelectA()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="nowAnswer<%=i %>" value="<%=evaluate.getSelectB()%>"> <%=evaluate.getSelectB()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="nowAnswer<%=i %>" value="<%=evaluate.getSelectC()%>"> <%=evaluate.getSelectC()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="nowAnswer<%=i %>" value="<%=evaluate.getSelectD()%>"> <%=evaluate.getSelectD()%>
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
