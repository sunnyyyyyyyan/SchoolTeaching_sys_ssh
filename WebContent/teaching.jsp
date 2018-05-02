<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>teaching</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <SCRIPT type="text/javascript">
        var maxtime = 0 * 60; //一个小时，按秒计算，自己调整!
        function CountDown() {
            if (maxtime >= 0) {
                minutes = Math.floor(maxtime / 60);
                seconds = Math.floor(maxtime % 60);
                msg = "距离结束还有" + minutes + "分" + seconds + "秒";
                document.all["timer"].innerHTML = msg;
                if (maxtime == 5 * 60)alert("还剩5分钟");
                --maxtime;
            } else{
                clearInterval(timer);
                alert("时间到，结束!");
            }
        }
        timer = setInterval("CountDown()", 1000);
    </SCRIPT>
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
        <div class="teaching">
            <div id="timer" style="color:red"></div>
            <div id="warring" style="color:red"></div>
            <table class="table">
                <tr>
                    <td>teaching</td>
                    <td id="show"></td>
                </tr>
            </table>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
