/*
 * Smile UI olistselect 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otwobox.js
 */
(function($, undefined) {
	
// 不对IE6、IE7做主流支持
$.widget("smile.olistselect", $.smile.otwobox, {
	
	options: {
		
		// 覆盖选项
		title: "Olistselect Title"
	},
	
	_curValue: "",
	
	_oc: undefined,
	_llist: undefined,
	_rlist: undefined,
	
	_create: function() {
		$.smile.otwobox.prototype._create.call(this);
		var self = this,
			opts = self.options,
			it = "<input>",
			ul = "<ul>",
			// olist
			llist = self._llist = $(ul).appendTo(self._lbox),
			rlist = self._rlist = $(ul).appendTo(self._rbox);

		// 左边列表
		llist.opageablelist({
			data: opts.data,
			value: opts.value,
			displayField: opts.displayField,
			valueField: opts.valueField,
			width: (opts.odialogWidth - self._HGAP) / 2 + opts.leftGtRight,
			height: opts.odialogHeight - self._VGAP,
			
			select: function(event, ui) {
				rlist.olist("pushItem", ui.item);
			}
			
		});
		
		// 右边列表
		rlist.olist({
			data: [],
			displayField: opts.displayField,
			valueField: opts.valueField,
			valueSeparator: opts.valueSeparator,
			width: (opts.odialogWidth - self._HGAP) / 2 - opts.leftGtRight,
			height: opts.odialogHeight - self._VGAP,
			
			select: function(event, ui) {
				rlist.olist("popItem", ui.item);
			}
			
		});
		
	},
	
	/**
	 * 将rlist中用于显示的字段设置到输入域, 值字段设置到_curValue
	 */
	_doSetValue: function() {
		var self = this,
		values = [],
		displays = [];
		
		$.each(self._rlist.olist("option", "data"), function(i, n) {
			values.push(n[self.options.valueField]);
			displays.push(n[self.options.displayField]);
		});
		
		// 设置值
		self._curValue = values.join(self.options.valueSeparator);
		
		// 设置显示
		var ds = displays.join(self.options.valueSeparator);
		self.element.val(ds).attr({"title": ds});
	},
	
	/**
	 * @param value
	 */
	setValue: function(value) {
		var self = this;
		// 赋值时需先清空
		self._doClear();
		var vs = value.split(self.options.valueSeparator);
		$.each(this.options.data, function(i, item) {
			$.each(vs, function(i, n) {
				if(n == item[self.options.valueField]) {
					self._rlist.olist("pushItem", item);
				}
			});
		});
		self._doSetValue();
		self.validate();
	},
	
	getValue: function() {
		return this._curValue;
	},
	
	clear: function() {
		this._doClear();
		this.validate();
	},
	
	_doClear: function() {
		this._curValue = "";
		this.element.val("").removeAttr("title");
		this._rlist.olist("option", "data", []);
	}
	
});

})(jQuery);

