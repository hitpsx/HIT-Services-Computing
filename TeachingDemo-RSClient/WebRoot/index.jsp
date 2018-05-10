<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="jquery-1.7.1.js" type="text/javascript"></script>
  <script src="test.js" type="text/javascript"></script>
	<!-- <script src="/js/test.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function(){
	    $("#btnOK").click(function(e){//1)查找$(”a”);2)jQuery对象事件click;3)jQuery对象方法hide
	        alert('a');   
	    });
	});
	</script> -->
    <base href="<%=basePath%>">
    
    <title>调用Restful方法的Demo</title>
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
    调用Restful方法的Demo <br>
    <table>
    	<tr>
    		<td width=300>
	    		姓名<input id="username" type="text"/><br><br>
				卡号<input id="IDcard" type="text"/><br><br>
				性别<input id="sex" type="text"/><br><br>
				单位<input id="unit" type="text"/><br><br>
				电话<input id="phone" type="text"/><br><br>
				邮箱<input id="email" type="text"/><br><br>
				测试<input id="equNumber" type="text"/><br><br>
			</td>
			<td width=300>
			    <input id="btnTest" type="button" value="查看个人信息"/><br><br>
			    <input id="btnTest1" type="button" value="模糊查询设备"/><br><br> 
			    <input id="btnTest2" type="button" value="精确查询设备"/><br><br> 	
 				<input id="btnTest3" type="button" value="添加用户"/><br><br> 
 				<input id="btnTest4" type="button" value="删除设备"/><br><br> 
 				<input id="btnTest5" type="button" value="添加设备"/><br><br> 
    		</td>
    		<td width=300>
	    		名字<input id="equName" type="text"/><br><br>
				单位<input id="equUnit" type="text"/><br><br>
				日期<input id="equDate" type="text"/><br><br>
				供应商<input id="supplier" type="text"/><br><br>
				位置<input id="presentPosition" type="text"/><br><br>
				单价<input id="unitPrice" type="text"/><br><br>
				管理者<input id="maintainer" type="text"/><br><br>
				状态<input id="equSta" type="text"/><br><br>
				分类<input id="equClass" type="text"/><br><br>
				补充<input id="extra" type="text"/><br><br>
			</td>
    	</tr>
    	<tr>
    		<td width=300>
    			<p>显示信息1</p>
    		</td>
			<td width=300>
    			<div id="div1">DIV层1信息</div><br>
    			---------------------------------------------------------
    			<div id="div2">DIV层2信息</div><br>
    			---------------------------------------------------------
    			<div id="div3">DIV层2信息</div><br>
    		</td>
    		
    	</tr>
    </table>
=
    		
  </body>
</html>
