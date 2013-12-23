/*
 * Smile UI oCheckboxRadio 1.0.2
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
	
// 产生全局ID
var fieldId = 100;
function getId() {
	return "cr-" + (++ fieldId);
}

/* widget
<div class="o-border-box o-unselect ui-widget o-form-item-ele-checked">
	<input type="radio" id="radio1" name="radio11"/>
	<label for="radio1">radio1</label>
</div>
*/
$.widget("smile.ocheckboxradio", $.smile.obase, {

	options: {
		label: "Label",
		value: "",
		
		// 初始化时是否选中
		checked: false,
		
		// 事件
		// 选中时触发
		check: null,
		// 取消选中时触发
		uncheck: null
	},
	
	_label: undefined,
	_box: undefined,
	_icon: undefined,
	_widget: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		
		var self = this,
			ele = self.element,
			opts = self.options,
			div = "<div>",
			span = "<span>",
			id = ele.attr("id") || getId();
		
		self._widget = ele.attr("id", id)
			.wrap(div)
			.after(function() {
				return self._label = $(span).text(opts.label);
			})
			.before(function() {
				// 选择框
				return self._box = $(div)
					.addClass("o-form-item-ele-checked-box ui-state-default")
					.append(self._icon = $(span).addClass("ui-icon o-blank-icon"));
			})
			.parent()
			.addClass( "o-border-box o-unselect ui-widget o-form-item-ele-checked");
		
		// 组件名称分别放入widget和ele中，key为xtype。
		self._widget.data("xtype", this.widgetName);
		ele.data("xtype", this.widgetName);
		
		// 初始化事件
		this._initEvent();
	},
	
	_init: function() {
		// 初始化默认值
		this._initValue();
	},
	
	_initEvent: function() {
		var self = this;
		self._widget.on("mousedown", function(event) {
				self.element.click();
				if(self.element.is(":checked")) {
					self.doCheckEffect();
					self._trigger("check", event, {
						target: self.element
					});
				} else {
					self.doUncheckEffect();
					self._trigger("uncheck", event, {
						target: self.element
					});
				}
			})
			.on("mouseover." + this.widgetName, function() {
				self._box.addClass("ui-state-hover");
			})
			.on("mouseout." + this.widgetName, function() {
				self._box.removeClass("ui-state-hover");
			});
		
	},
	
	_initValue: function() {
		this.setValue(this.options.value);
		if(this.options.checked) {
			this.element.attr("checked", "checked");
			this.doCheckEffect();
		}
	},
	
	isChecked: function() {
		return this.element.is(":checked");
	},
	
	check: function() {
		if(!this.isChecked()) {
			this.widget().mousedown();
		}
	},
	
	doCheckEffect: function() {
		this._box.addClass("ui-state-active");
	},
	
	doUncheckEffect: function() {
		this._box.removeClass("ui-state-active");
	},
	
	widget: function() {
		return this._widget;
	},
	
	setValue: function(value) {
		this.element.val(value);
	},
	
	getValue: function() {
		return this.element.val();
	},
	
});
	
})(jQuery);

/*
 * Smile UI oCheckbox 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.ocheckboxradio.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {

	$.widget("smile.ocheckbox", $.smile.ocheckboxradio, {

		_create: function() {
			$.smile.ocheckboxradio.prototype._create.apply( this );
			this._box.addClass("o-form-item-ele-checkbox");
		},
		
		uncheck: function() {
			if(this.isChecked()) {
				this.widget().mousedown();
			}
		},
		
		doCheckEffect: function() {
			$.smile.ocheckboxradio.prototype.doCheckEffect.apply( this );
			this._icon.addClass("ui-icon-check").removeClass("o-blank-icon");
		},
		
		doUncheckEffect: function() {
			$.smile.ocheckboxradio.prototype.doUncheckEffect.apply( this );
			this._icon.addClass("o-blank-icon").removeClass("ui-icon-check");
		}
		
	});
	
	$.extend($.smile.ocheckbox, {
		
		/**
		 * 
		 * 获取选中的checkbox的值
		 * @param {String} name checkbox的name属性。
		 * @param {jQuery Object} context 可选参数，未定义默认为document.body， checkbox所在的范围。
		 * 
		 */
		getValue: function(name, context) {
			return $.map($("input[type=checkbox][name='"+name+"']:checked", context || document.body), function(n) {
			    return $(n).val();
			});
		}
		
	});
		
})(jQuery);

/*
 * Smile UI oRadio 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.ocheckboxradio.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {
	
	$.widget("smile.oradio", $.smile.ocheckboxradio, {
		
		_create: function() {
			$.smile.ocheckboxradio.prototype._create.apply( this );
			this._box.addClass("o-form-item-ele-radio");
		},
		
		doCheckEffect: function() {
			$("input[type=radio][name=" + this.element.attr("name") + "]").each(function() {
				if($(this).hasClass("SmileUI")) {
					$(this).oradio("doUncheckEffect");
				}
			});
			$.smile.ocheckboxradio.prototype.doCheckEffect.apply( this );
			this._icon.addClass("ui-icon-radio-off").removeClass("o-blank-icon");
		},
		
		doUncheckEffect: function() {
			$.smile.ocheckboxradio.prototype.doUncheckEffect.apply( this );
			this._icon.addClass("o-blank-icon").removeClass("ui-icon-radio-off");
		}

	});
	
	$.extend($.smile.oradio, {
		
		/**
		 * 
		 * 获取选中的radio的值
		 * @param {String} name radio的name属性。
		 * @param {jQuery Object} context 可选参数，未定义默认为document.body， radio所在的范围。
		 * 
		 */
		getValue: function(name, context) {
			return $("input[type=radio][name='"+name+"']:checked", context || document.body).val();
		}
		
	});
		
})(jQuery);

