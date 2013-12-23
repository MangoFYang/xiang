
$(function() {
	
	$("button[id$=Btn]").on("click", function() {
		var xtype = this.id.substring(0, this.id.lastIndexOf("Btn"));
		$("#"+xtype).odialog("show");
	})
	
});