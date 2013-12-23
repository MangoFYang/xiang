/*
 * Smile UI oTextfield 1.0.2
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
	return "tf-" + (++ fieldId);
}
	
/* widget
<div class="o-border-box ui-widget o-form-item" style="width: 305px;">
	<div class="o-form-item-ele o-form-item-ele-label o-unselect" style="width: 150px;">
		<label class="o-form-item-ele o-unselect" style="width: 135px; text-align: left;" for="tags">Label:</label>
		<div style="color: #FF0000; width: 15px;" class="o-form-item-ele o-unselect">*</div>		 
	</div>
	<div class="o-form-item-ele" style="width: 150px;">
		<div class="o-form-item-ele o-form-item-ele-label o-unselect" style="width: 15px;">preIText</div>
		<input id="tags" name="tags" style="width: 131px;" class="o-form-item-ele o-form-item-ele-text"></input>
		<div class="o-form-item-ele o-form-item-ele-label o-unselect" style="width: 15px;">sufIText</div>
	</div>
	<div class="o-form-invalid-icon" style="display: none"></div>
	<div class="ui-widget-overlay o-unselect" style="display: none;"></div>
	<div class="o-clear">...</div>
</div>
*/

/* widget invalid tip
<div class="o-border-box ui-state-error ui-corner-all o-form-invalid-tip">
<div class="o-form-invalid-tip-body">
	<ul>
		<li>asdasd</li>
		<li>asdasdasd</li>
		<li>213123</li>
		<li>fgjhjkljk</li>
	</ul>
</div>
*/

