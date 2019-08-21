<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->


<title>admin管理用户页面</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/font/iconfont.css">
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/static/lib/html5shiv/html5shiv.min.js"></script>
      <script src="${pageContext.request.contextPath}/static/lib/respond/Respond.min.js"></script>
      <![endif]-->


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/user.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/lib/bootstrapSelect/css/bootstrap-select.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="search_title_bar">收索</div>
		</div>
		<div class="row">
			<form
				action="${pageContext.request.contextPath}/admin/userSearch"
				id="search_form" class="form-inline" method="post"
				>
				<div class="form-group has-feedback">
					<label>报名时间:</label> <input
						class="form-control input-sm form_datetime" type="text"
						name="regCourseStartTime"> <span
						class="iconfont form-control-feedback">&#xe66c;</span>
				</div>
				<div class="form-group has-feedback">
					<label>至</label> <input class="form-control input-sm form_datetime"
						type="text" name="regCourseEndTime"> <span
						class="iconfont  form-control-feedback">&#xe66c;</span>
				</div>
				&nbsp;
				<div class="form-group">
					<label>报名课程:</label> <input class="form-control input-sm"
						type="text" name="regCourse" placeholder="课程名称">
				</div>
				&nbsp;
				<div class="form-group">
					<label>学员信息:</label> <input class="form-control input-sm"
						type="text" name="userInfo" placeholder="用户名/手机号">
				</div>
			</form>
		</div>
		<div id="search_btn" class="row text-right">
			<button id="searchBtn" type="button" class="btn btn-default">查询</button>
			<button type="button" data-toggle="modal" data-target="#addUserModal"
				class="btn btn-default">添加</button>
			<button id="batchDelUsersBtn" type="button" class="btn btn-default">删除</button>
			<button type="button" class="btn btn-default">导入</button>
			<button type="button" class="btn btn-default">导出</button>
		</div>
		<div id="content_table" class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<tr>
						<td style="width: 30px;"><input type="checkbox"
							class="chkall" onclick="chkall();"></td>
						<td>用户名</td>
						<td>手机号</td>
						<td>邮箱地址</td>
						<td>角色</td>
						<td>用户状态</td>
						<td style="width: 100px;">操作</td>
					</tr>
					<c:forEach items="${users.list}" var="user">
						<tr>
							<td><input value="${user.id}" type="checkbox" name="chkuser"
								class="chkone" onclick="chkone();"></td>
							<td>${user.username}</td>
							<td>${user.phone}</td>
							<td>${user.email}</td>
							<td><c:forEach items="${user.role}" var="role">
                			 ${role.roleName} &nbsp;			
                			</c:forEach></td>
							<td>${user.enable }</td>
							<td><a
								href="${pageContext.request.contextPath}/admin/updateUser?id=${user.id}"
								data-target="#updateUserModal" data-toggle="modal">编辑</a> <a
								href="${pageContext.request.contextPath}/admin/deleteUser?id=${user.id}"
								onclick="return delSure()">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div id="pager" class="row">
			<p class="pull-left">
				总共有<span> ${users.total}</span>条记录，当前第<span> ${users.pageNum}
				</span>页,共<span> ${users.pages} </span>页
			</p>
			<div class="btngroup pull-right">
				<a
					href="${pageContext.request.contextPath}/admin/user?pageNum=1&pageSize=6"
					type="button" class="btn btn-default">首页</a> <a
					href="${pageContext.request.contextPath}/admin/user?pageNum=${users.prePage}&pageSize=6"
					type="button" class="btn btn-default">上一页</a> <a
					href="${pageContext.request.contextPath}/admin/user?pageNum=${users.nextPage}&pageSize=6"
					type="button" class="btn btn-default">下一页</a> <a
					href="${pageContext.request.contextPath}/admin/user?pageNum=${users.pages}&pageSize=6"
					type="button" class="btn btn-default">尾页</a>
			</div>
		</div>
	</div>
	<!-- Modal 添加 -->
	<div class="modal fade" data-backdrop="false" id="addUserModal"
		tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加用户</h4>
				</div>
				<div class="modal-body">
					<form id="addUserFrom"
						action="${pageContext.request.contextPath}/admin/addUser.html"
						method="post">
						<div class="form-group">
							<label>用户名：</label> <input type="text" name="username"
								class="form-control" placeholder="用户名">
						</div>
						<div class="form-group">
							<label>密码：</label> <input type="password" name="userpass"
								class="form-control" placeholder="密码">
						</div>
						<div class="form-group">
							<label>关联的角色：</label> <select name="roleIds"
								class="selectpicker form-control" multiple>
								<c:forEach items="${role}" var="role">
									<option value="${role.id}">${role.roleName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>手机号：</label> <input type="text" name="phone"
								class="form-control" placeholder="手机号码">
						</div>
						<div class="form-group">
							<label>邮箱：</label> <input type="text" name="email"
								class="form-control" placeholder="电子邮箱">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="addUserBtn" type="button" class="btn btn-primary">添加用户</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 编辑 -->
	<div class="modal fade" data-backdrop="false" id="updateUserModal"
		tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
			<!-- 这里只动态的代码，在控制层实现 -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="addUserBtn" type="button" class="btn btn-primary">修改用户</button>
				</div>
			
			</div>
		</div>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="${pageContext.request.contextPath}/static/lib/jquery/jquery.min.js"></script>
	<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/lib/datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/lib/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/lib/bootstrapSelect/js/bootstrap-select.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/lib/bootstrapSelect/js/i18n/defaults-zh_CN.min.js"></script>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/user.js"></script>
</body>
</html>