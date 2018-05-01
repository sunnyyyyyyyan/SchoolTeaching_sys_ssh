<%@ page import="java.util.Calendar" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
<table>
    <tr>
        <td>
            <div id="left_login">
                <%
                    String userId = (String)ActionContext.getContext().getSession().get("userId");
                    if(userId == null){
                %>
                <span style="font-size: 14px;font-family: 'Arabic Typesetting';">登录中心</span><br>
                <font  style="font-size: 12px;" color="red"><s:property value="#request.loginMess" /></font><br>
                <form action="loginAction.action" method="post">
                    <font style="font-size: 12px;font-family: 'Arabic Typesetting';width: 60px;">编号&nbsp;</font><input type="text" name="userId" class="enter" placeholder="请输入编号"><br><br>
                    <font style="font-size: 12px;font-family: 'Arabic Typesetting';width: 60px;">密&nbsp;&nbsp;&nbsp;码&nbsp;</font><input type="password" name="password" class="enter" placeholder="请输入密码"><br><br>
                    <input name="imageField" type="image" src="./images/login_button.gif" />
                </form>
                <%
                }else{
                    byte a[]=userId.getBytes("utf-8");
                    userId=new String(a);
                    Calendar cal = Calendar.getInstance();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    if (hour >= 5 && hour < 8) {
                        out.print("<span style='color:red;font-size:12px;'>早上好，"+userId +"</span>");
                    }else if (hour >= 8 && hour < 11) {
                        out.print("<span style='color:red;font-size:12px;'>上午好，"+userId+"</span>");
                    }else if (hour >= 11 && hour < 13) {
                        out.print("<span style='color:red;font-size:12px;'>中午好，"+userId+"</span>");
                    }else if (hour >= 13 && hour < 18) {
                        out.print("<span style='color:red;font-size:12px;'>下午好，"+userId+"</span>");
                    }else if (hour >= 18 && hour < 23) {
                        out.print("<span style='color:red;font-size:12px;'>晚上好，"+userId+"</span>");
                    }else {
                        out.print("<span style='color:red;font-size:12px;'>夜深啦，"+userId+"</span>");
                    }
                %>
                <br><br>
                <form action="exitAction.action" method="post">
                    <button type="submit" style="font-size: 12px;margin-left: 50px">退出</button>
                </form>

                <%
                    }
                %>
            </div>
        </td>
    </tr>
