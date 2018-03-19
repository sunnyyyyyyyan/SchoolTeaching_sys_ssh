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
				<s:iterator value="#request.getOnline">
				<form  style="text-align: left;;margin: 15px;">	
					<s:property value="id"/><br>
					标签：<s:property value="textname"/><br>
					标题：<s:property value="title"/><br>
					留言内容：<s:property value="message"/>
				</form> 
				</s:iterator>     
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>

</body>
</html>