$.widget("smile.otextfield", $.smile.obase, {

	options: {
		
		label: "Label",
		hideLabel: false,
		labelSeparator: ":",
		// left、center、right、top
		labelAlign: "left",
		// dynamic
		labelWidth: 100,
		
		starText: "*",
		starCls: "o-form-item-ele-star",
		// star的宽度为8px
		starWidth: 12,
		
		preIText: "PT",
		hidePreI: true,
		preIWidth: 15,
		
		sufIText: "ST",
		hideSufI: true,
		sufIWidth: 15,
		
		width: 250,
		// 默认值
		value: "",
		readOnly: false,
		
		// 启用此选项将自动校验(绑定检验事件, validate、 validateEvent)
		autoValidation: true,
		// 校验器，返回true表示校验通过，其他表示错误信息
		validator: "fn",
		// 校验规则定义，预置校验规则参见smile.ui.core.js。
		vtype: {},
		// 校验规则的名称。
		// 和vtype的区别在于，vtypeAlias是预定义出校验规则或者各个规则的组合，
		// 起个别名，这种方式在使用标签时更为方便，一组规则可以应用到多个组件中，
		// 可以共享校验规则。
		// vtype是直接定义出校验规则，只对当前组件有效，不能实现共享校验规则。
		// vtypeAlias和vtype并不冲突，可单独使用，也可同时使用，
		// 推荐使用vtypeAlias，使用Smile.util.createVtypeAlias创建校验别名。
		vtypeAlias: null,
		allowBlank: true,
		blankText: "必输字段",
		validateEvent: "blur keyup"
		
	},
	
	_widget: undefined,
	_body: undefined,
	_mask: undefined,
	_label: undefined,
	_labelBody: undefined,
	_star: undefined,
	_preI: undefined,
	_sufI: undefined,
	_error: undefined,
	_errorTip: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		
		var self = this,
			ele = self.element,
			opts = self.options,
			// input和button宽度之和
			bodyWidth = self._bodyWidth(),
			// widget宽度
			widgetWidth = self._widgetWidth(),
			commonCss = "o-form-item-ele",
			d = "<div>",
			l = "<label>",
			id = ele.attr("id") || getId();
		
		self._widget = ele.attr("id", id)
			.css({width: self._inputWidth()})
			.addClass( "SmileField " + commonCss + " o-form-item-ele-text")
			.wrap(d)
			.before(function() {
				// preI
				if(!opts.hidePreI) {
					var preI = self._preI = $(d)
						.addClass(commonCss + " o-form-item-ele-label o-form-item-ele-pre-suf o-unselect")
						.css({
							width: opts.preIWidth
						})
						.text(opts.preIText);
					return preI;
				}
			})
			.after(function() {
				// sufI
				if(!opts.hideSufI) {
					var sufI = self._sufI = $(d)
						.addClass(commonCss + " o-form-item-ele-label o-form-item-ele-pre-suf o-unselect")
						.css({
							width: opts.sufIWidth,
							"text-align": "right"
						})
						.text(opts.sufIText);
					return sufI;
				}
			})
			.parent()
			.addClass(commonCss + " o-form-item-ele-body ")
			.css({
				width: bodyWidth
			})
			.wrap(d)
			.after(
				$(d).addClass("o-clear")
			)
			.after(
				// mask
				self._mask = $(d)
				.addClass("o-unselect ui-widget-overlay")
				.css({
					display: "none",
					cursor: "not-allowed"
				})
			)
			.after(function() {
				var timeoutId = undefined;
				// error
				return self._error = $(d)
					.addClass("o-form-invalid-icon")
					.css({
						display: "none"
					}).hover(function() {
						var offsetError = self._error.offset(),
							left = offsetError.left + 30,
							top = offsetError.top + 30;
						
						if(left + self._errorTip.width() > $(window).width()) {
							left = $(window).width() - self._errorTip.width() - 30;
						}
						
						self._errorTip.css({
							left: left,
						    position: "absolute",
						    top: top,
						    display: "block",
						    "z-index": 49999
						});
						self._errorTip
							.find("div.o-form-invalid-tip-body")
							.html(self._error.attr("data-errorqtip"));
						timeoutId = setTimeout(function() {
							self._errorTip.hide();
						}, 4000);
					}, function() {
						clearTimeout(timeoutId);
						self._errorTip.hide();
					});
			})
			.before(function() {
				// label
				if(!opts.hideLabel) {
					var label = self._label = $(d)
						.addClass(commonCss + " o-unselect o-form-item-ele-label")
						.css({
							width: opts.labelWidth
						});
					// label-body
					var labelBody = self._labelBody = $(l)
						.addClass(commonCss + " o-unselect")
						.text(opts.label + opts.labelSeparator)
						.css({
							width: opts.labelWidth - opts.starWidth,
							height: 17,
							"text-align": opts.labelAlign
						})
						.attr({
							"for": id,
							title: opts.label
						});
					label.append(labelBody)
					
					// star
					if(!opts.allowBlank) {
						var star = self._star = $(d)
							.addClass(commonCss + " o-unselect " + opts.starCls)
							.css({
								width: opts.starWidth,
								height: 17
							})
							.text(opts.starText);
						label.append(star);
					}
					return label;
				}
			})
			.parent()
			.addClass("o-border-box ui-widget o-unselect o-form-item")
			.css({width: widgetWidth})
		
		// 组件名称分别放入widget和ele中，key为xtype。
		self._widget.data("xtype", this.widgetName);
		ele.data("xtype", this.widgetName);
		self._body = $(".o-form-item-ele-body", self._widget);
		
		// error tip, singleton
		var errorTip = $("div.o-form-invalid-tip");
		if(errorTip.length === 0) {
			self._errorTip = $(d).appendTo(document.body)
				.addClass("ui-widget o-border-box ui-state-error ui-corner-all o-form-invalid-tip")
				.css({
					display: "none"
				})
				.append(
					$(d).addClass("o-form-invalid-tip-body")
				);
		} else {
			self._errorTip = errorTip;
		}
		
	},
	
	_init: function() {
		$.smile.obase.prototype._init.apply( this );
		// 初始化选项
		this._initOption();
		// 初始化事件
		this._initEvent();
		// 初始化默认值
		this._initValue();
	},
	
	_initOption: function() {
		if(this.options.readOnly) {
			this.readOnly();
		}
		if(this.options.disabled) {
			this.disable();
		}
	},
	
	_initEvent: function() {
		var self = this;
		if(self.options.autoValidation) {
			self.element.bind("validate " + self.options.validateEvent, function(e) {
				self.validate();
			});
		}
	},
	
	_initValue: function() {
		this.setValue(this.options.value);
	},
	
	_adjustWidth: function() {
		this._widget.width(this._widgetWidth());
		this._label.width(this.options.labelWidth);
		this._labelBody.width(this.options.labelWidth - this.options.starWidth);
		this._body.width(this._bodyWidth());
		this.element.width(this._inputWidth());
	},
	
	// input宽度，目前为输入框宽度
	_inputWidth: function() {
		var iw = this._bodyWidth();
		if(!this.options.hidePreI) {
			iw = iw - this.options.preIWidth;
		} 
		if(!this.options.hideSufI) {
			iw = iw - this.options.sufIWidth;
		}
		return iw;
	},
	
	// body宽度
	_bodyWidth: function() {
		if(this.options.hideLabel) {
			return this._widgetWidth();
		} else {
			if(this.options.labelAlign === "top") {
				return this._widgetWidth();
			}
			return this._widgetWidth() - this.options.labelWidth;
		}
	},
	
	// widget宽度，组件的宽度
	_widgetWidth: function() {
		return this.options.width;
	},
	
	_setOption: function( key, value ) {
		var self = this;
		$.Widget.prototype._setOption.apply( self, arguments );
		switch (key) {
			case "disabled":
				if(value) {
					self.element.attr("disabled", "disabled");
					self._clearInvalid();
				} else {
					self.element.removeAttr("disabled");
				}
				self._mask[value ? "show" : "hide"]();
				break;
			case "width":
			case "labelWidth":
				self._adjustWidth();
				break;
		}
	},
	
	widget: function() {
		return this._widget;
	},
	
	readOnly: function() {
		this.element.attr("readOnly", "readOnly");
		this.widget().addClass("o-readOnly");
	},
	
	nonreadOnly: function() {
		this.element.removeAttr("readOnly");
		this.widget().removeClass("o-readOnly");
	},
	
	setValue: function(value) {
		this.element.val(value);
	},
	
	getValue: function() {
		return this.element.val();
	},
	
	/**
	 * 重置到默认值
	 */
	reset: function() {
		this._clearInvalid();
		this.setValue(this.options.value);
	},
	
	/**
	 * 清空
	 */
	clear: function() {
		this._clearInvalid();
		this.element.val("");
	},
	
	/**
	 * 
	 * 校验顺序
	 * 1. allowBlank 是否允许为空，如果校验失败则不进行其他校验
	 * 2. validator 用户自定义同步校验函数
	 * 3. vtype 按照规则定义顺序校验
	 * 4. vtypeAlias 按照规则定义顺序校验
	 * 
	 * @returns {Array} 校验错误信息
	 */
	_getErrors: function() {
		var self = this, 
			opts = this.options,
			errors = [],
			value = self.getValue();
		if ($.trim(value).length < 1) {
            if (!opts.allowBlank) {
                errors.push(opts.blankText);
            }
            //if value is blank, there cannot be any additional errors
            return errors;
        }
		if($.isFunction(opts.validator)) {
            var msg = opts.validator.call(self, value);
            if (msg !== true) {
                errors.push(msg);
            }
        }
		if (opts.vtype) {
			$.each(opts.vtype, function(k, v) {
				var vt = Smile.vtypes[k];
				if(v !== false && !vt.handler(value, v)) {
					if($.isArray(v)) {
						var p = $.merge($.makeArray(vt.message), v);
						errors.push(Smile.util.formatString.apply(null, p));
					} else {
						errors.push(Smile.util.formatString(vt.message, v));
					}
				}
			});
        }
		if (opts.vtypeAlias) {
			var vta = $.smile.vtypes.alias[opts.vtypeAlias];
			$.each(vta, function(k, v) {
				var vt = Smile.vtypes[k];
				if(v !== false && !vt.handler(value, v)) {
					if($.isArray(v)) {
						var p = $.merge($.makeArray(vt.message), v);
						errors.push(Smile.util.formatString.apply(null, p));
					} else {
						errors.push(Smile.util.formatString(vt.message, v));
					}
				}
			});
        }
		return errors;
	},
	
	validate: function() {
		// 禁用状态，不用校验。
		if(this.options.disabled) {
			return;
		}
		var self = this,
			errs = self._getErrors(),
			isValid = errs.length === 0;
		if (isValid) {
			self._clearInvalid();
        } else {
        	self._markInvalid(errs);
        }
		return isValid;
	},
	
	_clearInvalid: function() {
		this._error.hide();
		this.element.removeClass("o-form-invalid-field");
	},
	
	_markInvalid: function(errors) {
		var errorsHtml = "<ul>";
		$.each(errors, function(i, n) {
			errorsHtml += "<li>"+n+"</li>";
		});
		errorsHtml += "</ul>";
		this._error.css({
			display: "block",
			left: this.options.width
		});
		this._error.attr({
			"data-errorqtip": errorsHtml
		});
		this.element.addClass("o-form-invalid-field");
	}
	
});
	
})(jQuery);