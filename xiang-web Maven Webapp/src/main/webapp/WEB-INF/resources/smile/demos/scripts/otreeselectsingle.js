
$(function() {
	
	$("#setValue").on("click", function() {
		$("#otreeselectsingle").otreeselectsingle("setValue", "43");
		return false;
	});
	$("#getValue").on("click", function() {
		var val = $("#otreeselectsingle").otreeselectsingle("getValue");
		$("#getValueSpan").html(val);
		return false;
	});
	$("#disable").on("click", function(e) {
		$("#otreeselectsingle").otreeselectsingle("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#otreeselectsingle").otreeselectsingle("enable");
		return false;
	});
	$("#readOnly").on("click", function(e) {
		$("#otreeselectsingle").otreeselectsingle("readOnly");
		return false;
	});
	$("#nonreadOnly").on("click", function(e) {
		$("#otreeselectsingle").otreeselectsingle("nonreadOnly");
		return false;
	});
	$("#reset").on("click", function(e) {
		$("#otreeselectsingle").otreeselectsingle("reset");
		return false;
	});
	$("#clear").on("click", function(e) {
		$("#otreeselectsingle").otreeselectsingle("clear");
		return false;
	});
	$("#validate").on("click", function(e) {
		var ret = $("#otreeselectsingle").otreeselectsingle("validate");
		$("#validateSpan").html(ret ? "通过" : "失败");
		return false;
	});
	
});