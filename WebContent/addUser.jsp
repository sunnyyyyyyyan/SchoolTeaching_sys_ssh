<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>添加用户</title>
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
        <div class="addUser">
                <h4 align="center" style="padding-top: 100px">添加用户</h4>
            <br>
            <p align="center">
                    <font  style="font-size: 12px;" color="red"><s:property value="#request.addMess" /></font>
            </p>
            <form action="addUserAction.action" method="post">
                <table class="table table-bordered" style="margin:0 auto;width: 350px">

                <%
                    String userType = (String)ActionContext.getContext().getSession().get("userType");
                    if (userType.equals("管理员"))
                    {
                %>
                        <tr>
                            <td>
                                <font color="red">*</font>编号：
                            </td>
                            <td>
                                <input type="text" name="userId" placeholder="请输入编号">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <font color="red">*</font>姓名：
                            </td>
                            <td>
                                <input type="text" name="username" placeholder="请输入姓名">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <font color="red">*</font>类型：
                            </td>
                            <td>
                                <select name="userType" style="height: 30px">
                                    <option value="管理员">管理员</option>
                                    <option value="教师">教师</option>
                                    <option value="学生">学生</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <font color="red">*</font>密码：
                            </td>
                            <td>
                                <input type="password" name="password" placeholder="请输入密码">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                电话号码：
                            </td>
                            <td>
                                <input type="text" name="phone" placeholder="请输入电话号码">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                邮箱：
                            </td>
                            <td>
                                <input type="text" name="email" placeholder="请输入邮箱">
                            </td>
                        </tr>
                        <tr align="center">
                            <td colspan="2">
                                <button type="submit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="reset">重置</button>
                            </td>
                        </tr>
                    <%
                        }
                        if (userType.equals("教师"))
                        {
                    %>
                            <tr>
                                <td>
                                    <font color="red">*</font>编号：
                                </td>
                                <td>
                                    <input type="text" name="userId" placeholder="请输入编号">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font color="red">*</font>姓名：
                                </td>
                                <td>
                                    <input type="text" name="username" placeholder="请输入姓名">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font color="red">*</font>类型：
                                </td>
                                <td>
                                    <select name="userType" id="userType"  style="height: 30px">
                                        <option value="学生">学生</option>
                                    </select>
                                    <%--<input type="text" name="userType" value="学生"/>--%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font color="red">*</font>密码：
                                </td>
                                <td>
                                    <input type="password" name="password" placeholder="请输入密码">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    电话号码：
                                </td>
                                <td>
                                    <input type="text" name="phone" placeholder="请输入电话号码">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    邮箱：
                                </td>
                                <td>
                                    <input type="text" name="email" placeholder="请输入邮箱">
                                </td>
                            </tr>
                            <tr align="center">
                                <td colspan="2">
                                    <button type="submit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="reset">重置</button>
                                </td>
                            </tr>
                    <%
                        }
                    %>
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
