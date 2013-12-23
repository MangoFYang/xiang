
$(function() {
	
	$("#setValue").on("click", function() {
		$("#olistselect").olistselect("setValue", "0005, 0006");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#olistselect").olistselect("getValue");
		$("#getValueSpan").text(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#olistselect").olistselect("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#olistselect").olistselect("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#olistselect").olistselect("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#olistselect").olistselect("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#olistselect").olistselect("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#olistselect").olistselect("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#olistselect").olistselect("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
});