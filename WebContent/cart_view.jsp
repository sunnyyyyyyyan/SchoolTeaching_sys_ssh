<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��������Ʒ</title>
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
			<div id="center_column">
				<img src="images/shopping_card.gif" />
				<div id="cart_tb">
						<table id="table">
							<tr>
								<td width="10%"><span style="color:#696969;size:13;font-weight:bold;">���</span></td>
								<td width="30%"><span style="color:#696969;size:13;font-weight:bold;">��Ʒ����</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">���ۣ�Ԫ��</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">����</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">С�ƣ�Ԫ��</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">ɾ</span></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>	
							<s:iterator value="#request.cartInfo">					
									<tr>
										<td><s:property value="id"/> </td>
										<td><s:property value="productName"/></td>
										<td><s:property value="price"/></td>
										<td><s:property value="count"/></td>
										<td><s:property value="total"/></td>
										<td><a href="delByCartIdAction?id=<s:property value="id"/>" style="text-decoration: none;" >��</a> </td>							
									</tr>
							</s:iterator>		
						</table>
					</div>
				<div id="cart_tt">	
					�ϼ��ܽ�<span id="totalPrice" style="font-size: 18px; color: purple;"></span>Ԫ					
				</div>
				<div id="cart_lk">
					<a href="index.jsp">��������</a> | <a href="#">ȥ����̨����</a> | <a href="delUserCartAction.action ">��չ��ﳵ</a> 
				</div>
			
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	<script type="text/javascript">					
		var tab=document.getElementById("table");	
		var ans=0;
		for(var i=2;i<tab.rows.length;i++){			
			ans+=parseInt(tab.rows[i].cells[4].innerHTML);
		}
		 document.getElementById("totalPrice").innerHTML=ans;
		 
	</script>
</body>
</html>