<%@page import="com.zjj.entity.Address"%>
<%@page import="com.zjj.Serviceimpl.AddressServiceImpl"%>
<%@page import="oracle.net.aso.i"%>
<%@page import="com.zjj.entity.OrdersInfo"%>
<%@page import="com.zjj.entity.OrderList"%>
<%@page import="com.zjj.Serviceimpl.OrderServiceImpl"%>
<%@page import="com.zjj.entity.User"%>
<%@page import="com.zjj.Serviceimpl.UserServiceImpl"%>
<%@page import="com.zjj.IService.IUserService"%>
<%@page import="com.zjj.IService.ServiceFactory"%>
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
<link href="css/docs.min.css" rel="stylesheet">
<link href="css/PersonCenterStyle.css" rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="scripts/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<%
		User users = new User();
		String name = session.getAttribute("username").toString();
		IUserService userService = new UserServiceImpl();
		users = userService.getUserInfoByName(name);
%>
<title>易买商城——个人中心</title>

<script type="text/javascript">
	$(function() {
		$("#SaveBtn").click(function() {

			$post();
		});
	});
</script>
<style type="text/css">
	.img-circle{
	border-radius: 50%; 
	 border: 1px solid #dddddd;  
	 padding: 1px; 
	 background-color: white;
	 width:53px;
	 margin-right:10px;
	}
	#ordertab td{
	vertical-align:inherit;
	}
	#addresslisttab td{
	vertical-align:inherit;
	}
</style>
<script type="text/javascript">
	function loginout(){
			$.post("LoginOut",{
					'username':"<%=session.getAttribute("username")%>"
				},function(){
					location.reload();
			 });	
	}
</script>
</head>

