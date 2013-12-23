/*
 * Smile UI oInputtrigger 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *
 *	smile.ui.otextfield.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {

// 触发按钮的宽度
var triggerWidth = 20;
	
$.widget("smile.otriggerinput", $.smile.otextfield, {

/*
<div class="o-border-box ui-widget o-form-item" style="width: 305px;">
	<label for="tags" style="width: 150px" class="o-border-box o-unselect o-form-item-ele o-form-item-ele-label" >Widget Label:</label>
	<div class="o-border-box o-form-item-ele" style="width: 150px;">
		<input name="tags" style="width: 131px;" class="o-border-box o-form-item-ele o-form-item-ele-text"></input>
		<button type="button" style="width: 20px" class="o-border-box o-form-item-ele o-form-item-ele-triger">~.~</button>
	</div>
	<div class="o-form-invalid-icon" style="display: none"></div>
	<div class="ui-widget-overlay o-unselect" style="display: none;"></div>
	<div class="o-clear">...</div>
</div>
*/

	options: {
		triggerCls: "ui-icon-triangle-1-s",
	},
	
	_trig: undefined,
	_selectClose: undefined,
	
	_create: function() {
		$.smile.otextfield.prototype._create.apply( this );
		var self = this,
			commonCss = "o-form-item-ele",
			b = "<button>",
			d = "<div>";
		
		self.element
			.attr("readonly", "readonly")
			.after(
				// trigger
				self._trig = $(b, {type: "button"})
					.addClass(commonCss + " o-unselect o-form-item-ele-triger")
					.css({
						width: triggerWidth,
						height: 22
					}).text("~.~").button({
				        icons: {
				            primary: self.options.triggerCls
				        },
				        text: false
				    })
				    .removeClass( "ui-corner-all" )
					.addClass( "ui-corner-right" )
			)
			.on("click", function() {
				if(self._visibleTrigger()) {
					self._trig.click();
				}
			});
		
		self._body.after(
			self._selectClose = $(d)
				.css({
					left: 285,
					top: 4,
					display: "none"
				})
				.addClass("o-select-close ui-icon ui-icon-close")
				.hover(function(e) {
					self._selectClose.css({
						left: 286,
						top: 3
					});
				}, function(e) {
					self._selectClose.css({
						left: 285,
						top: 4
					});
				})
				.click(function(e) {
					self.clear();
					self._hideSelectClose();
				})
		);
		
	},
	
	// input宽度，父类输入框的宽度 - trigger的宽度
	_inputWidth: function() {
		return $.smile.otextfield.prototype._inputWidth.apply( this ) - triggerWidth;
	},
	
	_setOption: function( key, value ) {
		$.smile.otextfield.prototype._setOption.apply( this, arguments );
		switch (key) {
			case "disabled":
				this._trig.button(value ? "disable" : "enable");
				break;
		}
	},
	
	getTrigger: function() {
		return this._trig;
	},
	
	readOnly: function() {
		$.smile.otextfield.prototype.readOnly.apply( this );
		this._hideTrigger();
	},
	
	nonreadOnly: function() {
		$.smile.otextfield.prototype.nonreadOnly.apply( this );
		this._showTrigger();
	},
	
	_visibleTrigger: function() {
		return this._trig.is(":visible");
	},
	
	_hideTrigger: function() {
		this._trig.hide();
	},
	
	_showTrigger: function() {
		this._trig.show();
	},
	
	_hideSelectClose: function() {
		this._selectClose.hide();
	},
	
	_showSelectClose: function() {
		this._selectClose.show();
	}
	
});
	
})(jQuery);