
$(function() {
	
	$("#select").on("click", function(e) {
		$("#otabs").otabs("select", 1);
		return false;
	});
	$("#length").on("click", function(e) {
		var ret = $("#otabs").otabs("length");
		$("#lengthSpan").text(ret);
		return false;
	});
	$("#disableT3").on("click", function(e) {
		$("#otabs").otabs("disable", 2);
		return false;
	});
	$("#enableT3").on("click", function(e) {
		$("#otabs").otabs("enable", 2);
		return false;
	});
	
});