
$(function() {
	
	$("#setValue").on("click", function() {
		$("#oselect").oselect("setValue", "1002");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#oselect").oselect("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#oselect").oselect("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#oselect").oselect("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#oselect").oselect("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#oselect").oselect("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#oselect").oselect("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#oselect").oselect("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#oselect").oselect("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
});