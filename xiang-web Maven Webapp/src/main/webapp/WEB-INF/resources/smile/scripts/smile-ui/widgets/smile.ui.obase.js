/*
 * Smile UI obase 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 */
(function($, undefined) {
	
// 不对IE6、IE7做主流支持
$.widget("smile.obase", {
	
	options: {
		hidden: false
	},
	
	_init: function() {
		if(this.options.hidden) {
			this.hide();
		}
	},
	
	_create: function() {
		this.element.addClass("SmileUI");
	},
	
	hide: function() {
		return this.widget().hide();
	},
	
	show: function() {
		return this.widget().show();
	}
	
});

})(jQuery);

