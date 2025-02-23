<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>欢迎访问后台管理系统</title>
<link href="h-ui/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="h-ui/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="h-ui/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
	function checkLogin() {
		var username = document.myform.username.value;
		var password = document.myform.password.value;
		if (username == '') {
			alert('请输入用户名');
			document.myform.username.focus();
			return false;
		}
		if (password == '') {
			alert('请输入密码');
			document.myform.password.focus();
			return false;
		}
	}
	function getExplorerInfo() {
		var explorer = window.navigator.userAgent.toLowerCase();
		//ie
		if (explorer.indexOf("msie") >= 0) {
			var ver = explorer.match(/msie ([\d.]+)/)[1];
			return {
				type : "IE",
				version : ver
			};
		}
		//firefox
		else if (explorer.indexOf("firefox") >= 0) {
			var ver = explorer.match(/firefox\/([\d.]+)/)[1];
			return {
				type : "Firefox",
				version : ver
			};
		}
		//Chrome
		else if (explorer.indexOf("chrome") >= 0) {
			var ver = explorer.match(/chrome\/([\d.]+)/)[1];
			return {
				type : "Chrome",
				version : ver
			};
		}
		//Opera
		else if (explorer.indexOf("opera") >= 0) {
			var ver = explorer.match(/opera.([\d.]+)/)[1];
			return {
				type : "Opera",
				version : ver
			};
		}
		//Safari
		else if (explorer.indexOf("Safari") >= 0) {
			var ver = explorer.match(/version\/([\d.]+)/)[1];
			return {
				type : "Safari",
				version : ver
			};
		}
	}
	$('#userbrowser').val(
			getExplorerInfo().type + getExplorerInfo().version.substring(0, 2));
</script>
</head>
<body>
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<p style="font-size: 28px; font-weight: bold; text-align: center; color: white; letter-spacing: 2px; margin-bottom: 30px;">网站管理系统</p>
			<form class="form form-horizontal" action="admin/login.action" name="myform" method="post" onSubmit="return checkLogin()">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input type="text" id="username" name="username" placeholder="请输入用户名" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input type="password" id="password" name="password" placeholder="请输入密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input type="hidden" id="userbrowser" name="userbrowser" value="Chrome9"> <input type="submit"
							class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input type="reset"
							class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">${year }&copy; 后台管理系统 All Rights Reserved</div>
</body>
</html>
<%
	String message = (String) session.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	session.removeAttribute("message");
%>