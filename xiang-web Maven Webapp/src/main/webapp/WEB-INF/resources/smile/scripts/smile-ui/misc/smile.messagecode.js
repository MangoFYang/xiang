/*
 * Smile MesageCode 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	smile.ui.core.js
 */
(function($, undefined) {
	
$.extend($.smile, {
	
	mesageCode: {
		
		// smile.ui.ogrid.js
		// smile.ui.oajaxinput.js
		invalidInput: "请输入合法数据!",
		validating: "正在校验...",
		
		dev: {
			// smile.ui.oajaxinput.js
			dev00001: "请将Java类smile.views.model.Result的对象序列化成json, 作为返回值!",
			dev00002: "元素{0}缺失!",
			// smile.ui.ogrid.js
			dev00003: "请设置{0}选项，此选项指明编辑内容提交到的URL，OGrid Id：{1}!",
			// smile.ui.odialog.js
			dev00004: "选项{0}不支持此类型, {1}!"
		}
			
	}

});

})(jQuery);


