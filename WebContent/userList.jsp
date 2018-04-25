<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户列表</title>
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
        <div class="userList">
            <h2 align="center">所有用户列表</h2>
            <br>
            <form action="#">
                <table class="table table-bordered" style="text-align: center">
                    <thead>
                        <tr >
                            <td>用户编号</td>
                            <td>姓名</td>
                            <td>用户类型</td>
                            <td>密码</td>
                            <td>电话号码</td>
                            <td>邮箱</td>
                            <td>操作</td>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="#request.allUser">
                            <tr>
                                <td><s:property value="userId"/> </td>
                                <td><s:property value="username"/> </td>
                                <td><s:property value="password"/> </td>
                                <td><s:property value="userType"/> </td>
                                <td><s:property value="phone"/> </td>
                                <td><s:property value="email"/> </td>
                                <td><a href="#">删除</a></td>
                            </tr>
                        </s:iterator>
                    </tbody>

                </table>
            </form>
        </div>
        <div id='page_next'>
            当前是第<s:property value="#request.page.pageNow" />页，共<s:property value="#request.page.totalPage" />页
            &nbsp;&nbsp;<s:if test="#request.page.hasFirst">
            <a href="allUserAction.action?pageNow=1" target="main">首页</a>
        </s:if>
            <s:if test="#request.page.hasPre">
                <a href="allUserAction.action?pageNow=<s:property value="#request.page.pageNow-1"/> "
                   target="main">上一页</a>
            </s:if>
            <s:if test="#request.page.hasNext">
                <a href="allUserAction.action?pageNow=<s:property value="#request.page.pageNow+1" />"
                   target="main">下一页</a>
            </s:if>
            <s:if test="#request.page.hasLast">
                <a href="allUserAction.action?pageNow=<s:property value="#request.page.totalPage"/>"
                   target="main">尾页</a>
            </s:if>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