<body>
	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav"> <a class="blog-nav-item active"
				href="PersonCenter.jsp" style="font-size:20px;">个人中心</a> <a
				class="blog-nav-item" href="Home.jsp" style="font-size: 20px">商城首页</a> 
					<a class="blog-nav-item "  style="font-size:20px; float:right;cursor: pointer;"  onclick="loginout()">退出</a> 
				</nav>
		</div>
	</div>

	<div class="container" style="margin-top:30px;min-height: 680px;">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-6 col-sm-2 " role="navigation">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<img src="Img/Aetly.jpg" alt="..." class="img-thumbnail">
					</div>

				</div>
			</div>
			<div class="col-xs-12 col-sm-10">
				<div class="blog-header">
					<ul id="myTab" class="nav nav-tabs" role="tablist"
						style="margin-bottom: 15px;">
						<li role="presentation" class="active"><a href="#PersonInfo"
							id="PersonInfo-tab" role="tab" data-toggle="tab"
							aria-controls="PersonInfo" aria-expanded="true">个人资料</a></li>
						<li role="presentation"><a href="#ChangePwd" role="tab"
							id="ChangePwd-tab" data-toggle="tab" aria-controls="ChangePwd">修改密码</a></li>
						<li role="presentation"><a href="#Order" role="tab"
							id="Order-tab" data-toggle="tab" aria-controls="Order">我的订单</a></li>
						<li role="presentation"><a href="#Address" role="tab"
							id="Address-tab" data-toggle="tab" aria-controls="Address">收货地址</a></li>
					</ul>
				</div>
				<div id="myTabContent" class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active"
						id="PersonInfo" aria-labelledBy="PersonInfo-tab">
						<div class="row">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="inputHeadPic" class="col-sm-2 control-label">当前头像</label>
									<div class="col-sm-6">
										<img src="Img/<%=users.getHeadpic()%>" alt="..."
											class="img-thumbnail"> <input type="file"
											name="fileField" id="fileField">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"><%=users.getUsername()%></label>
									<div class="col-sm-6">
										<select
											style="padding:5px; border: 1px solid #cccccc;margin-top: 4px;"
											id="sex_select">
											<option>请选择</option>
											<c:if test="<%=users.getSex() == 0%>">
												<option value="0" selected="selected">先森</option>
												<option value="1">女士</option>
											</c:if>
											<c:if test="<%=users.getSex() == 1%>">
												<option value="0">先森</option>
												<option value="1" selected="selected">女士</option>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group" style="height: 40px">
									<label for="inputbirthday" class="col-sm-2 control-label">出生日期</label>
									<div class="col-sm-6">
										<select
											style="padding:5px; border: 1px solid #cccccc;margin-top: 4px;">
											<option>年</option>
											<%
												for (int i = 1970; i < 2017; i++) {
													out.println("<option>" + i + "</option>");
												}
											%>
										</select> <select
											style="padding:5px; border: 1px solid #cccccc;margin-top: 4px;">
											<option>月</option>
											<%
												for (int i = 1; i < 13; i++) {
													out.println("<option>" + i + "</option>");
												}
											%>
										</select> <select
											style="padding:5px; border: 1px solid #cccccc;margin-top: 4px;">
											<option>日</option>
											<%
												for (int i = 1; i < 30; i++) {
													out.println("<option>" + i + "</option>");
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="inputid" class="col-sm-2 control-label">身份证</label>
									<div class="col-sm-6">
										<input type=text class="form-control" id="inputid"
											placeholder="" value="<%=users.getIdentity()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">电子邮箱</label>
									<div class="col-sm-6">
										<input type="email" class="form-control" id="inputEmail3"
											placeholder="" value="<%=users.getEmail()%>">
									</div>
								</div>
								<div class="form-group">
									<label for="inputphoe" class="col-sm-2 control-label">手机</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputEmail3"
											placeholder="" value="<%=users.getPhone()%>">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-6">
										<button type="button" class="btn btn-info " id="SaveBtn">保存</button>
									</div>
								</div>
							</form>

						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="ChangePwd"
						aria-labelledBy="ChangePwd-tab">
						<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="inputPwd" class="col-sm-2 control-label">当前密码</label>
									<div class="col-sm-6">
											<input type=text class="form-control" id="inputPwd" 	placeholder="请输入当前密码" >
									</div>
								</div>
						</form>
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="inputNewPwd" class="col-sm-2 control-label">新密码</label>
									<div class="col-sm-6">
											<input type=text class="form-control" id="inputNewPwd" 	placeholder="不少于6位数的密码" >
									</div>
								</div>
						</form>
						<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="inputCheckPwd" class="col-sm-2 control-label">确认密码</label>
									<div class="col-sm-6">
											<input type=text class="form-control" id="inputCheckPwd" 	placeholder="确认密码 ">
									</div>
								</div>
						</form>
						<div class="form-group">
									<div class="col-sm-offset-2 col-sm-6" style="padding-left: 0px;">
										<button type="button" class="btn btn-Danger " id="ChangePwdBtn">保存</button>
									</div>
								</div>
					</div>
					
					<div role="tabpanel" class="tab-pane fade" id="Order"
						aria-labelledBy="Order-tab">
						<%
									OrderServiceImpl orderImpl = new OrderServiceImpl();							
									List<OrdersInfo> orderlist = orderImpl.GetOrders(name);							
						 %>
						 <div>
						 <% for(int i = 0;i<orderlist.size();i++) {%>
							<div class="panel panel-info" style="border-radius:0px;">
						  <div class="panel-heading"  style="border-radius:0px;">
						    <h3 class="panel-title"><span><%=orderlist.get(i).getOrdertime() %></span> <span style="margin-left: 10px;">订单编号</span><span><%=orderlist.get(i).getOrder_id()%></span></h3>
						  </div>
						  <div class="panel-body" style="padding: 0px;">
						    		<table class="table table-striped" style="margin-bottom: 0px;" id="ordertab">
						    		<thead>
									<tr>
										<th style="width:20%">信息</th>
										<th style="width:30%">介绍</th>
										<th>单价</th>
										<th>数量</th>
										<th>小计</th>
									</tr>
								</thead>
									      <tbody>
									      <%List<OrderList> orderLists = orderImpl.GetOrdersInfo(name, orderlist.get(i).getOrder_id());%>
									      <% for(int j= 0;j<orderLists.size();j++) {%>
									        <tr>
									          <td><a href="GoodsInfo.jsp?goodsid=<%=orderLists.get(j).getGoodsid()%>"><img alt="" src="Img/<%=orderLists.get(j).getGoodsimg() %>" style="width:75px;"> <%=orderLists.get(j).getGoodsname()%></a></td>
									          <td><%=orderLists.get(j).getGoodsintrouce() %> </td>
									          <td><%=orderLists.get(j).getGoodsprice()%></td>
									          <td><%=orderLists.get(j).getGoodsnum()%></td>
									          <td><%=orderLists.get(j).getGoodsprice()*orderLists.get(j).getGoodsnum() %></td>
									        </tr>		
									        <%} %>				
									      </tbody>
									    </table>
						  </div>
						   <div class="panel-footer" style="overflow: hidden;padding-bottom: 0px;">
						   <p style="float: right;font-size: 16px;">
						   			<span style="margin-right: 15px;" ><label>订单总额</label>￥<label style="color:red"><%=orderlist.get(i).getOrderprice() %></label></span>
									<a href="OrderDetails.jsp?orderid=<%=orderlist.get(i).getOrder_id() %>"  type="button" class="btn btn-default">查看详情</a>
						   </p>   		
							</div>
						</div>
							<%} %>	
							</div>
					</div>	
					<div role="tabpanel" class="tab-pane fade" id="Address"
						aria-labelledBy="Address-tab"><div>
								
								<%AddressServiceImpl aImpl = new AddressServiceImpl();
									 List<Address> addresslist = aImpl.GetAllAddress(name);
								 %>
									 <!-- 添加地址表单 -->
					      		<form class="form-horizontal" role="form" style="margin-bottom: 55px;">
								<div class="form-group">
									<label class="col-sm-2 control-label">所在地区<span style="color:red">*</span></label>
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
									<label for="inputaddressinfo" class="col-sm-2 control-label">详细地址<span style="color:red">*</span></label>
									<div class="col-sm-9">
											<textarea class="form-control" rows="3" id="addressinfo" placeholder="请如实填写收货地址" style="resize: none" id="addressinfo" onfocus="addressinfofun(this)"></textarea>
												<label class="error_is-visible_addressinfo" id="erroraddressinfo"></label>
									</div>
								</div>
								<div class="form-group">
									<label for="inputzipcode" class="col-sm-2 control-label">邮政编码</label>
									<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="不清楚可以不填" id="inputzipcode">
									</div>
								</div>
								<div class="form-group">
									<label for="getusername" class="col-sm-2 control-label">收货人姓名<span style="color:red">*</span></label>
									<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="长度不超过10个字符" id="getusername" onfocus="getusernamefun(this)">
												<label class="error_is-visible_getusername" id="errorgetusername"></label>
									</div>
								</div>
									<div class="form-group">
									<label for="inputphone" class="col-sm-2 control-label">手机号你</label>
									<div class="col-sm-9">
											<input type="text" class="form-control" placeholder="常用手机号" id="inputphone" onfocus="phonefun(this)">
											<label class="error_is-visible_phone" id="errorphone"></label>
									</div>
								</div>
								<div class="form-group">
								<div class="col-sm-offset-2 col-sm-6">
									 <button type="button" class="btn btn-primary"  id="AddAddress">保存</button>     	
								</div>		
					        </div>	
							</form>
							<p style="margin-bottom: 1px;font-size: 22px;">
								<span class="glyphicon glyphicon glyphicon-map-marker " style="padding-right: 5px"></span>全部地址<span class="label label-danger" style=" position: relative; left: 5px; bottom: 5px;padding-top: 0px;	"><span id="addressnum"><%=addresslist.size() %> </span></span>		
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
							<table class="table table-bordered"  id="addresslisttab" style="font-size: 15px;">
									<thead>
										<tr style=" background: #ca5959;border: none; color: white;">
										<th style="width:13%">收货人</th>
										<th style="width:17%">所在地区</th>
										<th>详细地址</th>
										<th style="width:12%">邮编</th>
										<th style="width:14%">号码</th>
										<th style="width:12%">操作</th>
									</tr>
									</thead>
									<tbody>
									<%for(int i =0;i<addresslist.size();i++) {%>			
										<tr>
											<td><span><%=addresslist.get(i).getGet_username() %></span></td>
											<td><span><%=addresslist.get(i).getProvince() %></span><span><%=addresslist.get(i).getCity() %></span><span><%=addresslist.get(i).getArea() %></span> </td>
											<td><span><%=addresslist.get(i).getAddress_info()%></span></td>	
											<td><span><%=addresslist.get(i).getZipcode()%></span></td>
											<td><span><%=addresslist.get(i).getPhone() %></span></td>	
											<td><a href="#" style="text-decoration: none">修改</a>| <a href="#"  style="text-decoration: none">删除</a> </td>
										</tr>
										<%} %>
									</tbody>
							</table>
						</div>						
					</div>		
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
<jsp:include page="Foot.jsp"  flush="true"/> 
</body>
</html>
