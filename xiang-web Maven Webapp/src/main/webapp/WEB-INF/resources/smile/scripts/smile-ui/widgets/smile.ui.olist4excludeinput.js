/*
 * Smile UI olist4excludeinput 1.0.2
 *
 * @author yangfan, 2012-04-16
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.obase.js
 */
(function($, undefined) {

$.widget("smile.olist4excludeinput", $.smile.obase, {
	
	options: {
		data: [],
		displayField: "label",
		valueField: "value",
		
		width: 300,
		height: 400
	}
	
});

})(jQuery);

