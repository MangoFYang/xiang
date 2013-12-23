//library
function distance(x0, y0, x1, y1) {
	var xDiff = x1-x0;
	var yDiff = y1-y0;
	
	return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
}

$(document).ready(function() {
	var proximity = 180;
	var iconSmall = 48, iconLarge = 128; //css also needs changing to compensate with size
var iconDiff = (iconLarge - iconSmall);
var mouseX, mouseY;
var dock = $("#dock");
var animating = false, redrawReady = false;

$(document.body).removeClass("no_js");

//below are methods for maintaining a constant 60fps redraw for the dock without flushing
$(document).bind("mousemove", function(e) {
if (dock.is(":visible")) {
		mouseX = e.pageX;
		mouseY = e.pageY;
	
		redrawReady = true;
		registerConstantCheck();
	}
});

function registerConstantCheck() {
	if (!animating) {
		animating = true;
		
		window.setTimeout(callCheck, 15);
	}
}

function callCheck() {
	sizeDockIcons();
	
	animating = false;

	if (redrawReady) {
		redrawReady = false;
		registerConstantCheck();
	}
}

//do the maths and resize each icon
function sizeDockIcons() {
	dock.find("li").each(function() {
//find the distance from the center of each icon
var centerX = $(this).offset().left + ($(this).outerWidth()/2.0);
var centerY = $(this).offset().top + ($(this).outerHeight()/2.0);

var dist = distance(centerX, centerY, mouseX, mouseY);

//determine the new sizes of the icons from the mouse distance from their centres
var newSize =  (1 - Math.min(1, Math.max(0, dist/proximity))) * iconDiff + iconSmall;
$(this).find("a").css({width: newSize});
		});
	}
});

$(function() {
	
	var marginLeft = 0, offsetLeft = 200, 
		maxMoveCount = Math.ceil(($("#dock > ul").width() - $("#dock").width()) / 200) + 1
		rightMoveCount = maxMoveCount;
	$("a.prev").on("click", function(e) {
		if(maxMoveCount - rightMoveCount != 0) {
			$("#dock > ul").css({"margin-left": marginLeft = marginLeft + offsetLeft});
			rightMoveCount ++;
		}
		checkDisabled();
	});
	
	$("a.next").on("click", function(e) {
		if(rightMoveCount != 0) {
			$("#dock > ul").css({"margin-left": marginLeft = marginLeft - offsetLeft});
			rightMoveCount --;
		}
		checkDisabled();
	});
	
	if(maxMoveCount > 0) {
		$("a.next").removeClass("disabled");
	}
	
	function checkDisabled() {
		if(maxMoveCount == rightMoveCount) {
			$("a.prev").addClass("disabled");
		}  else {
			$("a.prev").removeClass("disabled");
		}
		if(rightMoveCount == 0) {
			$("a.next").addClass("disabled");
		} else {
			$("a.next").removeClass("disabled");
		}
	};
	
	$("#dockUl").find("a").on("click", function() {
		var $this = $(this);
		var xtype = $this.find("span").text();
		$("#"+xtype).odialog("show");
	});
	
	var cloud1 = $("#cloud1"), left = 0;
	window.setInterval(function() {
		if(left >= 1800) {
			left = -688;
		}
		cloud1.css({left: left = left + 0.3});
	}, 50);
	
});
