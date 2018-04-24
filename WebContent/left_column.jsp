<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 上午 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>left_column</title>
</head>
<body>
<table class="table table-bordered">
    <tr>
        <td>
            <div id="left_login">
                <span style="font-size: 14px;font-family: 'Arabic Typesetting'">登录中心</span><br>
                <font  style="font-size: 12px;" color="red"><s:property value="#request.mess" /></font><br><br>
                <form action="loginAction.action" method="post">
                    <font style="font-size: 12px;font-family: 'Arabic Typesetting'">用户名：</font><input type="text" name="username" class="enter" placeholder="请输入用户名"><br><br>
                    <font style="font-size: 12px;font-family: 'Arabic Typesetting'">密&nbsp;&nbsp;&nbsp;码：</font><input type="password" name="password" class="enter" placeholder="请输入密码"><br><br>
                    <input name="imageField" type="image" src="./images/login_button.gif" />
                </form>
            </div>
        </td>
    </tr>
</table>
<br>
<table border=0 cellpadding=0 cellspacing=0>
    <tr>
        <td>
            <div id="left_sort">
                <ul id="sort_menu">
                    <ul id="menu">
                        <li class="list">
                            <a id="tab_1" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                系统管理
                            </a>
                            <ul class="tab" id="tab_1_content">
                                <li><a class="li_sort_content" href="addUser.jsp">添加用户</a></li>
                                <li><a class="li_sort_content" href="userList.jsp">查看用户</a></li>
                                <li><a class="li_sort_content" href="changePassord.jsp">修改密码</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="tab_2" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                教学管理
                            </a>
                            <ul class="tab" id="tab_2_content">
                                <li><a class="li_sort_content" href="enterScore.jsp">录入成绩</a></li>
                                <li><a class="li_sort_content" href="checkScore.jsp">查看成绩</a></li>
                                <li><a class="li_sort_content" href="testOnline.jsp">在线测评</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="tab_3" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                教学评价
                            </a>
                            <ul class="tab" id="tab_3_content">
                                <li><a class="li_sort_content" href="teaching.jsp">教学评价</a></li>
                                <li><a class="li_sort_content" href="checkTeaching.jsp">查看评价</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="tab_4" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                通知管理
                            </a>
                            <ul class="tab" id="tab_4_content">
                                <li><a class="li_sort_content" href="sendMessage.jsp">发布通知</a></li>
                                <li><a class="li_sort_content" href="checkMessage.jsp">查看通知</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="tab_5" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                资源管理
                            </a>
                            <ul class="tab" id="tab_5_content">
                                <li><a class="li_sort_content" href="uploadFile.jsp">上传文件</a></li>
                                <li><a class="li_sort_content" href="checkFile.jsp">查看文件</a></li>
                            </ul>
                        </li>
                    </ul>
                </ul>
            </div>
        </td>
    </tr>

</table>

<script src="js/left_column_tab.js" type="text/javascript"></script>
</body>
</html>
