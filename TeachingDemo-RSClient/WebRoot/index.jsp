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
	    $("#btnOK").click(function(e){//1)����$(��a��);2)jQuery�����¼�click;3)jQuery���󷽷�hide
	        alert('a');   
	    });
	});
	</script> -->
    <base href="<%=basePath%>">
    
    <title>����Restful������Demo</title>
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
    ����Restful������Demo <br>
    <table>
    	<tr>
    		<td width=300>
	    		����<input id="username" type="text"/><br><br>
				����<input id="IDcard" type="text"/><br><br>
				�Ա�<input id="sex" type="text"/><br><br>
				��λ<input id="unit" type="text"/><br><br>
				�绰<input id="phone" type="text"/><br><br>
				����<input id="email" type="text"/><br><br>
				����<input id="equNumber" type="text"/><br><br>
			</td>
			<td width=300>
			    <input id="btnTest" type="button" value="�鿴������Ϣ"/><br><br>
			    <input id="btnTest1" type="button" value="ģ����ѯ�豸"/><br><br> 
			    <input id="btnTest2" type="button" value="��ȷ��ѯ�豸"/><br><br> 	
 				<input id="btnTest3" type="button" value="����û�"/><br><br> 
 				<input id="btnTest4" type="button" value="ɾ���豸"/><br><br> 
 				<input id="btnTest5" type="button" value="����豸"/><br><br> 
    		</td>
    		<td width=300>
	    		����<input id="equName" type="text"/><br><br>
				��λ<input id="equUnit" type="text"/><br><br>
				����<input id="equDate" type="text"/><br><br>
				��Ӧ��<input id="supplier" type="text"/><br><br>
				λ��<input id="presentPosition" type="text"/><br><br>
				����<input id="unitPrice" type="text"/><br><br>
				������<input id="maintainer" type="text"/><br><br>
				״̬<input id="equSta" type="text"/><br><br>
				����<input id="equClass" type="text"/><br><br>
				����<input id="extra" type="text"/><br><br>
			</td>
    	</tr>
    	<tr>
    		<td width=300>
    			<p>��ʾ��Ϣ1</p>
    		</td>
			<td width=300>
    			<div id="div1">DIV��1��Ϣ</div><br>
    			---------------------------------------------------------
    			<div id="div2">DIV��2��Ϣ</div><br>
    			---------------------------------------------------------
    			<div id="div3">DIV��2��Ϣ</div><br>
    		</td>
    		
    	</tr>
    </table>
=
    		
  </body>
</html>
