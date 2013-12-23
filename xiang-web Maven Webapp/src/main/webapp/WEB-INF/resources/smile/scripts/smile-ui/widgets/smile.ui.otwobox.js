/*
 * Smile UI otwobox 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.olist4input.js
 */
(function($, undefined) {
	
// 不对IE6、IE7做主流支持
$.widget("smile.otwobox", $.smile.olist4input, {
	
	options: {
		title: null,
		odialogWidth: 600,
		odialogHeight: 480,
		leftGtRight: 0,
		valueSeparator: ", ",
		
		// 覆盖选项
		triggerCls: "ui-icon-bookmark",
		autoValidation: false
	},
	
	// 各种水平间距之和
	_HGAP: 10,
	// 各种垂直间距之和
	_VGAP: 78,
	
	_lbox: undefined,
	_rbox: undefined,
	_odialog: undefined,
	
	_create: function() {
		$.smile.olist4input.prototype._create.call(this);
		var self = this,
			opts = self.options,
			dv = "<div>",
			// box
			lbox = self._lbox = $(dv)
				.css({
					float: "left"
				}),
			rbox = self._rbox = $(dv)
				.css({
					float: "right"
				}),
			// odialog
			od = $(dv)
				// 防止对话框出轮动条，内部元素出滚动条溢出对话框时，对话框不出滚动条
				.css({
					overflow: "hidden"
				})
				.appendTo(document.body)
				.append(lbox)
				.append(rbox);
		
		self._odialog = od.odialog({
			title: opts.title || opts.label,
			autoOpen: false,
			modal: false,
			stack: true,
			width: opts.odialogWidth,
			height: opts.odialogHeight,
			draggable: true,
			resizable: false,
			buttons: [{
				text : "确定",
				click : function() {
					$(this).odialog("hide");
					self._doSetValue();
					self.validate();
				}
			}, {
				text : "取消",
				click : function() {
					$(this).odialog("hide");
					// 用于标记是否需要恢复到当前值，true表示需要
					self._isChange = true;
				}
			}, {
				text : "清空",
				click : function() {
					$(this).odialog("hide");
					self.clear();
				}
			}],
			create: function(e) {
				$(this).siblings(".ui-dialog-titlebar")
					.find(".ui-dialog-titlebar-close").remove();
			}
		});
		od.odialog("widget")
			.css({"box-shadow": "0 1px 3px rgba(204, 204, 204, 0.95) inset"});
		
		self._trig.bind("click."+this.widgetName, function(e) {
			self._odialog.odialog("toggleShow");
			return false;
		});
		
		self._odialog.bind( "odialogopen odialogshow", function(event, ui) {
			if(self._isChange) {
				self.setValue(self._curValue);
				self._isChange = false;
			}
		});
		
	},
	
	_doSetValue: $.noop
	
});

})(jQuery);

