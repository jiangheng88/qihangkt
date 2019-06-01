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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/font/iconfont.css">
<link href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/admin.css" rel="stylesheet">
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/lib/html5shiv/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/lib/respond/Respond.min.js"></script>
      <![endif]-->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>
	<div id="admin_top" class="container-fluid">
		<div class="row">
			<div class="navbar navbar-inverse navbar-static-top">
				<div class="navbar-header col-md-8">
					<span class="navbar-brand"><i
						class="iconfont icon-Windsurfing"></i>启航课堂后台管理页</span>
				</div>
				<div class="col-md-8 col-md-offset-8 login_info text-right">
					<i class="iconfont">&#xe601;</i> admin <i class="iconfont">&#xe71a;</i>
					2018-12-13 <a class="pull-right" href="#"><i class="iconfont ">&#xe615;</i></a>
				</div>
			</div>
		</div>
	</div>
	<div id="sidle_bar">
		<div class="sidlebar_title">
			<p>
				<span>导航模块 / </span> <span>Nav Module</span>
			</p>
		</div>
		<div class="sidlebar_content navbar-fixed-bottom">
			<a href="#collapse_system" data-toggle="collapse"><i
				class="iconfont">&#xe61c;</i>系统设置</a>
			<ul id="collapse_system" class="collapse collapse_all">
				<li><a href=""
					data-iframesrc="${pageContext.request.contextPath}/admin/userManager.html?pageNum=1&pageSize=10"><i
						class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""
					data-iframesrc="${pageContext.request.contextPath}/admin/roleManager.html"><i
						class="iconfont">&#xe605;</i>角色管理</a></li>
				<li><a href=""
					data-iframesrc="${pageContext.request.contextPath}/admin/resManager.html"><i
						class="iconfont">&#xe605;</i>资源管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>系统信息管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>系统备份管理</a></li>
			</ul>
			<a href="#collapse_vedio" data-toggle="collapse"><i
				class="iconfont">&#xe61c;</i>视频管理</a>
			<ul id="collapse_vedio" class="collapse collapse_all">
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
			</ul>
			<a href="#collapse_course" data-toggle="collapse"><i
				class="iconfont">&#xe61c;</i>课程管理</a>
			<ul id="collapse_course" class="collapse collapse_all">
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont &#xe605;">&#xe605;</i>用户管理</a></li>
			</ul>
			<a href="#collapse_res" data-toggle="collapse"><i
				class="iconfont">&#xe61c;</i>资料管理</a>
			<ul id="collapse_res" class="collapse collapse_all">
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont">&#xe605;</i>用户管理</a></li>
				<li><a href=""><i class="iconfont ">&#xe605;</i>用户管理</a></li>
			</ul>
		</div>
	</div>
	<div id="path_nav">
		<ol class="breadcrumb">
			<li><a href="admin.html">后台首页</a></li>
			<li style="color: #337ab7;">系统设置</li>
			<li class="active">系统信息</li>
		</ol>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${pageContext.request.contextPath}/static/lib/jquery/jquery-1.12.4.min.js"></script>
	<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/admin.js"></script>
</body>
</html>