
$(function() {
	
	$("#setValue").on("click", function() {
		$("#otextfield").otextfield("setValue", "新值");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#otextfield").otextfield("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#otextfield").otextfield("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#otextfield").otextfield("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#otextfield").otextfield("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#otextfield").otextfield("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#otextfield").otextfield("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#otextfield").otextfield("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#otextfield").otextfield("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
	// 定义校验别名。
	Smile.util.createVtypeAlias("v1", {
		rangeLength: [3, 8]
	});
	
});