/*
 * Smile UI oTooltip 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {
	
$.widget("smile.otooltip", $.smile.obase, {

	options: {
		
	},
	
	_widget: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		
		var self = this,
			ele = self.element,
			opts = self.options;
		
		var settings = $.extend(true, {
		    show: false,
		    hide: false
		}, opts);
		ele.tooltip(settings)
	},
	
	widget: function() {
		return this._widget = this.element.tooltip("widget");
	},
	
	/**
	 * 设置提示内容
	 * @param {String} content 提示信息的内容
	 * @returns 提示信息
	 */
	setContent: function(content) {
		return this.element.tooltip("option", "content", content);
	},
	
	/**
	 * 获取提示内容
	 * @returns 提示信息
	 */
	getContent: function() {
		return this.element.tooltip("option", "content");
	}
	
});
	
})(jQuery);