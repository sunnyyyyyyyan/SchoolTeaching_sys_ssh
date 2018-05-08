<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 上午 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
</head>
<body>
    <div id="headerMenu">
        <ul id="menu">
            <li><a class="li" href="main_index.jsp"><img src="./images/index.png" alt="index">首页</a></li>
            <li><a class="li" href="sendMessage.jsp"><img src="./images/gonggao.png" width="32px" alt="index">公告栏</a></li>
            <li><a class="li" href="checkMessage.jsp"><img src="./images/download.png" width="32px" alt="index">资源下载</a></li>
            <li><a class="li" href="#"><img src="./images/shequ.png" width="32px" alt="index">社区</a></li>
        </ul>
    </div>
    <div id="search">
        <form action="#">
            <input type="text" style="width: 150px;height: 25px;vertical-align:middle;" name="textSearch" placeholder="请输入关键字">
            <input type="image" name="imageSearch" src="./images/search.png" align="absmiddle" width="25px">
        </form>
    </div>

</body>
</html>
