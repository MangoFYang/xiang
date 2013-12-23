/*
 * Smile UI olist 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.baselist.js
 */
(function($, undefined) {
	
$.widget("smile.olist", $.smile.obaselist, {
	
	options: {
		value: "",
		valueSeparator: ", ",
		autoRefresh: true
	},
	
	_init: function() {
		$.smile.obaselist.prototype._init.call(this);
		// 设置默认值
		this._initValue();
	},
	
	/**
	 * 设置初始值
	 */
	_initValue: function() {
		this.setValue(this.options.value);
	},	
	
	_setOption: function( key, value ) {
		var self = this;
		$.smile.obaselist.prototype._setOption.apply( self, arguments );
		switch (key) {
			case "data":
				if(self.options.autoRefresh) {
					self.refresh();
				}
				break;
		}
	},
	
	setValue: function(value) {
		var self = this,
			vs = value.split(this.options.valueSeparator);
		self.unselectAll();
		$.each(vs, function(i, n) {
			if($.trim(n) != "") {
				self.select(n);
			}
		});
	},
	
	getValue: function() {
		return $.map($("li."+this.options.selectedClass, this.element), function(n) {
			return $(n).data("o-list-item").hiddenValue;
		}).join(this.options.valueSeparator);
	},
	
	/**
	 * 重置到默认值
	 */
	reset: function() {
		this.setValue(this.options.value);
	},
	
	/**
	 * 清空
	 */
	clear: function() {
		this.unselectAll();
	},
	
	/**
	 * 添加数据
	 * @param item
	 */
	pushItem: function(item) {
		if(!$("#"+item[this.options.valueField], this.element).length) {
			this.options.data.push(item);
			if(this.options.autoRefresh) {
				this.refresh();
			}
		}
	},
	
	/**
	 * 删除数据
	 * @param {String|Object} item
	 */	
	popItem: function(item) {
		var self = this, 
			vf = self.options.valueField,
			isString = Smile.util.isString(item),
			data = $.map(self.options.data, function(n) {
				return (isString ? item : item[vf]) === n[vf] ? null : n;
			});
			this._setOption("data", data);
	}
	
});

})(jQuery);

