<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
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
                <h2 align="center">添加用户</h2>
            <br>
            <form action="#">
                <table class="table table-bordered" style="margin:0 auto; text-align: center;width: 300px">
                    <tr>
                        <td>
                            用户编号：
                            <input type="text" name="userId" placeholder="学号或教师编号">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            用户名：
                            <input type="text" name="username" placeholder="请输入用户名">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            用户类型：
                            <select name="userType" id="userType">
                                <option value="管理员">管理员</option>
                                <option value="教师">教师</option>
                                <option value="学生">学生</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            密码：
                            <input type="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            电话号码：
                            <input type="text" name="phone" placeholder="请输入电话号码">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            邮箱：
                            <input type="text" name="email" placeholder="请输入邮箱">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button>提交</button>
                        </td>
                    </tr>
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
