/*
 * Smile UI ocombobox 1.0.2
 *
 * @author yangfan, 2012-04-16
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otriggerinput.js
 */
(function($, undefined) {
	
// 不对IE6、IE7做主流支持
$.widget("smile.ocombobox", $.smile.olist4input, {
	
	options: {
		autoFocus: false,
		minLength: 0,
		delay: 0,
		menuMaxHeight: 353,
		
		// 事件
		focus: $.noop,
		select: $.noop,
		change: $.noop,
		open: $.noop,
		close: $.noop,
		search: $.noop,
		
		// 选项覆盖
		autoValidation: false
	},
	
	// 弹出菜单
	_menu: undefined,
	// 被选中的item
	_selectedItem: undefined,
	
	_create: function() {
		$.smile.olist4input.prototype._create.call(this);
		var self = this;
		self.element.autocomplete({
			autoFocus: self.options.autoFocus,
			minLength: self.options.minLength,
			delay: self.options.delay,
			// 字符键抬起和menu关闭状态时点击trigger会触发source方法
			source: function( request, response ) {
				if(self._selectedItem ? 
						self.element.val() !== self._selectedItem[self.options.displayField] :
						self.element.val() !== "") {
					self._selectedItem = undefined;
					self.validate();
				}
				response($.map(self.options.data, function(item) {
					return self._normalize(item, request.term);
				}));
			},
			focus: function(event, ui) {
				// 阻止focus时插入值
				self._trigger( "focus", event, ui);
				return false;
			},
			select: function(event, ui) {
				if ( false !== self._trigger( "select", event, ui ) ) {
					self.element.val( ui.item.value );
					self._selectedItem = ui.item.crudeItem;
					self._showSelectClose();
					self.validate();
				}
				return false;
			},
			change: function(event, ui) {
				self._trigger( "change", event, ui);
			},
			open: function(event, ui) {
				self._trigger( "open", event, ui);
			},
			close: function(event, ui) {
				self._trigger( "close", event, ui);
			},
			search: function(event, ui) {
				self._trigger( "search", event, ui);
			}
		});
		
		self._menu = self.element
			.autocomplete("widget")
			.css({
				"max-height": self.options.menuMaxHeight
			});
		var ac = self.element.data( "autocomplete" );
		// 重写_renderItem
		ac._renderItem = function( ul, item) {
			var a, li = $( "<li></li>" )
				.attr({
					id: item.hiddenValue
				})
				.data( "item.autocomplete", item )
				.append( a = $( "<a></a>" ).html( item.label ) )
				.appendTo( ul );
			
			/*
			// 使用item.valueField(隐藏域)比较
			if(self._selectedItem && self._selectedItem[self.options.valueField] == item.hiddenValue) {
				a.addClass("ui-state-active");
			}
			*/
			
			return li;
		};
		// 重写_resizeMenu
		ac._resizeMenu = function() {
			var ul = this.menu.element;
			ul.outerWidth( Math.max(
				// Firefox wraps long text (possibly a rounding bug)
				// so we add 1px to avoid the wrapping (#7513)
				ul.width( "" ).outerWidth() + 1,
				this.element.outerWidth()
			) + 19 );
		},
		
		self._trig.bind("click.ocombobox", function(e) {
			if ( self._menu.is( ":visible" ) ) {
				self.element.autocomplete( "close" );
				return;
			}
			// work around a bug (likely same cause as #5265)
			$( this ).blur();

			// 传入空字符串，显示所有数据。
			self.element.autocomplete( "search", "");
			self.element.focus();
		});
		
	},
	
	/**
	 * 根据条件(term)使用户数据标准化
	 * @param item 用户数据
	 * @param term 条件
	 * @returns 标准化的数据，ocombobox可直接使用
	 */
	_normalize: function( item, term ) {
		term = term || "";
		var displayValue = item[this.options.displayField];
		var hiddenValue = item[this.options.valueField];
		if(term === "") {
			return {
				label: displayValue,
				value: displayValue,
				hiddenValue: hiddenValue,
				crudeItem: item
			};
		} else {
			// 手动输入时term，点击trigger时term一定为空
			var matcher = new RegExp( $.ui.autocomplete.escapeRegex(term), "i" );
			if(matcher.test(displayValue)) {
				// 显示在menu中
				return {
					label: displayValue.replace(
							new RegExp(
									"(?![^&;]+;)(?!<[^<>]*)(" +
									$.ui.autocomplete.escapeRegex(term) +
									")(?![^<>]*>)(?![^&;]+;)", "gi"
							), '<strong style="color:#FF0000">$1</strong>' ),
					value: displayValue,
					hiddenValue: hiddenValue,
					crudeItem: item
				};
			}
		}
	},
	
	_setOption: function( key, value ) {
		$.smile.olist4input.prototype._setOption.apply( this, arguments );
		var self = this;
		switch (key) {
			case "data":
				self.clear();
				break;
			case "autoFocus":
			case "minLength":
			case "delay":
				self.element.autocomplete("option", key, value);
				break;
		}
	},
		
	setValue: function(value) {
		var self = this;
		self.clear();
		$.each(self.options.data, function(i, v) {
			if(value == v[self.options.valueField]) {
				// 设置显示域
				self.element.val(v[self.options.displayField]);
				// 数据缓存
				self._selectedItem = v;
				self._selectClose.show();
				return false;
			}
		});
	},
	
	getValue: function() {
		return this._selectedItem ? this._selectedItem[this.options.valueField] : "";
	},
	
	clear: function() {
		this._selectedItem = undefined;
		this.element.val("");
		this._hideSelectClose();
	},
	
	readOnly: function() {
		$.smile.olist4input.prototype.readOnly.apply( this );
		this._hideSelectClose();
	},
	
	nonreadOnly: function() {
		$.smile.olist4input.prototype.nonreadOnly.apply( this );
		if(this._selectedItem) {
			this._showSelectClose();
		}
	},
	
});

})(jQuery);

