<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
			
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
			<div id="center_column" align="center">
				
				
				<form action="onlineAction.action" method="post" style="text-align: center;margin: 60px;">
			        	<font color="red"><s:property value="#request.online"/></font><br><br>
			        	标签：<input type="text" name="textname"><br><br>
			        	标题：<input type="text" name="title"><br><br>
			        	留言内容：<br><br>
			        	<textarea rows="20" cols="75" name="message"></textarea><br><br>       
			        	<input type="submit" value="提交信息" style="height: 30px;width: 70px;"><br>
			    </form>
				<form action="getOnlineByNameAction?username=<s:property value="username"/>" style="text-align: right;margin: 60px;">
			        <input type="submit" value="查看留言板" style="height: 30px;width: 80px;">
			    </form>
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>

</body>
</html>