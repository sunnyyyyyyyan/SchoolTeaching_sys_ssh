<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>
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
        <div class="uploadFile">
            <h2 align="center">上传资源</h2>
            <br>
            <form action="#">
                <table class="table table-bordered" >
                    <tr>
                        <td>上传者:</td>
                        <td>
                            <input type="text" name="uploader" />
                        </td>
                    </tr>
                    <tr>
                        <td>上传时间:</td>
                        <td>
                            <input type="date" name="uploadTime"/>
                            <font size="2" color="red">若手动输入，格式为：yyyy-MM-dd，例如2018-04-04</font>
                        </td>
                    </tr>
                    <tr>
                        <td>文件描述:&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>
                            <textarea name="description" style="width:300px;height:60px;"></textarea>
                            <font size="2" color="red">最多可输入100字</font>
                        </td>
                    </tr>
                    <tr>
                        <td>选择文件:</td>
                        <td>
                            <input type="file" name="file"/>
                            <font size="2" color="red">文件大小不能超过50M</font>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="上传"/>
                        </td>
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
