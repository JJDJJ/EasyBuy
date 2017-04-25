<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<style type="text/css">
body {
	position: relative;
}

.img-circle {
	border-radius: 50%;
	border: 1px solid #dddddd;
	padding: 1px;
	background-color: white;
	width: 53px;
	margin-right: 10px;
}
.img-circle {
	border-radius: 50%;
	border: 1px solid #dddddd;
	padding: 1px;
	background-color: white;
	width: 53px;
	margin-right: 10px;
}
.outloginbtn {
	border-radius: 0px;
	color: #d0d0d0;
	border: none;
	background-color: #d43f3a;
	height: 53px;
}
.outloginbtn:hover{
	color:white;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#loginout").click(function(){
				$.post("LoginOut",{
					'username':"<%=session.getAttribute("username")%>"
				},function(){
					location.reload();
				});	
		});
	});
</script>
</head>

<body>
	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation"
		style="margin-bottom:0px;">

	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</button>
			<a class="navbar-brand " href="Home.jsp">EasyBuy</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#Clothes ">服饰</a></li>
				<li><a href="#Beauty">美妆</a></li>
				<li><a href="#EB">家电</a></li>
				<li><a href="#Digital">数码</a></li>
			</ul>
			<ul class="nav navbar-nav" style="float:right">
				<%
					if (session.getAttribute("username") != null) {
						String uname = session.getAttribute("username").toString();
						out.println("<li><a href=" + "PersonCenter.jsp?username="
								+ uname + " " + "Style='padding:0px;font-size: 18px'" + "><img src="
								+ "Img/Aetly.jpg" + " alt=" + "头像 " + " class="
								+ "img-circle" + " " + ">" + uname + "</a></li><li style=" +" margin-left:10px; "+"><button id="+"loginout"+" onclick=" + "loginout()"+" class="+"outloginbtn"+"  >退出登录</button></li>");
					} else {
						out.println("<li><a href=" + "Login.jsp" + ">登录</a></li>");
						out.println("<li><a href=" + "Register.jsp" + ">注册</a></li>");
					}
				%>
			</ul>

		</div>
		<!-- /.modal -->
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container --> </nav>
	<!-- /.navbar -->
	<div class="header"
		style="background-image: url('Img/header.png')  ;margin-bottom:20px;">
	</div>
</body>
</html>
