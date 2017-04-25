<%@page import="com.zjj.Serviceimpl.ShoppingCarImpl"%>
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
<link href="css/HomeStyle.css" rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="scripts/bootstrap.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<title>易买商城——首页</title>

<% 
		String uname =(String)session.getAttribute("username");
		int GoodsNumbers = -1;
		if(uname == null){
			 uname = "0";
			 GoodsNumbers = 0;
		}else {
			uname =(String)session.getAttribute("username");	
			ShoppingCarImpl shoImpl = new ShoppingCarImpl();
			GoodsNumbers=shoImpl.GetGoodsNumberByUser(uname);
		}	
		
%>

<script type="text/javascript">
	$(function() {
		$("#SearchBtn").click(function() {
			window.location.href = "Search.jsp";
		});
	});
	
	function AddToCar(goodsid){
		if("<%=uname%>" !="0"){
					var userid ="<%=uname%>";
					var goodsprice = $("#goodspricelbl").html();
					var goods_subtotal= goodsprice * 1;
					$.post("ShopCarList", {
						'username':userid,
						'goodsid':goodsid,	
						'num':1,
						'goods_subtotal':goods_subtotal
					},function(data){
						if(data == 1){
							alert("添加成功！");
							  $("#goodsnum").load(location.href+" #goodsnum");//局部刷新tab
						}else{
							alert("添加失败！");
						}
					});
			}else{
				window.location.href = "Login.jsp";
			}			 	
	};
	

</script>
</head>


<body data-spy="scroll" data-target="#navbar-example" data-offset="0" style="padding-top: 51px;">
	<jsp:include page="Top.jsp"  flush="true"/> 
	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right"  style="min-height: 360px;">
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">导航</button>
				</p>

				<ul id="myTab" class="nav nav-tabs" role="tablist"
					style="margin-bottom: 15px;">
					<li role="presentation" class="active"><a href="#NewGoods"
						id="NewGoods-tab" role="tab" data-toggle="tab"
						aria-controls="NewGoods" aria-expanded="true"
						style=" color: white;background-color: #428bca;">最新商品<span
							class="badge"
							style=" background-color: white; color: #428bca; margin-left: 5px">42</span></a></li>
					<li role="presentation"><a href="#HotGoods" role="tab"
						id="HotGoods-tab" data-toggle="tab" aria-controls="HotGoods"
						style="color: white;background-color: #e44040;">热卖中<span
							class="badge"
							style="background-color: white;color:red;margin-left: 5px">15</span></a></li>
					<li role="presentation"  ><a href="ShopCar.jsp" >我的购物车
					 <span class="badge" ><label id="goodsnum" style="margin-bottom: 0px;"> <%=GoodsNumbers%></label></span></a></li>				
					<div class="input-group">
						<input type="text" class="form-control" placeholder="联想小新笔记本">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="Search()"
								id="SearchBtn">搜索</button>
						</span>
					</div>
				</ul>

				<div id="myTabContent" class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="NewGoods"
						aria-labelledBy="NewGoods-tab">
						<div class="row">
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/1.jpg"
									alt="...">
								</a>
							</div>
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/1.jpg"
									alt="...">
								</a>
							</div>
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/1.jpg"
									alt="...">
								</a>
							</div>
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/1.jpg"
									alt="...">
								</a>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="HotGoods"
						aria-labelledBy="HotGoods-tab">
						<div class="row">
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/2.jpg"
									alt="...">
								</a>
							</div>
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/2.jpg"
									alt="...">
								</a>
							</div>
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/2.jpg"
									alt="...">
								</a>
							</div>
							<div class="col-xs-6 col-md-3">
								<a href="#" class="thumbnail"> <img src="Img/2.jpg"
									alt="...">
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"role="navigation">
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-primary">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne" aria-expanded="true"
										aria-controls="collapseOne"> 商品种类一 </a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in"
								role="tabpanel" aria-labelledby="headingOne">
								<ul class="list-group">
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-primary">
							<div class="panel-heading" role="tab" id="headingTwo">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo"> 商品种类二 </a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingTwo">
								<ul class="list-group">
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-primary">
							<div class="panel-heading" role="tab" id="headingThree">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree"> 商品种类三
									</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingThree">
								<ul class="list-group">
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
									<li class="list-group-item"><a>子类别</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
		
			<!--/.sidebar-offcanvas-->
		</div>
		<p style="margin-bottom: 1px;font-size: 22px;">
			<span class="glyphicon glyphicon-home" style="padding-right: 5px"></span>全部商品
		</p>
		<div class="progress"
			style="  margin-bottom: 20px;margin-top: 0px;height: 1px;">
			<div class="progress-bar progress-bar-info" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-danger" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-warning " style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-success" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-info" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-danger" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-warning " style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-success" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-warning " style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
			<div class="progress-bar progress-bar-success" style="width: 10%">
				<span class="sr-only">10%</span>
			</div>
		</div>
		<div class="col-xs-12 col-sm-12">
			<!-- <h4 id="Clothes">服饰</h4> -->
			<!-- 商品列表 -->
			<div class="row">
				<c:forEach var="Good" items="${requestScope.goodslist}">
					<div class="col-sm-6 col-md-3">
						<div class="thumbnail" style="text-decoration: none;color:black">
							<img src="Img/${Good.goodsimg}" style="width: 220px;height: 220px;">
							<h3>
								<span><c:out value="${Good.goodsname}"></c:out></span>
							</h3>
							<p style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">		
								<c:out value="${Good.goodsintroduce}"></c:out>
							</p>
							<p>
								<span style="color: red;  font-size: 20px;" id="spanid">￥<label id="goodspricelbl"><c:out value="${Good.goodsprice}"></c:out></label></span>
							</p>	
							 <p>
							 <a href="GoodsInfo.jsp?goodsid=${Good.goodsid}" class="btn btn-default" role="button">查看详情</a>
							  <button class="btn btn-primary"   id="AddCar"  onclick="AddToCar(${Good.goodsid})" >加入购物车</button>
							  </p>
						</div>
					</div>
				</c:forEach>
			</div>
			<!--/row-->
		</div>

		<hr>
		<!--/.container-->
	</div>
	<jsp:include page="Foot.jsp"  flush="true"/> 
	<script type="text/javascript">
		$(document).ready(function() {
			$('[data-toggle="offcanvas"]').click(function() {
				$('.row-offcanvas').toggleClass('active')
			});
		});
	</script>
</body>
</html>
