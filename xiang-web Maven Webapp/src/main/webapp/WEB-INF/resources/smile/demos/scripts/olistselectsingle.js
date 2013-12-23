
$(function() {
	
	$("#setValue").on("click", function() {
		$("#olistselectsingle").olistselectsingle("setValue", "0002");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#olistselectsingle").olistselectsingle("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#olistselectsingle").olistselectsingle("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#olistselectsingle").olistselectsingle("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#olistselectsingle").olistselectsingle("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#olistselectsingle").olistselectsingle("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#olistselectsingle").olistselectsingle("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#olistselectsingle").olistselectsingle("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#olistselectsingle").olistselectsingle("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
});