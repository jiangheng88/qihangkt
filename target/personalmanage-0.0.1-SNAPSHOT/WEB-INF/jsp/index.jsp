<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>起航课堂首页</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet">



<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/lib/html5shiv/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/lib/respond/Respond.min.js"></script>
      <![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/font/iconfont.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>
	<nav id="id_nav" class="navbar navbar-default navbar-static-top">
		<div class="content">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>

				</button>

				<a class="navbar-brand" href="#">起航课堂</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.html">首页</a></li>
					<li><a href="">全部课程</a></li>
					<li><a href="">问题讨论</a></li>
					<li><a href="">学习路线</a></li>
					<li><a href="">资料下载</a></li>

				</ul>
				<div class="navbar-form navbar-left hidden-md hidden-sm">
					<form action="#" method="get">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="请输入课程名……">
							<span class="input-group-btn">
								<button type="button" class="btn btn-primary">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>

					</form>
				</div>
				<ul class=" nav navbar-nav navbar-right hidden-sm">
					<li><a href="login.html#register"><span
							class="glyphicon glyphicon-user"></span> 注册</a></li>
					<li><a href="login.html#login"><span
							class="glyphicon glyphicon-log-in"> </span> 登录</a></li>
				</ul>
			</div>

		</div>

	</nav>

	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active"
				data-lg-img="${pageContext.request.contextPath}/static/img/slide_01_2000x410.jpg"
				data-xs-img="${pageContext.request.contextPath}/static/img/slide_01_768x410.jpg"></div>
			<div class="item"
				data-lg-img="${pageContext.request.contextPath}/static/img/slide_02_2000x410.jpg"
				data-xs-img="${pageContext.request.contextPath}/static/img/slide_02_768x410.jpg"></div>
			<div class="item"
				data-lg-img="${pageContext.request.contextPath}/static/img/slide_03_2000x410.jpg"
				data-xs-img="${pageContext.request.contextPath}/static/img/slide_0_768x410.jpg"></div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">
			<span _ngcontent-c3="" aria-hidden="true"
			class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="carousel-control right" href="#myCarousel"
			data-slide="next"><span _ngcontent-c3="" aria-hidden="true"
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
	<div class="container" id="courseList">
		<div class="page-header">
			<h3 class="text-center">
				最新课程<a href="#">全部课程<span class="iconfont">&#xe661;</span></a>
			</h3>
		</div>
		<div class="row">
			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>


			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>


			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>

					</p>
				</div>
			</div>
		</div>
		<div class="page-header">
			<h3 class="text-center">
				javaee课程<a href="#">全部课程<span class="iconfont">&#xe661;</span></a>
			</h3>
		</div>
		<div class="row">
			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>


			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>


			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>

					</p>
				</div>
			</div>
		</div>
		<div class="page-header">
			<h3 class="text-center">
				javase课程<a href="#">全部课程<span class="iconfont">&#xe661;</span></a>
			</h3>
		</div>
		<div class="row">
			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>


			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>
					</p>
				</div>
			</div>


			<div class="col-lg-6 col-xs-12">
				<a href="#" class="thumbnail"> <img
					src="${pageContext.request.contextPath}/static/img/jvm.jpg"
					alt="起航课堂">
				</a>
				<div class="caption">
					<h3>
						<a href="#">JVM课程</a> <span>￥50</span>
					</h3>
					<p>如果你喜欢就赶紧拍下吧</p>
					<p>
						<a href="#" class="btn btn-primary" role="button"> 购买 </a>

					</p>
				</div>
			</div>
		</div>
	</div>

	<div class="footer hidden-xs">
		<div class="footericon">
			<span class="iconfont icon-Windsurfing"></span>
		</div>
		<p class="cr">Copyright © 2018 qihangzaixian. All Rights Reserved.</p>
		<p class="cr">
			启航在线课程 版权所有 | <a href="#">工具下载</a> | <a href="#">资料下载</a> | <a
				href="#">视频下载</a> | <a href="#">问题反馈</a> | <a href="#">帮助</a>
		</p>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="${pageContext.request.contextPath}/static/lib/jquery/jquery-1.12.4.min.js"></script>
	<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/index.js"></script>
</body>
</html>