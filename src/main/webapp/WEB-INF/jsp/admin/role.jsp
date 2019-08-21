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
		<div class="row">
			<div class="search_title_bar">收索</div>
		</div>
		<div class="row">
			<form id="search_form" class="form-inline">
				<div class="form-group">
					<label>角色信息:</label> <input class="form-control input-sm"
						type="text" name="userInfo" placeholder="角色名称/代码">
				</div>
			</form>
		</div>
		<div id="search_btn" class="row">
			<button type="button" class="btn btn-default">查询</button>
			<button type="button" data-toggle="modal" data-target="#addRoleModal"
				class="btn btn-default">添加</button>
			<button type="button" class="btn btn-default">删除</button>
		</div>
		<div id="content_table" class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<tr>
						<td style="width: 30px;"><input type="checkbox"
							class="chkall" onclick="chkall();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td style="width: 100px;">操作</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#updateRoleModal" data-toggle="modal">编辑</a> <a
							href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chkuser" class="chkone"
							onclick="chkone();"></td>
						<td>角色名称</td>
						<td>角色代码</td>
						<td><a href="#">编辑</a> <a href="#">删除</a></td>
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
	<!-- Modal 添加 -->
	<div class="modal fade" data-backdrop="false" id="addRoleModal"
		tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加角色</h4>
				</div>
				<div class="modal-body">
					<form action="#">
						<div class="form-group">
							<label>角色名称：</label> <input type="text" name="username"
								class="form-control" placeholder="角色名称">
						</div>
						<div class="form-group">
							<label>角色代码：</label> <input type="text" name="username"
								class="form-control" placeholder="角色代码">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">添加角色</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 编辑 -->
	<div class="modal fade" data-backdrop="false" id="updateRoleModal"
		tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑角色</h4>
				</div>
				<div class="modal-body">
					<form action="#">
						<div class="form-group">
							<label>角色名称：</label> <input type="text" name="username"
								class="form-control" placeholder="角色名称">
						</div>
						<div class="form-group">
							<label>角色代码：</label> <input type="text" name="username"
								class="form-control" placeholder="角色代码">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">编辑角色</button>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${pageContext.request.contextPath}/static/lib/jquery/jquery.min.js"></script>
	<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user.js"></script>
</body>
</html>