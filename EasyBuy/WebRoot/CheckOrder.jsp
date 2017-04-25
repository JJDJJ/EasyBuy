<%@page import="com.zjj.Serviceimpl.AddressServiceImpl"%>
<%@page import="com.zjj.entity.Address"%>
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
 		double allprice = 0;
 	//	Address address = null;
 	//	int addressid =Integer.parseInt(session.getAttribute("address").toString());	
 	//    int defaultaddressid=	Integer.parseInt(session.getAttribute("address").toString());
		List<ShoppingCar> orderlist = (ArrayList<ShoppingCar>) session.getAttribute("carlist");
		String name = session.getAttribute("username").toString();	
		AddressServiceImpl aImpl = new AddressServiceImpl();
		List<Address> addresslist = 	aImpl.GetAllAddress(name);
//		if(addressid != 0){
//			address = aImpl.GetAddressByID(addressid);
//		}else {
//			address = aImpl.GetAddressByID(defaultaddressid);
//		}
		 
%>

<title>确认订单——易买商城</title>

<style type="text/css">

a.thumbnail:link,a.thumbnail:visited a.thumbnail:hover,a.thumbnail:focus,a.thumbnail:active{
	text-decoration:none;
	border-color: red;
	cursor: pointer;
}
.error_is-visible_addressinfo {
	color: red;
	opacity: 1;
	margin-bottom: 0px;
	visibility: visible;
	position: absolute;
	top: 47px;
	right: 28px;
	line-height: 17px;
	font-weight: 500;
	font-family: Arial;
	padding-right: 5px;
	padding-left: 5px;
}

.error_is-visible_getusername {
	color: red;
	opacity: 1;
	margin-bottom: 0px;
	visibility: visible;
	position: absolute;
	top: 9px;
	right: 28px;
	line-height: 17px;
	font-weight: 500;
	font-family: Arial;
	padding-right: 5px;
	padding-left: 5px;
}

.error_is-visible_phone {
	color: red;
	opacity: 1;
	margin-bottom: 0px;
	visibility: visible;
	position: absolute;
	top: 9px;
	right: 28px;
	line-height: 17px;
	font-weight: 500;
	font-family: Arial;
	padding-right: 5px;
	padding-left: 5px;
}


</style>



