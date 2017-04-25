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
<link href="css/docs.min.css" rel="stylesheet">
<link href="http://v3.bootcss.com/examples/carousel/carousel.css" rel="stylesheet">
<link href="css/SearchStyle.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<title>易买商城——商品</title>

</head>

<body style="padding-top: 51px;">
	<jsp:include page="Top.jsp"  flush="true"/> 
	
	<div class="container marketing">
		<div class="row">
			<div class="col-lg-4">
				<div class="TextBox">
					<img alt="" src="Img/favicon.jpg"> <span
						style="font-family: '微软雅黑';font-size: 18px;color: #38b6e6;">EasyBuy.com</span>
				</div>
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-lg-6" style="margin-top: 7px;">
				<div class="input-group">
					<input type="text" class="form-control"> <span
						class="input-group-btn" placeholder="裤子">
						<button class="btn btn-default" type="button">搜索</button>
					</span>
				</div>
				<ul class="searchstyle">
					<li><a>休闲裤男</a></li>
					<li><a>运动裤男</a></li>
					<li><a>短裤男</a></li>
					<li><a>休闲裤女</a></li>
					<li><a>运动裤女</a></li>
					<li style="border: none"><a>短裤</a></li>
				</ul>
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->
		<div class="progress"
			style="  margin-bottom: 20px;margin-top: 20px;height: 2px;">
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
		<ol class="breadcrumb">
			<li><a href="#">全部</a></li>
			<li><a href="#">一级类别</a></li>
			<li class="active">二级类别</li>
		</ol>
		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				role="navigation">
				<div class="list-group">
					<a href="#" class="list-group-item active">全部商品分类</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a>
				</div>
			</div>
			<div class="col-xs-12 col-sm-9">
				<!-- 商品列表 -->
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="Img/2.jpg" alt="...">
							<div class="caption">
								<h3>
									<span>商品2</span>
								</h3>
								<p>...</p>
								<p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
							</div>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="Img/1.jpg" alt="...">
							<div class="caption">
								<h3>
									<span>商品1</span>
								</h3>
								<p>...</p>
								<p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
							</div>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="Img/2.jpg" alt="...">
							<div class="caption">
								<h3>
									<span>商品2</span>
								</h3>
								<p>...</p>
								<p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
							</div>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="Img/1.jpg" alt="...">
							<div class="caption">
								<h3>
									<span>商品1</span>
								</h3>
								<p>...</p>
								<p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
							</div>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="Img/2.jpg" alt="...">
							<div class="caption">
								<h3>
									<span>商品2</span>
								</h3>
								<p>...</p>
								<p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
							</div>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="Img/1.jpg" alt="...">
							<div class="caption">
								<h3>
									<span>商品1</span>
								</h3>
								<p>...</p>
								<p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
							</div>
						</div>
					</div>
					<!--/.col-xs-6.col-lg-4-->
				</div>
				<!--/row-->
			</div>
		</div>
		<div class="progress"
			style="  margin-bottom: 20px;margin-top: 20px;height: 2px;">
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
			<!-- 商品列表 -->
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="Img/2.jpg" alt="...">
						<div class="caption">
							<h3>
								<span>商品2</span>
							</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div>
				<!--/.col-xs-6.col-lg-4-->
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="Img/1.jpg" alt="...">
						<div class="caption">
							<h3>
								<span>商品1</span>
							</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div>
				<!--/.col-xs-6.col-lg-4-->
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="Img/2.jpg" alt="...">
						<div class="caption">
							<h3>
								<span>商品2</span>
							</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div>
				<!--/.col-xs-6.col-lg-4-->
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="Img/1.jpg" alt="...">
						<div class="caption">
							<h3>
								<span>商品1</span>
							</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div>
				<!--/.col-xs-6.col-lg-4-->
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="Img/2.jpg" alt="...">
						<div class="caption">
							<h3>
								<span>商品2</span>
							</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div>
				<!--/.col-xs-6.col-lg-4-->
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="Img/1.jpg" alt="...">
						<div class="caption">
							<h3>
								<span>商品1</span>
							</h3>
							<p>...</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">Button</a> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
						</div>
					</div>
				</div>
				<!--/.col-xs-6.col-lg-4-->
			</div>
			<!--/row-->
		</div>



	</div>

	<!-- /.container -->
	<div class="progress"
		style="  margin-bottom: 20px;margin-top: 20px;height: 2px;">
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
	<!-- FOOTER -->
	<jsp:include page="Foot.jsp"  flush="true"/> 
</body>
</html>
