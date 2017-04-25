<%@page import="com.zjj.entity.OrderList"%>
<%@page import="com.zjj.Serviceimpl.OrderServiceImpl"%>
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

<style type="text/css">
	#ordertab td{
	vertical-align:inherit;
	}
</style>


<title>订单详情——易买商城</title>

<%	
		String uname =(String)session.getAttribute("username");
		String orderid = request.getParameter("orderid");
		OrderServiceImpl orImpl = new OrderServiceImpl();
		OrderList orderinfo = orImpl.GetOrdersInfoByID(uname,orderid);
 %>

  </head>
  
  <body style="padding-top: 51px;">
    		 <jsp:include page="Top.jsp"  flush="true"/>
    		 	<div class="container" style="min-height: 680px;">
    		 		<div class="col-xs-12 col-sm-12" style="margin-bottom: 50px;">
    		 		<div class="col-lg-4">
					<div class="TextBox">
						<img alt="" src="Img/favicon.jpg"> <span
							style="font-family: '微软雅黑';font-size: 22px;color: #38b6e6;">订单详情</span>
						<span class="glyphicon glyphicon-tags"
							style="font-size: 20px;color: #37b6df;"></span>
					</div>
				</div>
    		 	</div>
    		 	<div class="col-xs-12 col-sm-12" >
	    		 	<div class="col-lg-12">
	    		 			<div class="panel panel-info" style="border-radius:0px;border-color: #45bdca;">
							  <div class="panel-heading" style="border-radius:0px;padding-left: 5px;color: white;background-color: #45bdca;">
							    <h3 class="panel-title">订单信息</h3>
							  </div>
							  <div class="col-lg-12" style="margin-top: 10px;margin-bottom: 10px;">
								  <h4><label style="font-size: 15px;">收货地址：</label> <small><%=orderinfo.getGetusername() %>,<%=orderinfo.getPhone()%>,<%=orderinfo.getProvince()%>&nbsp;<%=orderinfo.getCity()%>&nbsp;<%=orderinfo.getArea()%>&nbsp;<%=orderinfo.getAddressinfo()%>,<%=orderinfo.getZipcode()%></small></h4>
								  <h4><label style="font-size: 15px;">订单信息：</label> <small><span>订单编号：</span><span><%=orderinfo.getOrder_id() %></span>&nbsp;&nbsp;<span>创建时间：</span><span><%=orderinfo.getOrdertime() %></span></small>&nbsp;&nbsp;<span class="label label-default" style="font-family: '宋体' ;padding: 8px;"><%=orderinfo.getPaystatus() %></span></h4>
							  </div>
							  <div class="panel-body" style="margin-top: 30x;">
							   	<table class="table table-bordered" style="margin-bottom: 0px;" id="ordertab">
						    		<thead>
									<tr style="color:white;background-color: #319bd0">
										<th style="width:20%">商品信息</th>
										<th style="width:30%">介绍</th>
										<th>单价</th>
										<th>数量</th>
										<th>商品总价</th>
									</tr>
								</thead>
									      <tbody>				
									      <%  List<OrderList> orderLists = orImpl.GetOrdersInfo(uname, orderid);
									 			   for(int i = 0;i<orderLists.size();i++){ 	     
									      %>
									        <tr>
									          <td><a href="GoodsInfo.jsp?goodsid=<%=orderLists.get(i).getGoodsid()%>"><img alt="" src="Img/<%=orderLists.get(i).getGoodsimg() %>" style="width:75px;"> <%=orderLists.get(i).getGoodsname()%></a></td>
									          <td><%=orderLists.get(i).getGoodsintrouce()%></td>
									          <td><%=orderLists.get(i).getGoodsprice()%></td>
									          <td><%=orderLists.get(i).getGoodsnum()%></td>
									          <td><%=orderLists.get(i).getGoodsprice()*orderLists.get(i).getGoodsnum() %></td>
									        </tr>		
									        <%} %>						      			
									      </tbody>	        
									    </table>
							  </div>
							 		 <div class="panel-footer" style="overflow: hidden;padding-bottom: 0px;background-color: #dcdcdc;">
											   <p style="float: right;font-size: 16px;">
											   			<span style="margin-right: 14px;font-size: 14px;" ><label style="font-weight: 700;font-size: 16px;margin-right: 5px;font-family: '宋体'">订单总额:</label><label style="color:red;font-size: 18px;margin-right: 5px"><%=orderinfo.getOrderprice()%></label>元</span>	
											   </p>   		
									</div>
							</div>
					</div>			
    		 	</div>
    		 	</div>
    		 <jsp:include page="Foot.jsp"  flush="true"/> 
  </body>
</html>
