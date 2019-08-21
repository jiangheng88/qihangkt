<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->


<title>登录注册页面</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/font/iconfont.css">
<link href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/lib/html5shiv/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/lib/respond/Respond.min.js"></script>
      <![endif]-->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css">
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
							class="glyphicon glyphicon-log-in"></span> 登录</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="id_login" class="container">
		<div class="row">
			<div class="col-md-7 col-xs-5"></div>

			<div class="col-md-10 col-xs-14 data-login">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active col-xs-12"><a href="#login"
						data-toggle="tab" class="data-login"> 登录 </a></li>
					<li class="col-xs-12"><a href="#register" data-toggle="tab"
						class="data-login">注册</a></li>

				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="login">
						<form role="form" action="${pageContext.request.contextPath}/dologin" method="POST">
							<div class="form-group">
								<label for="name">账号:</label> <input name = "userInfo" type="text"
									class="form-control" placeholder="请输入账号或者手机号">
							</div>
							<div class="form-group">
								<label for="name">密码:</label> <input name = "userpass" type="password"
									class="form-control" placeholder="请输入密码">
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" name="remmber" value="rem">记住密码
								</label> <label> <input type="checkbox" name="autoLogin" value="auto">自动登录
								</label>
							</div>
							<div class="form-group login-button">

								<input type="submit" class="form-control btn-primary btn "
									value="登录">
							</div>
							<div class="form-group">
								<p style="text-align: right;">
									<a href="#">找回密码</a> |没有账号| <a href="login.html#register">立即注册</a>
								</p>
								<p class="other-login" style="text-align: right">
									使用第三方账号登录 <a><span class="iconfont">&#xe629;</span></a><a><span
										class="iconfont">&#xe646;</span></a><a><span class="iconfont">&#xe7e4;</span></a>
								</p>
							</div>

						</form>
					</div>
					<div class="tab-pane fade" id="register">
						<form role="form">
							<div class="form-group">
								<label for="name">账号:</label> <input type="text"
									class="form-control" placeholder="请输入账号或者手机号">
							</div>
							<div class="form-group">
								<label for="name">密码:</label> <input type="password"
									class="form-control" placeholder="请输入密码">
							</div>
							<div class="form-group">
								<label for="name">手机号:</label> <input type="text"
									class="form-control" placeholder="请输入手机号">
							</div>
							<div class="form-group">
								<label>手机验证码:</label>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" name="phoneCode" class="form-control"
											placeholder="验证码">
									</div>
									<div class="col-xs-12">
										<input value="点击获取验证码" type="button" name="phoneCode"
											class="form-control btn btn-default">
									</div>
								</div>
							</div>
							<div class="form-group login-button">
								<input type="submit" class="form-control btn-primary btn "
									value="注册">
							</div>
						</form>
					</div>
					​

					<div class="col-md-7 col-xs-5"></div>
				</div>
			</div>
		</div>

		<div class="footer hidden-xs">
			<div class="footericon">
				<span class="iconfont icon-Windsurfing"></span>
			</div>
			<p class="cr">Copyright © 2018 qihangzaixian. All Rights
				Reserved.</p>
			<p class="cr">
				启航在线课程 版权所有 | <a href="#">工具下载</a> | <a href="#">资料下载</a> | <a
					href="#">视频下载</a> | <a href="#">问题反馈</a> | <a href="#">帮助</a>
			</p>
		</div>
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="${pageContext.request.contextPath}/static/lib/jquery/jquery.min.js"></script>
		<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/index.js"></script>
</body>
</html>
