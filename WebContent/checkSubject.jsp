<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29 0029
  Time: 下午 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>课程与选课</title>
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
        <div class="addSubject">
            <h4 align="center" style="padding-top: 50px">查看课程与选课</h4>
            <br>
                    <%
                        String userType = (String)ActionContext.getContext().getSession().get("userType");
                        int i = 1;
                        if (userType.equals("管理员"))
                        {
                    %>
                        <p align="center" >
                            <font  style="font-size: 12px;" color="red"><s:property value="#request.changeUserSubjectMess"/> </font>
                        </p>
                        <p align="center" >
                            <font  style="font-size: 12px;" color="red"><s:property value="subjectNo"/>&nbsp;<s:property value="#request.showAllStudentBySubjectMess"/> </font>
                        </p>
                        <table class="table table-bordered" style="margin:0 auto;text-align: center;">
                            <tr>
                                <td></td>
                                <td>
                                    课程编号
                                </td>
                                <td>
                                    课程名称
                                </td>
                                <td>
                                    授课教师编号
                                </td>
                                <td>
                                    授课教师姓名
                                </td>
                                <td>
                                    更改授课教师(编号)
                                </td>
                                <td>
                                    已选学生
                                </td>
                            </tr>
                            <s:iterator value="#request.checkSubject">
                                <tr>
                                    <td><%=i++%></td>
                                    <td><s:property value="subjectNo"/> </td>
                                    <td><s:property value="subjectName"/></td>
                                    <td><s:property value="userId"/></td>
                                    <td><s:property value="username"/></td>
                                    <td>
                                        <form action="changeUserSubjectAction.action?subjectNo=<s:property value="subjectNo"/> " method="post">
                                            <input type="text" name="changeUserId" required="required">
                                            <button type="submit">更改</button>
                                        </form>
                                    </td>
                                    <td>
                                        <a href="showAllStudentBySubjectAction.action?subjectNo=<s:property value="subjectNo"/>">查看</a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    <%
                        }
                        if (userType.equals("教师"))
                        {
                    %>
                        <p align="center" >
                            <font  style="font-size: 12px;" color="red"><s:property value="subjectNo"/>&nbsp;<s:property value="#request.showAllStudentBySubjectMess"/> </font>
                        </p>
                        <table class="table table-bordered" style="margin:0 auto;text-align: center; width: 600px;">
                            <tr>
                                <td></td>
                                <td>
                                    课程编号
                                </td>
                                <td>
                                    课程名称
                                </td>
                                <td>
                                    授课教师编号
                                </td>
                                <td>
                                    授课教师姓名
                                </td>
                                <td>
                                    已选学生
                                </td>
                            </tr>
                            <s:iterator value="#request.checkSubject">
                                <tr>
                                    <td><%=i++%></td>
                                    <td><s:property value="subjectNo"/> </td>
                                    <td><s:property value="subjectName"/></td>
                                    <td><s:property value="userId"/></td>
                                    <td><s:property value="username"/></td>
                                    <td>
                                        <a href="showAllStudentBySubjectAction.action?subjectNo=<s:property value="subjectNo"/>&&subjectName=<s:property value="subjectName"/>">查看</a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    <%
                        }
                        if (userType.equals("学生"))
                        {
                    %>
                        <p align="center" >
                            <font  style="font-size: 12px;" color="red"><s:property value="#request.chooseSubjectMess"/> </font>
                        </p>
                            <table class="table table-bordered" style="margin:0 auto;text-align: center; width: 600px;">
                                <tr>
                                    <td></td>
                                    <td>
                                        课程编号
                                    </td>
                                    <td>
                                        课程名称
                                    </td>
                                    <td>
                                        授课教师姓名
                                    </td>
                                    <td>选课</td>
                                </tr>
                                <s:iterator value="#request.checkSubject">
                                    <tr>
                                        <td><%=i++%></td>
                                        <td><s:property value="subjectNo"/> </td>
                                        <td><s:property value="subjectName"/></td>
                                        <td><s:property value="username"/></td>
                                        <td>
                                            <a href="chooseSubjectAction.action?subjectNo=<s:property value="subjectNo"/>&&subjectName=<s:property value="subjectName"/> ">
                                                选择
                                            </a>
                                        </td>
                                    </tr>
                                </s:iterator>

                            </table>
                    <%
                        }
                    %>
        </div>
        <br>
        <div id='page_next' style="float: right">
            当前是第<s:property value="#request.checkSubjectPage.pageNow" />页，共<s:property value="#request.checkSubjectPage.totalPage" />页
            &nbsp;&nbsp;
            <s:if test="#request.checkSubjectPage.hasFirst">
                <a href="checkSubjectAction.action?pageNow=1" target="_parent">首页</a>
            </s:if>
            <s:if test="#request.checkSubjectPage.hasPre">
                <a href="checkSubjectAction.action?pageNow=<s:property value="#request.checkSubjectPage.pageNow-1"/> "
                   target="_parent">上一页</a>
            </s:if>
            <s:if test="#request.checkSubjectPage.hasNext">
                <a href="checkSubjectAction.action?pageNow=<s:property value="#request.checkSubjectPage.pageNow+1" />"
                   target="_parent">下一页</a>
            </s:if>
            <s:if test="#request.checkSubjectPage.hasLast">
                <a href="checkSubjectAction.action?pageNow=<s:property value="#request.checkSubjectPage.totalPage"/>"
                   target="_parent">尾页</a>
            </s:if>
        </div>


    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
