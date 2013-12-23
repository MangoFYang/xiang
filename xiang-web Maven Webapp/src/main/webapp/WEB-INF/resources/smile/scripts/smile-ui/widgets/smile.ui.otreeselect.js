/*
 * Smile UI otreeselect 1.0.2
 *
 * @author yangfan, 2012-05-20
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
$.widget("smile.otreeselect", $.smile.otwobox, {
	
	options: {
		
		// tree选项
		model: "adjacency",
		selectableField: "selectable",
		adjacency: {
			parentIdField: "parentId",
			parent4Root: null
		},
		checkbox: {
			two_state: false
		}
	},
	
	// 记录当前选择的值，防止修改选项后未点确定而点取消时获取的值发生变化
	_curValue: "",
	
	_tf: undefined,
	_ltree: undefined,
	_rlist: undefined,
	
	_create: function() {
		$.smile.otwobox.prototype._create.call(this);
		var self = this,
			opts = self.options,
			it = "<input>",
			dv = "<div>",
			ul = "<ul>",
			// otextfield
			tf = self._tf = $(it).appendTo(self._lbox),
			// otree
			ltree = self._ltree = $(dv).appendTo(self._lbox),
			// olist
			rlist = self._rlist = $(ul).appendTo(self._rbox);
		
		// 搜索框
		tf.otextfield({
			label: "键入名称快速检索",
			hideLabel: false,
			labelAlign: "top",
			width: (opts.odialogWidth - self._HGAP) / 2 + opts.leftGtRight,
			labelWidth: 160,
			hideStar: true,
			
			autoValidation: false,
			validateEvent: "",
			allowBlank: true
		})
		.bind("keyup", function(e) {
			ltree.otree("clearSearch");
			ltree.otree("search", tf.otextfield("getValue"));
		});
		
		tf.otextfield("widget").css({"margin-bottom": "5px"});

		// 左边树
		ltree.otree({
			data: opts.data,
			width: (opts.odialogWidth - self._HGAP) / 2 + opts.leftGtRight,
			height: opts.odialogHeight - self._VGAP - 51,
			model: opts.model,
			displayField: opts.displayField,
			valueField: opts.valueField,
			selectableField: opts.selectableField,
			adjacency: {
				parentIdField: opts.adjacency.parentIdField,
				parent4Root: opts.adjacency.parent4Root
			},
			checkboxDisabled: false,
			checkbox: {
				two_state: opts.checkbox.two_state
			},
			checkNode: function(event, data) {
				var $li = data.rslt.obj;
				if(opts.checkbox.two_state) {
					if($li.attr("selectable") !== "false") {
						var nodeId = $li.attr("id");
						var item = {};
						item[opts.valueField] = nodeId;
						item[opts.displayField] = ltree.otree("getText", $li);
						rlist.olist("pushItem", item);
					}
				} else {
					$li.find("li").andSelf().each(function() {
						var $this = $(this);
						if($this.attr("selectable") !== "false") {
							var nodeId = $this.attr("id");
							var item = {};
							item[opts.valueField] = nodeId;
							item[opts.displayField] = ltree.otree("getText", $this);
							rlist.olist("pushItem", item);
						}
					});
				}
				rlist.olist("refresh");
			},
			uncheckNode: function(event, data) {
				var $li = data.rslt.obj;
				if(opts.checkbox.two_state) {
					rlist.olist("popItem", $li.attr("id"));
				} else {
					$li.find("li").andSelf().each(function() {
						rlist.olist("popItem", $(this).attr("id"));
					});
				}
				rlist.olist("refresh");
			},
			loaded: function() {
				// 树已初始化完成，设置默认值
				self.setValue(self.options.value);
			}
		});
		
		// 右边列表
		rlist.olist({
			data: [],
			displayField: opts.displayField,
			valueField: opts.valueField,
			width: (opts.odialogWidth - self._HGAP) / 2 - opts.leftGtRight,
			height: opts.odialogHeight - self._VGAP,
			valueSeparator: opts.valueSeparator,
			autoRefresh: false,
			
			select: function(event, ui) {
				rlist.olist("popItem", ui.item);
				ltree.otree("uncheckNode", $("#"+ui.itemEl.id, ltree));
				rlist.olist("refresh");
			}
			
		});
		
	},
	
	/**
	 * 推迟设置默认值, 等待树的数据加载完成手动设置默认值
	 */
	_initValue: function() {
		// this.value(this.options.value);
	},
	
	/**
	 * 将rlist中用于显示字段设置到输入域, 值字段设置到_curValue
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
		$.each(vs, function(i, n) {
			// 选中树中对应的节点，同时自动触发回调将节点设置到rlist中
			if($.trim(n) != "") {
				self._ltree.otree("checkNode", $("#"+n, self._ltree));
			}
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
		this._ltree.otree("uncheckAll");
		this._rlist.olist("option", "data", []);
		this._rlist.olist("refresh");
	}
	
});

})(jQuery);