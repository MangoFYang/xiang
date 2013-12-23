
$(function() {
	
	$("#setValue").on("click", function(e) {
		$("#odatepicker1").odatepicker("setValue", "1971-01-01");
		return false;
	});
	$("#getValue").on("click", function(e) {
		var val = $("#odatepicker1").odatepicker("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#odatepicker1").odatepicker("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#odatepicker1").odatepicker("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#odatepicker1").odatepicker("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#odatepicker1").odatepicker("nonreadOnly");
		return false;
	});
	
});