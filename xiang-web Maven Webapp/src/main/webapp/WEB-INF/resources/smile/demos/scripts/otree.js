
$(function() {
	
	$("#selectNode").on("click", function() {
		$("#otree").otree("selectNode", $("#18"), true);
		return false;
	});
	$("#deselectNode").on("click", function() {
		$("#otree").otree("deselectNode", $("#18"));
		return false;
	});
	$("#toggleSelect").on("click", function() {
		$("#otree").otree("toggleSelect", $("#17"));
		return false;
	});
	$("#deselectAll").on("click", function() {
		$("#otree").otree("deselectAll");
		return false;
	});
	$("#isSelected").on("click", function() {
		var ret = $("#otree").otree("isSelected");
		$("#isSelectedSpan").text(ret);
		return false;
	});
	$("#getSelected").on("click", function() {
		var ret = $("#otree").otree("getSelected");
		$("#getSelectedSpan").text(ret.text());
		return false;
	});
	
});

function selectNode(event, data) {
	var t;
}
function deselectNode(event, data) {
	var t;
}