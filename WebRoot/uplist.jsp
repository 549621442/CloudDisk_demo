<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="CloudDisk.dao.*" %>
<%@ page import="CloudDisk.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uplist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<table>
  			<tr>
  				<td>文件名</td>
  				<td>上传用户</td>
  				<td>上传日期</td>
  			</tr>
  			<%
					UploadDao uploaddao = new UploadDao();
					String uid = (String)session.getAttribute("uid");
					//Upload upload = null;
					
					List<Upload> list = uploaddao.queryAllUploadById(uid);
				
					
					for(Upload upload:list){	
				 %>
			<tr>
				<td><%=upload.getUploadFile() %></td>
				<td><%=upload.getUploadUser() %></td>
				<td><%=upload.getUploadDate() %></td>
			</tr>
			<%} %>
  		</table>
  		<a href="CloudDisk/main.jsp">返回</a>
    </body>
</html>
