<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>

<body>
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
		
	<div id="div_reg">
       		<h3 align="center">会员登录</h3><br>
       		<hr size=1>
	<div id="div_login">
    <div id="div_login_leftimg">
		<img src="images/boy.gif" />
	</div>
	<div id="div_login_form">
		<form action="loginAction.action" method="post">
			<font class="zt2" color="red"><s:property value="#request.mess" /></font><br>
			<label for="username">用户名：</label>
			<input type="text" name="username" id="username" class="input"><br><br>
			<label for="password">密&nbsp;&nbsp;&nbsp;码：</label>
			<input type="password" name="password" id="password" class="input"><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	<input name="imageField" type="image" src="images/login_button.gif" />
      		<a href="reg.jsp"><img src="images/reg_button.gif" border= "0 " /></a>
         </form>
	</div>
	<div id="div_login_rightimg">
		<img src="images/girl.gif" />
	</div>
    </div>
	</div>  	
    <div id="footer">
		<jsp:include page="bottom.jsp" />  
	</div>
	</div>
</body>

</html>