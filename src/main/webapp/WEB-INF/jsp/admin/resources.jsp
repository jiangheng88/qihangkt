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

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/lib/html5shiv/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/lib/respond/Respond.min.js"></script>
      <![endif]-->


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/user.css">
</head>
<body>

	<div class="container-fluid">
		<div id="content_table" class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<tr>
						<td style="width: 100px;">资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>资源路径</td>
					</tr>

				</table>
			</div>
		</div>
		<div id="pager" class="row">
			<p class="pull-left">
				总共有<span> 90 </span>记录，当前页<span> 1 / 9 </span>页
			</p>
			<div class="btngroup pull-right">
				<button type="button" class="btn btn-default">首页</button>
				<button type="button" class="btn btn-default">上一页</button>
				<button type="button" class="btn btn-default">上一页</button>
				<button type="button" class="btn btn-default">尾页</button>
			</div>
		</div>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${pageContext.request.contextPath}/static/lib/jquery/jquery-1.12.4.min.js"></script>
	<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user.js"></script>
</body>
</html>