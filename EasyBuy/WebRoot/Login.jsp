<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!-- 过滤器 记住我 -->



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="description" content="EasyBuy商城">
<meta name="author" content="乐观的绅士Z">
<title>易买商场——登录</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="css/bootstrap.min.css " rel="stylesheet">
<link rel="icon" href="Img/Logo.ico" type="image/x-icon">
<link href="css/LoginStyle.css " rel="stylesheet">
<script src="scripts/jquery-2.1.0.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="scripts/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
	function Register() {
		window.location.href = "Register.jsp";
	}
	function unamefun(){
			$("#erroruname").html("");
	}
	
	function upwdfun(){
			$("#errorpwd").html("");
	}
	
	$(function() {
		$("#Login").click(function() {
			var uname = $("#inputuser");
			var upwd = $("#inputpwd");
			if (uname.val() != "" && upwd.val() != "") {
				$.post("LoginService", {
					'username' : encodeURI(encodeURI(uname.val())),
					'upwd' : encodeURI(encodeURI(upwd.val()))
				}, function(data) {
					if (data == 1) {							
						window.location.href = "Home.jsp";
					} else if (data == 2) {	
						$("#erroruname").html("帐号不存在");				
					} else {	
						$("#errorpwd").html("帐号或密码错误");
					}
				}, "html");
			} else {
				if (uname.val() == "") {			
					$("#erroruname").html("请输入用户名");
				}
				if (upwd.val() == "") {		
					$("#errorpwd").html("请输入密码");
				}
			}
		});
	});
</script>
<style type="text/css">
body {
	position: relative;
}
</style>
</head>

<body style="padding-top:50px">
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
			<a class="navbar-brand" href="Home.jsp">EasyBuy</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="# ">服饰</a></li>
				<li><a href="#">美妆</a></li>
				<li><a href="#">家电</a></li>
				<li><a href="#">数码</a></li>
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
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-5">
				<div class="progress"
					style="  margin-bottom: 50px; margin-top: 50px; height: 5px;">
					<div class="progress-bar progress-bar-success" style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
					<div class="progress-bar progress-bar-warning " style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
					<div class="progress-bar progress-bar-danger" style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
					<div class="progress-bar progress-bar-info" style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-2">
				<div class="TextBox">
					<img alt="" src="Img/favicon.jpg"> <span
						style="font-family: '微软雅黑';font-size: 18px;color: #a29f9f;">登录EasyBuy</span>
				</div>
			</div>
			<div class="col-xs-12 col-sm-5">
				<div class="progress"
					style="  margin-bottom: 50px; margin-top: 50px; height: 5px;">
					<div class="progress-bar progress-bar-info" style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
					<div class="progress-bar progress-bar-danger" style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
					<div class="progress-bar progress-bar-warning " style="width: 25%">
						<span class="sr-only">25%</span>
					</div>
					<div class="progress-bar progress-bar-success" style="width: 25%">
						<span class="sr-only">25%</span>
					</div>

				</div>
			</div>
			<div class="col-xs-12 col-sm-6" style="text-align: center;	">
				<img alt="" src="Img/RegisterLogo.png" style="width: 60%">
			</div>
			<div class="col-xs-12 col-sm-6">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputuser" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputuser"
								placeholder="用户名或邮箱" onfocus="unamefun(this)">
								<label class="error_is-visible_uname" id="erroruname"></label>
								
						</div>
					</div>
					<div class="form-group">
						<label for="inputpwd" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputpwd"
								placeholder=""  onfocus="upwdfun(this)">
								<label class="error_is-visible_pwd"  id="errorpwd"></label>
							
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-3">
							<div class="checkbox" style="padding-top:0px;">
								<label> <input type="checkbox">记住我
								</label>
							</div>
						</div>
						<div class="col-sm-offset-1 col-sm-3">
							<a href="#">忘记密码？</a>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<input type="button" class="btn btn-primary" style="width:128px;"
								id="Login" value="登录" /> <input type="button"
								class="btn btn-default" style="width:128px;"
								onclick="Register()" value="注册" />
						</div>
					</div>
				</form>
			
			</div>
		</div>
		<!-- /container -->
		<hr>
		<footer>
		<p>&copy; Company 2014</p>
		</footer>
</body>
</html>
