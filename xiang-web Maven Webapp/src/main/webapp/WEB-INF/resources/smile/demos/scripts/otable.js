
$(function() {
	
	$("#addButton").on("click", function() {
		$("#otable").otable("addButton", {
			label: "Click Me!",
			click: function() {
				Smile.box.alert({
					content: "你点击了按钮"
				})
			}
		});
	});
	
});