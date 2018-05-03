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
    <title>试题列表</title>
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
        <div class="questionList">
            <h4 align="center">试题库</h4>
            <br>
                <table class="table table-bordered" style="margin: 0 auto; text-align: center;">
                    <tr>
                        <td>添加者</td>
                        <td>试题名</td>
                        <td>课程</td>
                        <td>题号</td>
                        <td>题型</td>
                        <td>题目</td>
                        <td>选项A</td>
                        <td>选项B</td>
                        <td>选项C</td>
                        <td>选项D</td>
                        <td>答案</td>
                        <td>分值</td>
                    </tr>
                    <s:iterator value="#request.questionList">
                        <tr>

                            <td><s:property value="userId"/> </td>
                            <td><s:property value="testName"/> </td>
                            <td><s:property value="subName"/></td>
                            <td><s:property value="questionId"/></td>
                            <td><s:property value="questionType"/></td>
                            <td><s:property value="questionContent"/></td>
                            <td><s:property value="selectA"/></td>
                            <td><s:property value="selectB"/></td>
                            <td><s:property value="selectC"/></td>
                            <td><s:property value="selectD"/></td>
                            <td><s:property value="answer"/></td>
                            <td><s:property value="setGrade"/></td>

                        </tr>
                    </s:iterator>
                </table>
        </div>
        <br>
        <br>
        <div id='page_next' style="float: right">
            当前是第<s:property value="#request.questionPage.pageNow" />页，共<s:property value="#request.questionPage.totalPage" />页
            &nbsp;&nbsp;
            <s:if test="#request.questionPage.hasFirst">
                <a href="questionListAction.action?pageNow=1" target="_parent">首页</a>
            </s:if>
            <s:if test="#request.questionPage.hasPre">
                <a href="questionListAction.action?pageNow=<s:property value="#request.questionPage.pageNow-1"/> "
                   target="_parent">上一页</a>
            </s:if>
            <s:if test="#request.questionPage.hasNext">
                <a href="questionListAction.action?pageNow=<s:property value="#request.questionPage.pageNow+1" />"
                   target="_parent">下一页</a>
            </s:if>
            <s:if test="#request.questionPage.hasLast">
                <a href="questionListAction.action?pageNow=<s:property value="#request.questionPage.totalPage"/>"
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
