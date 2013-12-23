/*
 * Smile UI oAjaxinput 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otriggerinput.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {
	
$.widget("smile.oajaxinput", $.smile.otextfield, {

	options: {
		url: null,
		termName: "term",
		
		// 回调
		onComplete: $.noop,
		
		// 覆盖选项
		autoValidation: false
	},
	
	_create: function() {
		$.smile.otextfield.prototype._create.apply( this );
		var self = this,
			// 一次只能进行一个ajax校验请求。
			lastXhr = null,
			ajaxSetting = {
				hasContextPath: false,
				url: contextPath + self.options.url,
				data: {
				},
				onComplete: function(data, textStatus) {
					if(data && data.className === 'smile.views.model.Result') {
						self._ajaxError = [];
						if(!data.result) {
							self._ajaxError.push(
									data.message ? data.message : Smile.mesageCode.invalidInput);
						}
						self.validate();
					} else {
						Smile.box.alert({
							content: Smile.mesageCode.dev.dev00001
						});
					}
					self._trigger("onComplete", null, {
						data: data,
						textStatus: textStatus
					});
					lastXhr = null;
				}
			},
			ajaxFn = function(e) {
				self._ajaxError = [];
				if (self.validate() && lastXhr == null) {
					self._ajaxError.push(Smile.mesageCode.validating);
		            ajaxSetting.data[self.options.termName] = self.getValue();
		            lastXhr = Smile.ajax(ajaxSetting);
		        }
				return false;
			};
		self.element.bind("change." + self.widgetName, ajaxFn);
	},
	
	_ajaxError: [],
	
	/**
	 * 
	 * 校验顺序
	 * 1. 常规校验。
	 * 2. ajax异步校验
	 * 
	 * @returns {Array} 校验错误信息
	 */
	_getErrors: function() {
		return $.merge($.smile.otextfield.prototype._getErrors.apply( this ), this._ajaxError);
	}
	
});
	
})(jQuery);