
$(function() {
	
	$("#alert").on("click", function() {
		Smile.box.alert({
			content: "这里是提示信息!",
			ok: function() {
				$("#alertSpan").html("OK!");
			}
		});
	});
	$("#success").on("click", function() {
		Smile.box.success({
			content: "这里是提示信息!"
		});
	});
	$("#info").on("click", function() {
		Smile.box.info({
			content: "这里是提示信息!"
		});
	});
	$("#confirm").on("click", function() {
		Smile.box.confirm({
			content: "这里是提示信息!",
			ok: function() {
				$("#confirmSpan").html("OK!");
			},
			cancel: function() {
				$("#confirmSpan").html("CANCEL!");
			}
		});
	});
	$("#error").on("click", function() {
		Smile.box.error({
			content: "这里是提示信息!"
		});
	});
	
});