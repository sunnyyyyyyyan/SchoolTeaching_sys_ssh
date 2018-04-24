<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userList</title>
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
                        <tr>
                            <td>cy000011110001</td>
                            <td>sunny</td>
                            <td>管理员</td>
                            <td>1</td>
                            <td>11112222</td>
                            <td>993303027@qq.com</td>
                            <td><a href="#">删除</a></td>
                        </tr>
                        <tr>
                            <td>cy000011110002</td>
                            <td>tom</td>
                            <td>教师</td>
                            <td>1</td>
                            <td>33334444</td>
                            <td>993303027@qq.com</td>
                            <td><a href="#">删除</a></td>
                        </tr>
                        <tr>
                            <td>cy000011110003</td>
                            <td>lily</td>
                            <td>学生</td>
                            <td>1</td>
                            <td>77778888</td>
                            <td>993303027@qq.com</td>
                            <td><a href="#">删除</a></td>
                        </tr>
                    </tbody>

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
