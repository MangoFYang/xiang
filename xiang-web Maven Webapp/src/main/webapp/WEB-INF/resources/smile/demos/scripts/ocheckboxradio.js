
$(function() {
	
	$("#checkbox_checked").on("click", function() {
		var ret = $.smile.ocheckbox.getValue("cb");
		$("#checkbox_value").text(ret);
	});
	
	$("#radio_checked").on("click", function() {
		var ret = $.smile.oradio.getValue("r");
		$("#radio_value").text(ret);
	});
	
});

function check(event, data) {
	Smile.box.info({
		content: "您选中了: " + $(data.target)[$(data.target).data("xtype")]("option", "label")
	})
}

function uncheck(event, data) {
	Smile.box.info({
		content: "您取消选中了: " + $(data.target)[$(data.target).data("xtype")]("option", "label")
	})
}