
$(function() {
	
	$("#disable").on("click", function(e) {
		$("#demoBtn").obutton("disable");
		return false;
	});
	$("#enable").on("click", function(e) {
		$("#demoBtn").obutton("enable");
		return false;
	});
	
});