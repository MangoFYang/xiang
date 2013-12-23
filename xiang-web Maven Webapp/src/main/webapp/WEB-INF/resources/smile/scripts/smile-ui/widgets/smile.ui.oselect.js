/*
 * Smile UI Olistselectsingle 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.osinglebox.js
 */
(function($, undefined) {

$.widget("smile.oselect", $.smile.osinglebox, {
	
	options: {
		
		// 回调，选择时触发
		select: null
	},
	
	_list: undefined,
	
	_create: function() {
		$.smile.osinglebox.prototype._create.call(this);
		var self = this,
			opts = self.options,
			ul = "<ul>",
			// olist
			list = self._list = $(ul).appendTo(self._box);

		list.olist({
			data: opts.data,
			displayField: opts.displayField,
			valueField: opts.valueField,
			valueSeparator: opts.valueSeparator,
			width: opts.odialogWidth - self._HGAP,
			height: opts.odialogHeight - self._VGAP,
			select: function(event, data) {
				self._odialog.odialog("hide");
				self._setValue();
				self.validate();
				self._trigger("select", event, data);
			}
		});
	},
	
	/**
	 * 内部使用设置值
	 * 将选中节点数据放入this._nodeData中并填写输入域相关信息。
	 */
	_setValue: function() {
		this._nodeData = this._list.olist("getData", this._list.olist("getSelected"));
		var text = this._nodeData[this.options.displayField];
		this.element.val(text).attr({"title": text});
	},
	
	/**
	 * 设置新数据源
	 * @param data 新数据源
	 */
	setData: function(data) {
		this.clear();
		this.options.data = data;
		this._list.olist("setData", data);
	}
	
});

})(jQuery);

