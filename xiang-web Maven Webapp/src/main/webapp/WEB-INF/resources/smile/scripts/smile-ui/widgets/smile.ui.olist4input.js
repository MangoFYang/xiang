/*
 * Smile UI olist4input 1.0.2
 *
 * @author yangfan, 2012-04-16
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otriggerinput.js
 */
(function($, undefined) {
	
// 不对IE6、IE7做主流支持
$.widget("smile.olist4input", $.smile.otriggerinput, {
	
	options: {
		data: [],
		displayField: "label",
		valueField: "value"
	}
	
});

})(jQuery);

