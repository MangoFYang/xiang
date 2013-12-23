
$(function() {
	
	$("#toggleShow").on("click", function(e) {
		$("#odialog").odialog("toggleShow");
		return false;
	});
	$("#show").on("click", function(e) {
		$("#odialog").odialog("show");
		return false;
	});
	$("#hide").on("click", function(e) {
		$("#odialog").odialog("hide");
		return false;
	});
	$("#open").on("click", function(e) {
		$("#odialog").odialog("open");
		return false;
	});
	$("#close").on("click", function(e) {
		$("#odialog").odialog("close");
		return false;
	});
	$("#isShow").on("click", function(e) {
		var ret = $("#odialog").odialog("isShow");
		$("#isShowSpan").text(ret);
		return false;
	});
	
});