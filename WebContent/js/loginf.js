$(function() {

$("#logname").blur(
		function() {
			$("#logname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#logname").after("<span id='logname_msg' style='color: red'>登录名不能为空</span>");
			}
	});
$("#ipaddr").blur(
		function() {
			$("#ipaddr_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ipaddr").after("<span id='ipaddr_msg' style='color: red'>IP地址不能为空</span>");
			}
	});
$("#brower").blur(
		function() {
			$("#brower_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#brower").after("<span id='brower_msg' style='color: red'>浏览器不能为空</span>");
			}
	});
$("#os").blur(
		function() {
			$("#os_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#os").after("<span id='os_msg' style='color: red'>操作系统不能为空</span>");
			}
	});
$("#logstatus").blur(
		function() {
			$("#logstatus_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#logstatus").after("<span id='logstatus_msg' style='color: red'>登录状态不能为空</span>");
			}
	});
$("#role").blur(
		function() {
			$("#role_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#role").after("<span id='role_msg' style='color: red'>登录角色不能为空</span>");
			}
	});
$("#logtime").blur(
		function() {
			$("#logtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#logtime").after("<span id='logtime_msg' style='color: red'>登录时间不能为空</span>");
			}
	});






$('#sub').click(function(){
var logname = $("#logname").val();
var ipaddr = $("#ipaddr").val();
var brower = $("#brower").val();
var os = $("#os").val();
var logstatus = $("#logstatus").val();
var role = $("#role").val();
var logtime = $("#logtime").val();
$("#logname_msg").empty();
$("#ipaddr_msg").empty();
$("#brower_msg").empty();
$("#os_msg").empty();
$("#logstatus_msg").empty();
$("#role_msg").empty();
$("#logtime_msg").empty();
if (logname == "" || logname == null) {
				$("#logname").after("<span id='logname_msg' style='color: red'>登录名不能为空</span>");
	return false;
}
if (ipaddr == "" || ipaddr == null) {
				$("#ipaddr").after("<span id='ipaddr_msg' style='color: red'>IP地址不能为空</span>");
	return false;
}
if (brower == "" || brower == null) {
				$("#brower").after("<span id='brower_msg' style='color: red'>浏览器不能为空</span>");
	return false;
}
if (os == "" || os == null) {
				$("#os").after("<span id='os_msg' style='color: red'>操作系统不能为空</span>");
	return false;
}
if (logstatus == "" || logstatus == null) {
				$("#logstatus").after("<span id='logstatus_msg' style='color: red'>登录状态不能为空</span>");
	return false;
}
if (role == "" || role == null) {
				$("#role").after("<span id='role_msg' style='color: red'>登录角色不能为空</span>");
	return false;
}
if (logtime == "" || logtime == null) {
				$("#logtime").after("<span id='logtime_msg' style='color: red'>登录时间不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#logname_msg").empty();
$("#ipaddr_msg").empty();
$("#brower_msg").empty();
$("#os_msg").empty();
$("#logstatus_msg").empty();
$("#role_msg").empty();
$("#logtime_msg").empty();
});

});
