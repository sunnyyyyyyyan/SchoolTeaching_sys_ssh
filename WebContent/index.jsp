<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/28 0028
  Time: 上午 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>教学质量监控系统</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body background="images/sky.jpg" style="font-family: Times, TimesNR, 'New Century Schoolbook',Georgia, 'New York', serif;">

<h2 align="center" style="margin-top: 100px;">教学质量监控系统</h2>
<br>
<div class="welcome" style="width: 200px;margin:0 auto;">
    <marquee behavior="scroll" direction="left">欢迎您！</marquee>
</div>

<div class="login_content">
    <form action="loginAction.action" method="post">
        <table class="table table-bordered" align="center" style="font-size:14px;width: 400px;margin-top: 50px;text-align: center">
            <tr>
                <td colspan="2">用户登录</td>
            </tr>
            <tr>
                <td colspan="2" align="center"><font  style="font-size: 12px;" color="red"><s:property value="#request.loginMess" /></font></td>
            </tr>
            <tr>
                <td>编&nbsp;&nbsp;号：</td>
                <td><input type="text" name="userId"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>身&nbsp;&nbsp;份：</td>
                <td>
                    <input type="radio" name="userType" value="管理员">管理员&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="userType" value="教师">教师&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="userType" value="学生">学生
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input name="imageField" type="image" src="./images/login_button.gif" />
                </td>
            </tr>
        </table>

    </form>
</div>

<div class="bottom" style="position: absolute;left: 0;right: 0;bottom:0;text-align: center">
    <br><br><br><br>教学质量监控系统&copy;2018&nbsp;&nbsp;&nbsp;&nbsp;浙江中医药大学<br><br>
    地址：浙江 杭州 &nbsp;&nbsp;&nbsp;Email：<a href="mailto:993303027@qq.com">993303027@qq.com</a> &nbsp;&nbsp;&nbsp;TEL：516383
</div>
</body>
</html>
