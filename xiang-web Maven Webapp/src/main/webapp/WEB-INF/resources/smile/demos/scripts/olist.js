
$(function() {
	
	$("#setValue").on("click", function() {
		$("#olist").olist("setValue", "0006, 0007");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#olist").olist("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#olist").olist("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#olist").olist("enable");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#olist").olist("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#olist").olist("clear");
		return false;
	});
	$("#select").on("click", function(e) {
		$("#olist").olist("select", "0001");
		return false;
	});
	$("#unselect").on("click", function(e) {
		$("#olist").olist("unselect", "0001");
		return false;
	});
	$("#selectAll").on("click", function(e) {
		$("#olist").olist("selectAll");
		return false;
	});
	$("#unselectAll").on("click", function(e) {
		$("#olist").olist("unselectAll");
		return false;
	});
	
});