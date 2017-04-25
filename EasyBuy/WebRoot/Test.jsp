<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="scripts/jquery-2.1.0.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<%
			String pricestring = "999.0";
			int priceint = 2;
			double  pricedouble = 999.1 ;
			pricestring = String.valueOf(pricedouble);
			pricedouble = Double.parseDouble((pricestring));
			System.out.println(pricestring);
			
	 %>
<script type="text/javascript">
		function getspanvalue(){
		var inputval = $("#input");
			alert(inputval.val());
		}
</script>
<style type="text/css">
	a:link {color: red;}	/* 未访问的链接 */

	a:hover {color: white}	/* 鼠标移动到链接上 */
	a:active {color: blue}	/* 选定的链接 */
		a:visited {color: green}	/* 已访问的链接 */
</style>
  </head>
  
  <body>
  	<input type="number" id="input">
   <button onclick="getspanvalue()">123</button>
   <a>点我</a>
  </body>
</html>