<script type="text/javascript">
	function addressinfofun(){
			$("#erroraddressinfo").html("");
	}
	
	function getusernamefun(){
			$("#errorgetusername").html("");
	}
	
	function phonefun(){
			$("#errorphone").html("");	
	}

	$(function(){
		$("#AddAddress").click(function(){
			var addressinfo = $("#addressinfo"); //地址详情
			var zipcode = $("#inputzipcode"); //邮政编码
			var getusername = $("#getusername"); //收货人
			var phone = $("#inputphone"); //手机号码
			if(addressinfo.val()!="" && getusername.val()!="" && phone.val()!="" ){
				$.post("Addaddress",{
					
				},function(data,XMLStatus){
					if(data ==1){
						alert("添加成功！");
					}else{
						alert("添加失败！错误代码：" +XMLStatus.status); 
					}
				});
			}else{
				if(addressinfo.val() == ""){
					$("#erroraddressinfo").html("请填写收货地址");
				}if(getusername.val()== "" ){
					$("#errorgetusername").html("请填写收货人");
				}if(phone.val()== ""){
					$("#errorphone").html("请填写手机号码");
				}
			}
		});
	});
	





	function UpdateAddress() {
		alert("修改地址");
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
							style="font-family: '微软雅黑';font-size: 22px;color: #38b6e6;">确认订单</span>
						<span class="glyphicon glyphicon glyphicon-edit"
							style="font-size: 20px;color: #37b6df;"></span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
		       <label style="font-family: 'inherit' ;font-size: 16px; display: block;">选择收货地址</label>
				<%for(int i = 0;i<addresslist.size();i++) {%>
					<div class="col-xs-6 col-md-3">
						<div  class="thumbnail" style="font-size: 16px;font-family: '宋体' "> 		
							<p><label id="Provincelbl"><%=addresslist.get(i).getProvince() %></label>&nbsp;<label id="Citylbl"><%=addresslist.get(i).getCity() %></label>（<label id="GetUserlbl"><%=addresslist.get(i).getGet_username()%></label>）收</p>
							<p id="addressinfo_p"><%=addresslist.get(i).getAddress_info() %></p>
							<p style="margin: 0px;">
							<button type="button" class="btn btn-success" onclick="choseaddress(<%=addresslist.get(i).getId()%>)">选定</button>
							<button  type="button" class="btn btn-danger"   style="border-radius:2px" onclick="UpdateAddress()">修改</button></p>
						</div>				
					</div>
					<%  } %>	
				</div>
				<div class="col-lg-12">
				<div class="col-xs-6 col-md-3">
				   <button type="button"  data-toggle="modal" data-target="#myModal" class="btn btn-default" >添加地址</button>
		<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog" style="margin-top: 200px;">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					        <h4 class="modal-title" id="myModalLabel">添加地址</h4>
					      </div>
					      <div class="modal-body">
					      <!-- 添加地址表单 -->
					      		<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label">所在地区<span style="color:red">*</span></label>
									<div class="col-sm-9">
										<select>
											<option>江苏</option>
										</select>
										<select>
											<option>镇江</option>
										</select>
										<select>
											<option>润州区</option>
										</select>
									</div>
								</div>														
								<div class="form-group">
									<label for="inputaddressinfo" class="col-sm-3 control-label">详细地址<span style="color:red">*</span></label>
									<div class="col-sm-9">
											<textarea class="form-control" rows="3" id="addressinfo" placeholder="请如实填写收货地址" style="resize: none" id="addressinfo" onfocus="addressinfofun(this)"></textarea>
												<label class="error_is-visible_addressinfo" id="erroraddressinfo"></label>
									</div>
								</div>
								<div class="form-group">
									<label for="inputzipcode" class="col-sm-3 control-label">邮政编码</label>
									<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="不清楚可以不填" id="inputzipcode">
									</div>
								</div>
								<div class="form-group">
									<label for="getusername" class="col-sm-3 control-label">收货人姓名<span style="color:red">*</span></label>
									<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="长度不超过10个字符" id="getusername" onfocus="getusernamefun(this)">
												<label class="error_is-visible_getusername" id="errorgetusername"></label>
									</div>
								</div>
									<div class="form-group">
									<label for="inputphone" class="col-sm-3 control-label">手机号你</label>
									<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="常用手机号" id="inputphone" onfocus="phonefun(this)">
											<label class="error_is-visible_phone" id="errorphone"></label>
									</div>
								</div>
							</form>
					      </div>
					      <div class="modal-footer">
					       <button type="button" class="btn btn-primary"  id="AddAddress">确认添加</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>				       
					      </div>
					    </div>
					  </div>
					</div>
				   
				   <a href="PersonCenter.jsp" type="button" class="btn btn-primary" >管理地址</a>
				</div>
				</div>
			</div>
		</div>
		<div class="row row-offcanvas row-offcanvas-right" style="margin-top: 20px;">
		<label style="font-family: 'inherit' ;font-size: 16px; display: block;">确认订单信息</label>
				<div class="col-lg-12">
					<div class="panel panel-success"
						style="border-color:#3fc5a1;border-radius:0px;">
						<div class="panel-heading" style="background-color: #3fc5a1;border-color: #3fc5a1;border-radius:0px">			
								<span class="glyphicon glyphicon-file" style="  font-size: 20px; color: white;	"></span>
						</div>
						<div class="panel-body"
							style="min-height: 390px;padding-left: 0px;padding-right: 0px;">
							<table class="table" style="margin-bottom: 0px;"  id="CarTab">				
								<thead>
									<tr>
										<th style="width:17%">商品信息</th>
										<th style="width:30%">介绍</th>
										<th>单价</th>
										<th>数量</th>
										<th>小计</th>
									</tr>
								</thead>
								<tbody>
									<%for (int i = 0; i < orderlist.size(); i++) {%>							
									<tr>
										<td><a href="GoodsInfo.jsp?goodsid=<%=orderlist.get(i).getGoods_id()%>"><img alt="商品图片" src="Img/<%=orderlist.get(i).getGoods_img()%>"
												style="width:80px;"><span><%=orderlist.get(i).getGoodsname()%></span></a></td>
										<td><span style=" display: -webkit-box;-webkit-box-orient: vertical; -webkit-line-clamp: 3;overflow: hidden;"><%=orderlist.get(i).getGoods_introduce()%></span></td>
										<td><span>￥</span><span id="goodsprice"><%=orderlist.get(i).getGoods_money()%></span></td>
										<td>
										<!--<input type="number"  id="goodsnuminput"  value="" min="1" max=""  onchange="ChangeGoodsNum()"  />  -->																		
												<span><%=orderlist.get(i).getGoods_num()%></span>
										 </td>
										<td><span>￥</span><span id="goodsmoney"><%=orderlist.get(i).getGoods_subtotal()%></span></td>								
									</tr>
									<%allprice+=orderlist.get(i).getGoods_subtotal();}%>										
								</tbody>
									
							</table>						
						</div>		
						<div class="panel-footer" style="background-color: #3fc5a1;border-color: #3fc5a1;border-radius:0px;overflow:hidden">		
							<div class="col-md-9"></div>
							<div class="col-md-3" style="padding-right: 0px;">
								<span
									style="color:white;font-size:20px;position: relative;top: 4px;">
									<span>合计：</span> <span>￥</span><label id="lblallprice" style="color:white"><%=allprice%></label>
								</span>
							</div>
						</div>	
					</div>
				</div>
			
	</div>
		<div class="row row-offcanvas row-offcanvas-right">
					 <div class="col-xs-6 col-md-3" style="float:right;">
						<div class="thumbnail" style="font-size: 16px;font-family: '宋体';border-radius: 0px;color: #5a5a5f;border: 2px solid #d9534f;margin-bottom: 0px;padding-top: 10px;" id="AddressTab"> 		
							<p><label>实付款：</label><label style="font-family: ' 微软雅黑 ' ">￥</label><label style="color:red;font-size: 25px;"><%=allprice%></label></p>
							<p><label>寄送至：</label><label  id="checkaddressinfo">xx</label></p>
							<p><label>收件人：</label><label id="checkgetuser">xx</label></p>
						</div>			
							<a type="button"  class="btn btn-default" 	style="border-radius:0px;position: relative; left:68px;" href="ShopCar.jsp"><span class="glyphicon glyphicon-arrow-left"></span> 返回购物车</a>		
							<button type="button" class="btn btn-danger" 	style="float: right;border-radius:0px;"  id="SubmitOrder">提交订单</button>		
					</div>
		</div>
	</div>
	
	<jsp:include page="Foot.jsp" flush="true" />
</body>
</html>
