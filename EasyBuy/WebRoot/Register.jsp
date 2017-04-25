<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!-- 验证码 -->


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="description" content="EasyBuy商城">
<meta name="author" content="乐观的绅士Z">
<link rel="icon" href="Img/Logo.ico" type="image/x-icon">
<title>易买商场——注册</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="css/bootstrap.min.css " rel="stylesheet">
<link href="css/RegisterStyle.css " rel="stylesheet">
<script src="scripts/jquery-2.1.0.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="scripts/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
	function Login() {
		window.location.href = "Login.jsp";
	}
</script>
<script type="text/javascript">
	function inputuserfun() {
		$("#erroruname").html("");
	}

	function inputpwdfun() {
		$("#errorpwd").html("");
	}
	function inputcheckpwdfun() {
		$("#errorcheckpwd").html("");
	}
	function inputvcodefun() {
		$("#errorvCode").html("");
	}

	$(function() {
		$("#RegisterBtn")
				.click(
						function() {
							var uname = $("#inputuser");
							var upwd = $("#inputpwd");
							var checkpwd = $("#inputpwd2");
							var vCode = $("#inputVerification");
							if (uname.val() != "" && upwd.val() != ""
									&& checkpwd.val() != ""
									&& vCode.val() != "") {
								var unamereg = /[A-Za-z0-9\u4e00-\u9fa5]/;
								if (!unamereg.test(uname.val())) {
									$("#erroruname").html("用户名不能包含非法字符");
								}
								if (uname.val().length < 2
										|| uname.val().length > 10) {
									$("#erroruname").html("用户名应由2-10位字符组成");
								}
								if (upwd.val().length < 6) {
									$("#errorpwd").html("密码过短");
								}
								if (upwd.val().length > 25) {
									$("#errorpwd").html("密码过长");
								}
								if (upwd.val() != checkpwd.val()) {
									$("#errorcheckpwd").html("两次密码不匹配");
								}
								//验证码判断
								if ($("#erroruname").html() == ""
										&& $("#errorpwd").html() == ""
										&& $("#errorcheckpwd").html() == ""
										&& $("#errorvCode").html() == "") {
									$
											.post(
													"RegisterService",
													{
														'username' : encodeURI(encodeURI(uname
																.val())),
														'userpwd' : encodeURI(encodeURI(checkpwd
																.val())),
													},
													function(data,
															XMLHttpRequest) {
														if (data == 1) {
															$("#SucessLoginBtn")
																	.click();
															setTimeout(
																	function() {
																		window.location.href = "Login.jsp";
																	}, 1500);
														} else if (data == 2) {
															$("#erroruname")
																	.html(
																			"帐号已存在");
														} else {
															alert("注册错误！代码:"
																	+ XMLHttpRequest.status);
														}
													});
								}
							} else {
								if (uname.val() == "") {
									$("#erroruname").html("请输入用户名");
								}
								if (upwd.val() == "") {
									$("#errorpwd").html("请输入密码");
								}
								if (checkpwd.val() == "") {
									$("#errorcheckpwd").html("请确认密码");
								}
								if (vCode.val() == "") {
									$("#errorvCode").html("请输入验证码");
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
						style="font-family: '微软雅黑';font-size: 18px;color: #a29f9f;">注册EasyBuy</span>
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
								placeholder="2-10位字符的用户名" onfocus="inputuserfun(this)"><label
								class="error_is-visible_uname" id="erroruname"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputpwd" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputpwd"
								placeholder="不少于6位数的密码" onfocus="inputpwdfun(this)"><label
								class="error_is-visible_pwd" id="errorpwd"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputpwd2" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputpwd2"
								placeholder="请输入同上密码" onfocus="inputcheckpwdfun(this)"><label
								class="error_is-visible_pwd" id="errorcheckpwd"></label>
						</div>
					</div>

					<div class="form-group">
						<label for="inputVerification " class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputVerification"
								placeholder="" onfocus="inputvcodefun(this)"><label
								class="error_is-visible_pwd" id="errorvCode"></label>
						</div>
						<div class="col-sm-3">
							<span>验证码</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<div class="checkbox">
								<label> <input type="checkbox">同意条款
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button type="button" class="btn btn-primary" id="RegisterBtn">注册</button>
							<button type="button" class="btn btn-default"
								style="float:right;" id="LoginBtn" onclick="Login()">返回登陆</button>
						</div>
					</div>
				</form>

				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target=".bs-example-modal-sm" id="SucessLoginBtn" style="display:none"></button>
				<div class="modal fade bs-example-modal-sm" tabindex="-1"
					role="dialog" aria-labelledby="mySmallModalLabel"
					aria-hidden="true">
					<div class="modal-dialog modal-sm"
						style="width:400px;margin: 20% auto;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="mySmallModalLabel"
									style="text-align: center">消息提示</h4>
							</div>
							<div class="modal-body">
						
								<h4 class="modal-title" id="mySmallModalLabel"
									style="text-align: center"><span class="glyphicon glyphicon-ok" style="color: green;  font-size: 25px;   padding-right: 5px; top:5px"></span>注册成功！</h4>
  
 
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>
		</div>
		<!-- /container -->
		<hr>
		<footer>
		<p>&copy; Company 2014</p>
		</footer>
</body>

</html>
