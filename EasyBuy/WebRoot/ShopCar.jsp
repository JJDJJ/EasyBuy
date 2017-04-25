<%@page import="com.zjj.entity.ShoppingCar"%>
<%@page import="com.zjj.Serviceimpl.ShoppingCarImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


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

<%
		session.removeAttribute("carlist");
 		double allprice = 0;
		String name = session.getAttribute("username").toString();	
		ShoppingCarImpl shoImpl = new ShoppingCarImpl();
		List<ShoppingCar> CarList = shoImpl.GetGoodsByUser(name);
%>

<title>易买商城——购物车</title>
<style type="text/css">
#CarTab td {
	vertical-align: inherit;
}
</style>
<script type="text/javascript">


function DeleteGoods(goodsid){
    var goods = goodsid;
    var uid = "<%=name%>";
    	if(goods!=0){	
    		$.post("DeleteGoods",{
    			'username' : uid,
    			'goodsid' : goods
    		},function(data,XMLStatus){
    			  $("#CarTab").load(location.href+" #CarTab");//局部刷新tab	  
    			  $("#numlbl").load(location.href+" #numlbl");	  
    			  $("#lblallprice").load(location.href+" #lblallprice");	
    		});
    	}else {
    		alert("请选择商品");
    	}
    	
    }
    
  function confirmOrder(allprice){
		  		$.post("ConfirmOrder",{
		  			'allprice':allprice,
		  		},function(data){
		  			if(data ==1){
		  				window.location.href="CheckOrder.jsp";
		  			}
		  		});		
 }
</script>
</head>

<body style="padding-top: 51px;">

	<jsp:include page="Top.jsp" flush="true" />
	<div class="container ">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="row" style="margin-bottom: 30px;">
				<div class="col-lg-4">
					<div class="TextBox">
						<img alt="" src="Img/favicon.jpg"> <span
							style="font-family: '微软雅黑';font-size: 22px;color: #38b6e6;">购物车</span><span
							class="glyphicon glyphicon-shopping-cart"
							style="font-size: 20px;color: #37b6df;"></span>
					</div>
				</div>
			</div>
			<div class="row" id="carlist">
				<div class="col-lg-12">
					<div class="panel panel-success"
						style="border-color:#38b6e6;border-radius:0px;">
						<div class="panel-heading"
							style="background-color: #38b6e6;border-color: #38b6e6;border-radius:0px">
							<h3 class="panel-title" style="color:white">
								全部商品 <span style="padding-left: 5px;"><span class="badge"
									style=" color: #38b6e6;background-color: #ffffff; font-size: 15px"><label
										id="numlbl" style="margin-bottom: 0px;"><%=CarList.size()%></label></span></span>
							</h3>
						</div>
						<div class="panel-body"
							style="min-height: 390px;padding-left: 0px;padding-right: 0px;">
							<table class="table table-hover" style="margin-bottom: 0px;"
								id="CarTab">
								<thead>
									<tr>
										<th style="width:17%">商品信息</th>
										<th style="width:30%">介绍</th>
										<th>单价</th>
										<th>数量</th>
										<th>金额</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < CarList.size(); i++) {
									%>
									<tr>
										<td><a
											href="GoodsInfo.jsp?goodsid=<%=CarList.get(i).getGoods_id()%>"><img
												alt="商品图片" src="Img/<%=CarList.get(i).getGoods_img()%>"
												style="width:80px;"><span><%=CarList.get(i).getGoodsname()%></span></a></td>
										<td><span
											style=" display: -webkit-box;-webkit-box-orient: vertical; -webkit-line-clamp: 3;overflow: hidden;"><%=CarList.get(i).getGoods_introduce()%></span></td>
										<td><span>￥</span><span id="goodsprice"><%=CarList.get(i).getGoods_money()%></span></td>
										<td>
											<!-- <input type="number"  id="goodsnuminput"  value="" min="1" max=""  onchange="ChangeGoodsNum()"  />  	 -->
											<span><%=CarList.get(i).getGoods_num()%></span>
										</td>
										<td><span>￥</span><span id="goodsmoney"><%=CarList.get(i).getGoods_subtotal()%></span></td>
										<td><a href="#"
											onclick="DeleteGoods(<%=CarList.get(i).getGoods_id()%>)">删除</a></td>
									</tr>
									<%
										allprice += CarList.get(i).getGoods_subtotal();
										}
									%>
								</tbody>

							</table>
						</div>
						<div class="panel-footer"
							style="background-color: #38b6e6;border-color: #38b6e6;border-radius:0px;overflow:hidden">
							<div class="col-md-9"></div>
							<div class="col-md-3" style="padding-right: 0px;">
								<span
									style="color:white;font-size:20px;position: relative;top: 4px;">
									<span>合计：</span> <span>￥ <label id="lblallprice"><%=allprice%></label></span><span></span>
								</span>
								<button type="button" class="btn btn-danger"
									style="float: right;border-radius:0px"
									onclick="confirmOrder(<%=allprice%>)">结算</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Foot.jsp" flush="true" />
</body>
</html>
