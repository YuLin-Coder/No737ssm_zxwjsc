<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<% String path = request.getContextPath(); String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
</head>
<body>
<nav class="breadcrumb">
<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>网站用户管理 <span class="c-gray en">&gt;</span>
网站用户查询 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
<table class="table table-border table-bordered table-bg">
<thead><tr><th scope="col" colspan="8">网站用户查询</th></tr><tr class="text-c"><th class="center">用户名</th><th class="center">姓名</th><th class="center">性别</th><th class="center">出生日期</th><th class="center">联系方式</th><th class="center">注册日期</th></tr></thead>
<c:forEach items="${usersList}" var="users"><tr class="text-c"><td class="center">${users.username}</td><td class="center">${users.realname}</td><td class="center">${users.sex}</td><td class="center">${users.birthday}</td><td class="center">${users.contact}</td><td class="center">${users.regdate}</td></tr></c:forEach></table>
<div class="cl pd-5 mt-20"></div>
<div class="text-c">
<form action="users/queryUsersByCond.action" name="myform" method="post">
查询条件： <span class="select-box" style="width: 200px;"><select name="cond" class="select"><option value="">---查询条件---</option>
<option value="username">按用户名查询</option><option value="realname">按姓名查询</option><option value="sex">按性别查询</option><option value="birthday">按出生日期查询</option><option value="contact">按联系方式查询</option><option value="regdate">按注册日期查询</option></select></span>&nbsp;&nbsp;关键字<input type="text" name="name" required style="width: 200px" class="input-text" />
<button type="submit" class="btn btn-success radius">
<i class="Hui-iconfont">&#xe665;</i> 查询
</button>
</form>
</div>
</div>
</body>
</html>

