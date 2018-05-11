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
    <title>查看成绩</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/main.css">
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
        <div class="checkScore">
            <h4 align="center" style="padding-top: 50px">成绩列表</h4>
            <br>


                <%
                    String userType = (String)ActionContext.getContext().getSession().get("userType");
                    if (userType.equals("管理员"))
                    {
                %>
            <div class="content">
                <p align="center">
                    <input name="key" type="text" id="key" style="width: 180px" onkeydown="onSearchGrade(this)" placeholder="可输入成绩类型进行筛选" />
                </p>
                <p align="center">
                    <font  style="font-size: 12px;" color="red"><s:property value="#request.deleteGradeMess" /></font>
                </p>
                <p align="center">
                    <font  style="font-size: 12px;" color="red"><s:property value="#request.changeScoreMess" /></font>
                </p>
                <table id="store" class="table table-bordered" style="text-align: center;margin:0 auto;width: 600px">
                    <tr>
                        <td>学号</td>
                        <td>考试类型</td>
                        <td>成绩</td>
                        <td>修改成绩</td>
                        <td>操作</td>
                    </tr>
                    <s:iterator value="#request.checkAllGradeMess">
                    <tr>
                        <td><s:property value="studentId"/> </td>
                        <td><s:property value="gradeType"/></td>
                        <td><s:property value="score"/></td>
                        <td>
                            <form action="changeScoreAction.action?studentId=<s:property value="studentId"/>" method="post">
                                <input type="text" name="changeScore"  required="required">
                                <button type="submit">修改</button>
                            </form>

                        </td>
                        <td>
                            <a href="deleteScoreAction.action?studentId=<s:property value="studentId"/> ">删除</a>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
            <br>
            <div id='page_next'>
                当前是第<s:property value="#request.checkPage.pageNow" />页，共<s:property value="#request.checkPage.totalPage" />页
                &nbsp;&nbsp;
                <s:if test="#request.checkPage.hasFirst">
                    <a href="checkAllGradeAction.action?pageNow=1" target="_parent">首页</a>
                </s:if>
                <s:if test="#request.checkPage.hasPre">
                    <a href="checkAllGradeAction.action?pageNow=<s:property value="#request.checkPage.pageNow-1"/> "
                       target="_parent">上一页</a>
                </s:if>
                <s:if test="#request.checkPage.hasNext">
                    <a href="checkAllGradeAction.action?pageNow=<s:property value="#request.checkPage.pageNow+1" />"
                       target="_parent">下一页</a>
                </s:if>
                <s:if test="#request.checkPage.hasLast">
                    <a href="checkAllGradeAction.action?pageNow=<s:property value="#request.checkPage.totalPage"/>"
                       target="_parent">尾页</a>
                </s:if>
            </div>

                <%
                    }
                    if (userType.equals("教师"))
                    {
                %>
            <p align="center">
                <font  style="font-size: 12px;" color="red"><s:property value="#request.deleteGradeMess" /></font>
            </p>
            <p align="center">
                <font  style="font-size: 12px;" color="red"><s:property value="#request.changeScoreMess" /></font>
            </p>
            <p align="center" >
                <font  style="font-size: 12px;" color="red"><s:property value="#request.getAllGradeByTeacherIdMess"/> </font>
            </p>
            <table class="table table-bordered" style="text-align: center;margin:0 auto;width: 600px">
                        <tr>
                            <td>学号</td>
                            <td>课程名称</td>
                            <td>考试类型</td>
                            <td>成绩</td>
                            <td>修改成绩</td>
                            <td>操作</td>
                        </tr>
                        <s:iterator value="#request.getAllGradeByTeacherId">
                            <tr>
                                <td><s:property value="studentId"/> </td>
                                <td><s:property value="subjectName"/> </td>
                                <td><s:property value="gradeType"/></td>
                                <td><s:property value="score"/></td>
                                <td>
                                    <form action="changeScoreAction.action?studentId=<s:property value="studentId"/>" method="post">
                                        <input type="text" name="changeScore" required="required">
                                        <button type="submit">修改</button>
                                    </form>

                                </td>
                                <td>
                                    <a href="deleteScoreAction.action?studentId=<s:property value="studentId"/> ">删除</a>
                                </td>
                            </tr>
                        </s:iterator>
            </table>
                <%
                    }
                    if (userType.equals("学生"))
                    {
                %>
                        <%--<p align="center" >
                            <font  style="font-size: 12px;" color="red"><s:property value="#request.checkAllGradeByStudentIdMess"/> </font>
                        </p>--%>
            <table class="table table-bordered" style="text-align: center;margin:0 auto;width: 600px">
                        <tr>
                            <td>学号</td>
                            <td>考试类型</td>
                            <td>成绩</td>
                        </tr>
                        <s:iterator value="#request.checkAllGradeByStudentIdMess">
                            <tr>
                                <td><s:property value="userId"/> </td>
                                <td><s:property value="gradeType"/></td>
                                <td><s:property value="score"/></td>
                            </tr>
                        </s:iterator>
            </table>
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
