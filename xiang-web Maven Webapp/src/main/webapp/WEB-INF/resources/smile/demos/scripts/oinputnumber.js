
$(function() {
	
	$("#setValue").on("click", function() {
		$("#oinputnumber").oinputnumber("setValue", "123456789.1234");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#oinputnumber").oinputnumber("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#oinputnumber").oinputnumber("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#oinputnumber").oinputnumber("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#oinputnumber").oinputnumber("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#oinputnumber").oinputnumber("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#oinputnumber").oinputnumber("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#oinputnumber").oinputnumber("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#oinputnumber").oinputnumber("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
});