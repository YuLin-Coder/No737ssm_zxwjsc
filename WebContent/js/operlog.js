$(function() {

$("#opername").blur(
		function() {
			$("#opername_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#opername").after("<span id='opername_msg' style='color: red'>操作名称不能为空</span>");
			}
	});
$("#methods").blur(
		function() {
			$("#methods_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#methods").after("<span id='methods_msg' style='color: red'>操作方法不能为空</span>");
			}
	});
$("#opers").blur(
		function() {
			$("#opers_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#opers").after("<span id='opers_msg' style='color: red'>操作人不能为空</span>");
			}
	});
$("#operurl").blur(
		function() {
			$("#operurl_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#operurl").after("<span id='operurl_msg' style='color: red'>操作路径不能为空</span>");
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
$("#operstatus").blur(
		function() {
			$("#operstatus_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#operstatus").after("<span id='operstatus_msg' style='color: red'>操作状态不能为空</span>");
			}
	});
$("#opertime").blur(
		function() {
			$("#opertime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#opertime").after("<span id='opertime_msg' style='color: red'>操作日期不能为空</span>");
			}
	});






$('#sub').click(function(){
var opername = $("#opername").val();
var methods = $("#methods").val();
var opers = $("#opers").val();
var operurl = $("#operurl").val();
var ipaddr = $("#ipaddr").val();
var operstatus = $("#operstatus").val();
var opertime = $("#opertime").val();
$("#opername_msg").empty();
$("#methods_msg").empty();
$("#opers_msg").empty();
$("#operurl_msg").empty();
$("#ipaddr_msg").empty();
$("#operstatus_msg").empty();
$("#opertime_msg").empty();
if (opername == "" || opername == null) {
				$("#opername").after("<span id='opername_msg' style='color: red'>操作名称不能为空</span>");
	return false;
}
if (methods == "" || methods == null) {
				$("#methods").after("<span id='methods_msg' style='color: red'>操作方法不能为空</span>");
	return false;
}
if (opers == "" || opers == null) {
				$("#opers").after("<span id='opers_msg' style='color: red'>操作人不能为空</span>");
	return false;
}
if (operurl == "" || operurl == null) {
				$("#operurl").after("<span id='operurl_msg' style='color: red'>操作路径不能为空</span>");
	return false;
}
if (ipaddr == "" || ipaddr == null) {
				$("#ipaddr").after("<span id='ipaddr_msg' style='color: red'>IP地址不能为空</span>");
	return false;
}
if (operstatus == "" || operstatus == null) {
				$("#operstatus").after("<span id='operstatus_msg' style='color: red'>操作状态不能为空</span>");
	return false;
}
if (opertime == "" || opertime == null) {
				$("#opertime").after("<span id='opertime_msg' style='color: red'>操作日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#opername_msg").empty();
$("#methods_msg").empty();
$("#opers_msg").empty();
$("#operurl_msg").empty();
$("#ipaddr_msg").empty();
$("#operstatus_msg").empty();
$("#opertime_msg").empty();
});

});
