<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 上午 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>教学质量监控系统</title>
      <link rel="stylesheet" href="css/global.css">
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
      <jsp:include page="center_column.jsp" />
    </div>

    <div id="footer">
      <jsp:include page="bottom.jsp" />
    </div>
  </div>
  </body>
</html>