</table>
<br>
<hr style="width: 170px;">
<table border=0 cellpadding=0 cellspacing=0>
   <tr>
        <td>
            <div id="left_sort">
                <ul id="sort_menu">
                    <%
                        String userType = (String)ActionContext.getContext().getSession().get("userType");
                        if (userType.equals("管理员"))
                        {
                    %>
                    <ul id="menu">
                        <li class="list">
                            <a id="admin_tab_1" class="li_sort">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                系统管理
                            </a>
                            <ul class="tab" id="admin_tab_1_content">
                                <li><a class="li_sort_content" href="addUser.jsp" target="_parent">添加用户</a></li>
                                <li><a class="li_sort_content" href="allUserAction.action" target="_parent">用户列表</a></li>
                                <li><a class="li_sort_content" href="getUserByIdAction.action?userId=<%=userId%> " target="_parent">修改信息</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="admin_tab_2" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                成绩管理
                            </a>
                            <ul class="tab" id="admin_tab_2_content">
                                <li><a class="li_sort_content" href="addGrade.jsp" target="_parent">录入成绩</a></li>
                                <li><a class="li_sort_content" href="checkAllGradeAction.action" target="_parent">查看成绩</a></li>
                                <li><a class="li_sort_content" href="testOnline.jsp" target="_parent">在线测评</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="admin_tab_3" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                教学管理
                            </a>
                            <ul class="tab" id="admin_tab_3_content">
                                <li><a class="li_sort_content" href="teaching.jsp" target="_parent">教学评价</a></li>
                                <li><a class="li_sort_content" href="checkTeaching.jsp" target="_parent">查看评价</a></li>
                            </ul>
                        </li>
                        <li class="list">
                            <a id="admin_tab_4" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                课程管理
                            </a>
                            <ul class="tab" id="admin_tab_4_content">
                                <li><a class="li_sort_content" href="checkSubjectAction.action" target="_parent">课程与选课</a></li>
                                <li><a class="li_sort_content" href="addQuestion.jsp" target="_parent">增加试题</a></li>
                            </ul>
                        </li>
                        <%--<li class="list">
                            <a id="admin_tab_5" class="li_sort" href="#">
                                <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                资源管理
                            </a>
                            <ul class="tab" id="admin_tab_5_content">
                                <li><a class="li_sort_content" href="sendMessage.jsp" target="_parent">发布通知</a></li>
                                <li><a class="li_sort_content" href="checkMessage.jsp" target="_parent">查看通知</a></li>
                                <li><a class="li_sort_content" href="uploadFile.jsp" target="_parent">上传文件</a></li>
                                <li><a class="li_sort_content" href="checkFile.jsp" target="_parent">查看文件</a></li>
                            </ul>
                        </li>--%>
                    </ul>
                    <%
                        }
                        if (userType.equals("教师"))
                        {
                    %>
                        <ul id="menu">
                            <li class="list">
                                <a id="teacher_tab_1" class="li_sort">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    系统管理
                                </a>
                                <ul class="tab" id="teacher_tab_1_content">
                                    <li><a class="li_sort_content" href="addUser.jsp" target="_parent">添加用户</a></li>
                                    <li><a class="li_sort_content" href="allUserAction.action" target="_parent">用户列表</a></li>
                                    <li><a class="li_sort_content" href="getUserByIdAction.action?userId=<%=userId%> " target="_parent">修改信息</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="teacher_tab_2" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    成绩管理
                                </a>
                                <ul class="tab" id="teacher_tab_2_content">
                                    <li><a class="li_sort_content" href="addGrade.jsp" target="_parent">录入成绩</a></li>
                                    <li><a class="li_sort_content" href="checkAllGradeAction.action" target="_parent">查看成绩</a></li>
                                    <li><a class="li_sort_content" href="testOnline.jsp" target="_parent">在线测评</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="teacher_tab_3" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    教学管理
                                </a>
                                <ul class="tab" id="teacher_tab_3_content">
                                    <li><a class="li_sort_content" href="teaching.jsp" target="_parent">教学评价</a></li>
                                    <li><a class="li_sort_content" href="checkTeaching.jsp" target="_parent">查看评价</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="teacher_tab_4" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    课程管理
                                </a>
                                <ul class="tab" id="teacher_tab_4_content">
                                    <li><a class="li_sort_content" href="addSubject.jsp" target="_parent">添加课程</a></li>
                                    <li><a class="li_sort_content" href="checkSubjectAction.action " target="_parent">课程与选课</a></li>
                                    <li><a class="li_sort_content" href="addQuestion.jsp" target="_parent">增加试题</a></li>
                                    <li><a class="li_sort_content" href="QuestionListAction.action" target="_parent">试题列表</a></li>
                                </ul>
                            </li>
                            <%--<li class="list">
                                <a id="teacher_tab_5" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    资源管理
                                </a>
                                <ul class="tab" id="teacher_tab_5_content">
                                    <li><a class="li_sort_content" href="sendMessage.jsp" target="_parent">发布通知</a></li>
                                    <li><a class="li_sort_content" href="checkMessage.jsp" target="_parent">查看通知</a></li>
                                    <li><a class="li_sort_content" href="uploadFile.jsp" target="_parent">上传文件</a></li>
                                    <li><a class="li_sort_content" href="checkFile.jsp" target="_parent">查看文件</a></li>
                                </ul>
                            </li>--%>
                        </ul>
                    <%
                        }
                        if (userType.equals("学生"))
                        {
                    %>
                        <ul id="menu">
                            <li class="list">
                                <a id="student_tab_1" class="li_sort">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    系统管理
                                </a>
                                <ul class="tab" id="student_tab_1_content">
                                    <li><a class="li_sort_content" href="getUserByIdAction.action?userId=<%=userId %> " target="_parent">修改信息</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="student_tab_2" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    成绩管理
                                </a>
                                    <ul class="tab" id="student_tab_2_content">
                                    <li><a class="li_sort_content" href="checkAllGradeByIdAction.action?userId=<%=userId %>" target="_parent">查看成绩</a></li>
                                    <li><a class="li_sort_content" href="testOnline.jsp" target="_parent">在线测评</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="student_tab_3" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    教学评价
                                </a>
                                <ul class="tab" id="student_tab_3_content">
                                    <li><a class="li_sort_content" href="teaching.jsp" target="_parent">教学评价</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="student_tab_4" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    课程管理
                                </a>
                                <ul class="tab" id="student_tab_4_content">
                                    <li><a class="li_sort_content" href="checkSubjectAction.action" target="_parent">课程与选课</a></li>
                                </ul>
                            </li>
                            <li class="list">
                                <a id="student_tab_5" class="li_sort" href="#">
                                    <img src="./images/sort_menu.gif" width="26px" align="absmiddle" />
                                    资源管理
                                </a>
                                <ul class="tab" id="student_tab_5_content">
                                    <li><a class="li_sort_content" href="checkMessage.jsp" target="_parent">查看通知</a></li>
                                    <li><a class="li_sort_content" href="uploadFile.jsp" target="_parent">上传文件</a></li>
                                    <li><a class="li_sort_content" href="checkFile.jsp" target="_parent">查看文件</a></li>
                                </ul>
                            </li>
                        </ul>
                    <%
                        }
                    %>
                </ul>
            </div>
        </td>
    </tr>
</table>


<script src="js/left_column_tab.js" type="text/javascript"></script>
</body>
</html>
