/*
 * Smile UI obaselist 1.0.2
 *
 * @author yangfan, 2012-04-16
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.olist4excludeinput.js
 */
(function($, undefined) {

// 不对IE6、IE7做主流支持
$.widget("smile.obaselist", $.smile.olist4excludeinput, {
	
	options: {
		multiSelect: false,
		selectedClass: "ui-state-active",
		hoverClass: "ui-state-hover",
		
		// callback
		unselect: $.noop,
		select: $.noop
	},
	
	_mask: undefined,
	_body: undefined,
	_widget: undefined,
	
	_create: function() {
		$.smile.olist4excludeinput.prototype._create.apply( this );
		var self = this,
			ele = self.element,
			opts = self.options,
			d = "<div>";
	
		ele.addClass("o-selectable o-unselect");
		self._widget = ele.wrap(d)
			.parent()
			.css({
				overflow: "auto",
				margin: "4px 4px 4px 0",
				height: opts.height - 10
			})
			.wrap(d)
			.after(
				// mask
				self._mask = $(d)
					.addClass("o-unselect ui-widget-overlay")
					.css({display: "none"})
			)
			.parent()
			.addClass("o-border-box ui-widget ui-widget-content ui-corner-all")
			.css({
				width: opts.width,
				height: opts.height,
				position: "relative"
			});
		
		self._body = ele.parent();
	},
	
	
	_init: function() {
		// 初始化事件
		this._initEvent();
		// 建立数据
		this.refresh();
	},

	_initEvent: function() {
		var self = this;
		// 初始化事件
		self.element.on({
			click: function( event ) {
				if($(this).hasClass(self.options.selectedClass)) {
					self.unselect(this);
					self._trigger("unselect", event, { 
						itemEl: this,
						item: $(this).data("o-list-item").crudeItem
					});
				} else {
					self.select(this);
					self._trigger("select", event, { 
						itemEl: this,
						item: $(this).data("o-list-item").crudeItem
					});
				}
			},
			mouseenter: function( event ) {
				$( event.currentTarget ).addClass( self.options.hoverClass );
			},
			mouseleave: function( event ) {
				$( event.currentTarget ).removeClass( self.options.hoverClass );
			}				
		}, "li");
	},
	
	/**
	 * 将data渲染成li列表，加入ul中。
	 * 渲染菜单时，标准化数据。
	 */
	_initData: function() {
		var self = this,
			data = this.options.data;
		self._renderMenu(self.element, $.map(data, function(n) {
			return self._normalize(n);
		}));
	},
	
	/**
	 * 使用户数据标准化
	 * @param item 用户数据
	 */
	_normalize: function( item ) {
		return {
			label: item[this.options.displayField],
			hiddenValue: item[this.options.valueField],
			crudeItem: item
		};
	},
		
	/**
	 * 渲染菜单
	 * @param ul 菜单容器
	 * @param items 菜单数据
	 */
	_renderMenu: function( ul, items ) {
		var self = this;
		$(self.element).empty();
		$.each( items, function( index, item ) {
			self._renderItemData( ul, item );
		});
	},
	
	/**
	 * 
	 * 渲染菜单项和数据
	 * 
	 * @param ul
	 * @param item
	 * @returns
	 */
	_renderItemData: function( ul, item ) {
		return this._renderItem( ul, item ).data( "o-list-item", item );
	},

	/**
	 * 渲染菜单项
	 * @param ul 菜单容器
	 * @param item 菜单项数据
	 * @returns 菜单项元素
	 */
	_renderItem: function( ul, item) {
		return $( "<li>" ).attr("id", item.hiddenValue).addClass("ui-corner-all").html( item.label ).appendTo( ul );
	},
	
	_setOption: function( key, value ) {
		var self = this;
		$.smile.obase.prototype._setOption.apply( self, arguments );
		switch (key) {
			case "disabled":
				self._mask[value ? "show" : "hide"]();
				break;
		}
	},
	
	/**
	 * 根据某个值获取菜单项元素
	 * @param value
	 * @returns
	 */
	_getItemEl: function(value) {
		return $("#"+value, this.element);
	},
	
	// public
	
	getData: function(node) {
		return $(node).data("o-list-item").crudeItem;
	},
	
	getSelected: function() {
		return this.element.find("li." + this.options.selectedClass);
	},
	
	/**
	 * 刷新数据
	 */
	refresh: function() {
		// 初始化列表
		this._initData();
	},
	
	setData: function(data) {
		this.options.data = data;
		this.refresh();
	},
	
	/**
	 * 选中元素
	 * @param {Object|String|HTML Element} value 选中元素
	 */
	select: function(value) {
		if(!this.options.multiSelect) {
			this.unselectAll();
		}
		var itemEl = Smile.util.isString(value) ? this._getItemEl(value) : 
			($.isPlainObject(value) ? this._getItemEl(value[this.options.valueField]) : value);
		$(itemEl).addClass(this.options.selectedClass);
	},
	
	/**
	 * 取消选中元素
	 * @param {Object|String|jQuery Object} value 取消选中元素
	 */
	unselect: function(value) {
		var itemEl = Smile.util.isString(value) ? this._getItemEl(value) : 
			($.isPlainObject(value) ? this._getItemEl(value[this.options.valueField]) : value);
		$(itemEl).removeClass(this.options.selectedClass);
	},
	
	/**
	 * 选中所有元素, 只读multiSelect为true是生效。
	 */
	selectAll: function() {
		if(!this.options.multiSelect) {
			return;
		}
		this.element.find(">li").addClass(this.options.selectedClass);
	},
	
	/**
	 * 取消所有元素
	 */
	unselectAll: function() {
		this.element.find(">li").removeClass(this.options.selectedClass);
	},
	
	widget: function() {
		return this._widget;
	}
	
});

})(jQuery);

