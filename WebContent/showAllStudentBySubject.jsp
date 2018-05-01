<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 上午 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>已选学生</title>
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
      <div class="showAllStudentBySubject">

        <h3 align="center">已选课程为：<s:property value="subjectName"/>&nbsp;的学生名单</h3>
        <br>
        <table class="table table-bordered" style="width: 100px;margin: 0 auto;text-align: center">
          <tr>
            <td></td>
            <td>学号</td>
            <td>姓名</td>
          </tr>
                <%
                  int i = 1;
                %>
          <s:iterator value="#request.showAllStudentBySubject">
            <tr>
              <td><%=i++%></td>
              <td><s:property value="chooseUserId"/> </td>
              <td><s:property value="username"/> </td>
            </tr>
          </s:iterator>
        </table>
      </div>
    </div>

    <div id="footer">
      <jsp:include page="bottom.jsp" />
    </div>
  </div>
  </body>
</html>
