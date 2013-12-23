/*
 * Smile UI oTextarea 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otextfield.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {
	
$.widget("smile.otextarea", $.smile.otextfield, {

	options: {
		
		height: 60,
		
		// 覆盖选项
		width: 650,
		labelAlign: "top"
		
	},
	
	_create: function() {
		$.smile.otextfield.prototype._create.apply( this );
		
		var self = this,
			ele = self.element,
			opts = self.options;
		
		ele.css({height: opts.height});
	}
	
});
	
})(jQuery);