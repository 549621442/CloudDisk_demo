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
    
    <title>Main</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <head>
		<meta charset="UTF-8">
		<title>CloudDisk</title>
		
		<style>
			.leftbody{
				width:70%;
				position: absolute; top:5.7%; left:15%;
				background-color: cornflowerblue;
			}
			.head{
				position: absolute; top:0%; left:15%;
				width: 70%;
				height: 55px;
				background-color: #eee;
				border-radius: 5px;
				
				
			}
			td{
				background-color: deepskyblue;
				text-align: center;
				color: white;
			}
			.td{
				position: absolute; top:11.5%; left:15%;
				width:70%;
			}
			.blueButton
            {
                position: absolute;
                display: block;
                width: 100px;
                height: 40px;
                background-color: #00b3ee;
                color: #fff;
                text-decoration: none;
                text-align: center;
                font:normal normal normal 16px/40px 'Microsoft YaHei';
                cursor: pointer;
                border-radius: 4px;
            }
             .blueButton:hover
            {
                text-decoration: none;
            }
             .myFileUpload
            {
                position: absolute;
                display: block;
                width: 100px;
                height: 40px;
                opacity: 0;
            }
            .show
            {
                position: absolute;
                top:40px;
                width: 100%;
                height: 30px;
                font:normal normal normal 14px/30px 'Microsoft YaHei';
            }
		
		</style>
	</head>
	<body bgcolor="#F7DA55">
		<div >
				<%
					String uid = (String)session.getAttribute("uid");
					UserDao userdao = new UserDao();
					User user = null;
					user = userdao.queryUserByID(uid); 
				%>
					
			<div class="head">
				<span><center>CloudDisk</center></span>
				<%-- <div align="right">欢迎 <%=user.getUserName() %> 使用CloudDisk<a href="">退出</a></div> --%>
			</div>
			
			<div class="leftbody">
				<span><center>目录</center></span>
				<form action="${pageContext.request.contextPath}/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
				<input type = "file" name = "file1"/>
				<input type="submit" value="上传"/>
				<a href="/CloudDisk/uplist.jsp">查看上传信息</a>
				</form>
			</div>
			
			<table class="td" cellspacing="0">
				<tr >
					<td>文件名</td>
					<td>上传日期</td>
					<td>文件大小</td>
					<td>文件类型</td>
					<td>下载</td>
					<td>删除</td>
					
				</tr>
				
				<%
					FileDao filedao = new FileDao();
					
					
					
					List<FileMsg> list = filedao.queryUserAllfilemsg(uid);
				
					
					for(FileMsg filemsg:list){
					
					
				 %>
				 <tr>
				 	<td><%=filemsg.getFileName() %></td>
				 	<td><%=filemsg.getUpDate() %></td>
				 	<td><%=filemsg.getFileSize()%>KB</td>
				 	<td><%=filemsg.getFileType() %></td>
				 	<td><a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?path=<%=filemsg.getFileURL()%>&filename=<%= filemsg.getFileName()%>"><img alt="" src="img/timg.jpg" style="height: 27px; width: 27px; "></a></td>
				 	<td><a href="${pageContext.request.contextPath}/servlet/FileDeleteServlet?path=<%=filemsg.getFileURL()%>&fileid=<%= String.valueOf(filemsg.getFileID())%>"><img alt="" src="img/2.png" style="height: 38px; width: 36px; "></a></td>
				 </tr>
				 <%
				 }
				  %>
			</table>
			
		
		</div>
	</body>
</html>
