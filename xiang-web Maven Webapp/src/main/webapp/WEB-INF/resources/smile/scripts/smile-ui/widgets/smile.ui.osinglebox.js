/*
 * Smile UI osinglebox 1.0.2
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
$.widget("smile.osinglebox", $.smile.olist4input, {
	
	options: {
		title: null,
		odialogWidth: 400,
		odialogHeight: 480,
		
		// 覆盖选项
		triggerCls: "ui-icon-bookmark",
		autoValidation: false,
		
		// 回调
		clear: null
	},
	
	// 各种水平间距之和
	_HGAP: 8,
	// 各种垂直间距之和
	_VGAP: 78,
	// 当前选中节点的数据。
	_nodeData: undefined,
	
	_odialog: undefined,
	_box: undefined,
	
	_create: function() {
		$.smile.olist4input.prototype._create.call(this);
		var self = this,
			opts = self.options,
			dv = "<div>",
			// box
			box = self._box = $(dv),
			// odialog
			od = $(dv)
				// 防止对话框出轮动条，内部元素出滚动条溢出对话框时，对话框不出滚动条
				.css({
					overflow: "hidden"
				})
				.appendTo(document.body)
				.append(box);
		
		self._odialog = od.odialog({
			title: opts.title || opts.label,
			autoOpen: false,
			modal: false,
			stack: true,
			width: opts.odialogWidth,
			height: opts.odialogHeight,
			draggable: true,
			resizable: false,
			buttons: [ {
				text : "取消",
				click : function(event) {
					$(this).odialog("hide");
				}
			}, {
				text : "清空",
				click : function(event) {
					$(this).odialog("hide");
					self.clear();
					self._trigger("clear", event);
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

	},
	
	setValue: function(value) {
		var self = this,
			exists = false;
		if($.trim(value) != "") {
			$.each(self.options.data, function(i, n) {
				if(value == n[self.options.valueField]) {
					self._nodeData = n; 
					exists = true;
					var text = self._nodeData[self.options.displayField];
					self.element.val(text).attr({"title": text});
					return false;
				}
			});
		}
		if(!exists) {
			this.clear();
		}
		this.validate();
	},
	
	getValue: function() {
		return this._nodeData ? this._nodeData[this.options.valueField] : "";
	},
	
	clear: function() {
		this._doClear();
		this.validate();
	},
	
	_doClear: function() {
		this._nodeData = null;
		this.element.val("").removeAttr("title");
	}
	
});

})(jQuery);

