<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>修改用户信息</title>
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
        <div class="changeUser">
            <h2 align="center">修改用户</h2><br>
            <p align="center" >
                <font color="red"><s:property value="#request.updateMess" /></font>
            </p>

            <form action="updateUserAction.action?userId=<s:property value="userId"/>" method="post">
                <table  class="table table-bordered" style="margin:0 auto;width: 350px">
                    <tr>
                        <s:iterator value="#request.user" >
                            <td>学/编号：
                            </td>
                            <td><input type="text" value="<s:property value="userId"/> ">
                            </td>
                        </s:iterator>
                    </tr>
                    <tr>
                        <td>新用户名：
                        </td>
                        <td><input type="text" name="username" >
                        </td>
                    </tr>
                    <tr>
                        <td>新密码：
                        </td>
                        <td><input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码：
                        </td>
                        <td><input type="password" name="password1">
                        </td>
                    </tr>
                    <tr>
                        <td>电话号码：
                        </td>
                        <td><input type="text" name="phone">
                        </td>
                    </tr>
                    <tr>
                        <td>邮箱：
                        </td>
                        <td><input type="text" name="email">
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <button type="submit">修改</button>&nbsp;&nbsp;&nbsp;
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
