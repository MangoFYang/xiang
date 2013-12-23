/*
 * Smile UI obutton 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.obase.js
 */
(function($, undefined) {
	
// 不对IE6、IE7做主流支持
$.widget("smile.obutton", $.smile.obase, {
	
/**
<button id="btn1" type="button">按钮</button>
*/
	
	options: {
		disabled: false,
		text: true,
		primaryIcon: null,
		secondaryIcon: null,
		// icons: { primary: null, secondary: null }
		
		// 回调，点击时触发
		click: $.noop
	},
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		var self = this,
			opts = self.options,
			ele = self.element;
		
		opts.icons = {
			primary: opts.primaryIcon,
			secondary: opts.secondaryIcon
		};
		
		ele.addClass("o-border-box")
			.button(opts)
			.on("click", function(event) {
				self._trigger("click", event, {
					target: self.element
				});
			
			});
	},
	
	destroy: function() {
		this.element.button("destroy");
	},
	
	disable: function() {
		this.element.button("disable");
	},
	
	enable: function() {
		this.element.button("enable");
	},
	
	widget: function() {
		this.element.button("widget");
	},
	
	refresh: function() {
		this.element.button("refresh");
	}
	
});

})(jQuery);

