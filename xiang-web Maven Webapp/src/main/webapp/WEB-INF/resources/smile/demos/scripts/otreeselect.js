
$(function() {
	
	$("#setValue").on("click", function() {
		$("#otreeselect").otreeselect("setValue", "16, 17, 18");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#otreeselect").otreeselect("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#otreeselect").otreeselect("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#otreeselect").otreeselect("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#otreeselect").otreeselect("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#otreeselect").otreeselect("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#otreeselect").otreeselect("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#otreeselect").otreeselect("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#otreeselect").otreeselect("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
});