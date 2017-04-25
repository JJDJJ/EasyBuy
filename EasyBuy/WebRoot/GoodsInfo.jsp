<%@page import="com.zjj.IService.ServiceFactory"%>
<%@page import="com.zjj.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="description" content="EasyBuy商城">
<meta name="author" content="乐观的绅士Z">
<script src="scripts/jquery-2.1.0.js"></script>
<link rel="icon" href="Img/Logo.ico" type="image/x-icon">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="css/bootstrap.min.css " rel="stylesheet">
<link href="css/offcanvas.css" rel="stylesheet">
<link href="css/docs.min.css" rel="stylesheet">
<link href="http://v3.bootcss.com/examples/carousel/carousel.css"
	rel="stylesheet">
<link href="css/GoodsInfo.css" rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="scripts/bootstrap.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<%
		String goodsId = request.getParameter("goodsid");
		String uname =(String)session.getAttribute("username");
		if(uname == null){
			uname = "0";
		}else {
			uname =(String)session.getAttribute("username");
		}	
	 	 Goods goods = ServiceFactory.getService("Goods").findByID(Integer.parseInt(goodsId));
 %>
<title>易买商城——<%=goods.getGoodsname()%></title>
<script type="text/javascript">
	   $(function(){
			$("#AddCar").click(function(){    
		 	var goodsId = <%=goods.getGoodsid()%>
			 	if(<%=uname.equals("0")%>){
			 		 $("#loginmodal").click();
			 	}else{
			 		var userid ="<%=uname%>";
			 		var goodsnum = $("#inputgoodsnum"); 	
				 	var goodspice = <%=goods.getGoodsprice()%>;
				 	var goods_subtotal = goodsnum.val() * goodspice;
			 		$.post("ShopCarList", {
							'username':userid,
							'goodsid':goodsId,	
							'num':goodsnum.val(),
							'goods_subtotal':goods_subtotal
						},function(data){
							if(data == 1){
								alert("添加成功！");
							}else{
								alert("添加失败！");
							}
						});
			 	}
			});
	});
	
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
						location.reload();
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
<script type="text/javascript">
	$(function(){
		$("#loginout").click(function(){
				$.post("LoginOut",{
					'username':"<%=uname%>"
				},function(){
					location.reload();
				});	
		});
	});
</script>
</head>

<body style="padding-bottom: 154px;">
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
					if (uname !="0") {					 
						out.println("<li><a href=" + "PersonCenter.jsp?username="
								+ uname + "  " + "Style='padding:0px;font-size: 18px;'" + "><img src="
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

	<div class="container">
	
	<!-- 登录框-->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true" id="LoginTab">
		<div class="modal-dialog modal-sm" style="width:400px;margin-top: 300px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="mySmallModalLabel"
						style="text-align: center">登录</h4>
				</div>
				<div class="modal-body">
					<!-- 登录表单 -->
					<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputuser" class="col-sm-3 control-label">用户名</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputuser"
								placeholder="用户名或邮箱" onfocus="unamefun(this)">
								<label class="error_is-visible_uname" id="erroruname"></label>
								
						</div>
					</div>
					<div class="form-group">
						<label for="inputpwd" class="col-sm-3 control-label">密码</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="inputpwd"
								placeholder=""  onfocus="upwdfun(this)">
								<label class="error_is-visible_pwd"  id="errorpwd"></label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-4">
							<div class="checkbox" style="padding-top:0px;">
								<label> <input type="checkbox">记住我
								</label>
							</div>
						</div>
						<div class="col-sm-offset-1 col-sm-4">
							<a href="#">忘记密码？</a>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<input type="button" class="btn btn-primary" style="width:128px;"
								id="Login" value="登录" /> <input type="button"
								class="btn btn-default" style="width:128px;"
								onclick="Register()" value="注册" />
						</div>
					</div>
				</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
		<div class="row row-offcanvas row-offcanvas-right" style="margin-bottom:40px;">
          <div class="col-xs-12 col-sm-3">
				<img alt="" src="Img/<%=goods.getGoodsimg()%>">
			</div>
			<div class="col-xs-12 col-sm-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title" style="font-size: 25px;  font-weight: 700;" id="h3goodsname"><%=goods.getGoodsname()%></h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form">			
								<h2 style="padding-left: 20px;">
									<small>价格：</small>
									<span style="color:red;font-size: 20px">￥</span>
									<span style="color:red" ><%=goods.getGoodsprice()%></span> 
								</h2>
									<h2 style="padding-left: 20px;">
									<small>库存：</small>
									<span ><%=goods.getGoods_stock()%></span> 
								</h2>
								<h3 style="padding-left: 20px;" >	
									<small style="line-height: 23px"><%=goods.getGoodsintroduce()%></small> 
								</h3>
						</form>
					</div>
				</div>
				<p style="padding-left: 34px;">
	               <label style="font-size: 18px;">数量：</label> 
					<input type="number"  id="inputgoodsnum"	style="padding: 6px 12px;padding-right:2px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;width: 60px;height: 40px;" value="1"   min="1" max="<%=goods.getGoods_stock()%>" />			
					<label style="font-size: 18px;">件</label>
				<button type="button" class="btn btn-primary btn-lg"
						style="border-radius:0px">立即购买</button>
					<button type="button" class="btn btn-default btn-lg"
						style="border-radius:0px" id="AddCar">加入购物车</button>		
				</p>
			</div>
		</div>
		<div class="col-xs-12 col-sm-12">
			<div class="panel panel-info">
				<div class="panel-heading"
					style=" color: #ffffff;background-color: #5da8ce;border-color: #5da8ce;">
					累计评价 <span class="badge" style="color:#5da8ce;background-color:white">14</span>
				</div>
				<div class="MessageBox" style="margin-top: 10px;">
					<div class="panel-body" style="padding-top: 0px;">
						<div class="panel panel-default" style="margin-bottom: 0px">
							<div class="panel-body" style="padding-bottom: 0px;">
								<ul class="media-list">
									<li class="media">
										<div class="media-left">
											<img src="Img/Aetly.jpg" alt="..." class="img-circle"
												style="width:50%">
										</div>
										<div class="media-body" style="width:85%">
											<h4 class="media-heading">用户名称</h4>
											<p>23333</p>
											<p>
												<span style="float:right">2016-09-07</span>
											</p>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel-body" style="padding-top: 0px;">
						<div class="panel panel-default" style="margin-bottom: 0px">
							<div class="panel-body" style="padding-bottom: 0px;">
								<ul class="media-list">
									<li class="media">
										<div class="media-left">
											<img src="Img/Aetly.jpg" alt="..." class="img-circle"
												style="width:50%">
										</div>
										<div class="media-body" style="width:85%">
											<h4 class="media-heading">用户名称</h4>
											<p>23333</p>
											<p>
												<span style="float:right">2016-09-07</span>
											</p>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel-body" style="padding-top: 0px;">
						<div class="panel panel-default" style="margin-bottom: 0px">
							<div class="panel-body" style="padding-bottom: 0px;">
								<ul class="media-list">
									<li class="media">
										<div class="media-left">
											<img src="Img/Aetly.jpg" alt="..." class="img-circle"
												style="width:50%">
										</div>
										<div class="media-body" style="width:85%">
											<h4 class="media-heading">用户名称</h4>
											<p>23333</p>
											<p>
												<span style="float:right">2016-09-07</span>
											</p>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<button data-toggle="modal" data-target=".bs-example-modal-sm"  id="loginmodal" style="display: none">登录</button>
<jsp:include page="Foot.jsp"  flush="true"/> 
</body>
</html>
