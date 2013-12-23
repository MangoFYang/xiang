/*
 * Smile UI oText 1.0.2
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
	
/* widget
<div id="location" class="location">您现在的位置是： 权限管理 >> 角色管理</div>
*/
var PREFIX = "您现在的位置是: "

$.widget("smile.olocation", $.smile.obase, {

	options: {
		location: [],
		separator: " >> "
	},
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		this.element
			.addClass("location")
			.text(PREFIX + this.options.location.join(this.options.separator));
	}
	
});
	
})(jQuery);