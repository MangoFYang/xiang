/*
 * Smile UI otreeselectsingle 1.0.2
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
	
$.widget("smile.otreeselectsingle", $.smile.osinglebox, {
	
	options: {
		// tree选项
		model: "adjacency",
		selectableField: "selectable",
		adjacency: {
			parentIdField: "parentId",
			parent4Root: null
		},

		//覆盖选项
		title: "oTreeselectsingle Title",
		
		// 回调
		select: null
	},
	
	_tf: undefined,
	_tree: undefined,
	
	_create: function() {
		$.smile.osinglebox.prototype._create.call(this);
		var self = this,
			opts = self.options,
			it = "<input>",
			dv = "<div>",
			ul = "<ul>",
			// otextfield
			tf = self._tf = $(it).appendTo(self._box),
			// otree
			tree = self._tree = $(dv).appendTo(self._box);
		
		// 搜索框
		tf.otextfield({
			label: "键入名称快速检索",
			hideLabel: false,
			labelAlign: "top",
			width: opts.odialogWidth - self._HGAP,
			labelWidth: 160,
			hideStar: true,
			
			autoValidation: false,
			validateEvent: "",
			allowBlank: true
		})
		.bind("keyup", function(e) {
			tree.otree("clearSearch");
			tree.otree("search", tf.otextfield("getValue"));
		});
		
		tf.otextfield("widget").css({"margin-bottom": "5px"});

		// 左边树
		tree.otree({
			data: opts.data,
			width: (opts.odialogWidth - self._HGAP),
			height: opts.odialogHeight - self._VGAP - 51,
			model: opts.model,
			displayField: opts.displayField,
			valueField: opts.valueField,
			selectableField: opts.selectableField,
			ui : {
				select_limit: 1
			},
			adjacency: {
				parentIdField: opts.adjacency.parentIdField,
				parent4Root: opts.adjacency.parent4Root
			},
			checkboxDisabled: true,
			selectNode: function(event, data) {
				self._odialog.odialog("hide");
				self._setValue();
				self._trigger("select", event, data);
			},
			loaded: function() {
				// 树已初始化完成，设置默认值
				self.setValue(self.options.value);
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
	 * 内部使用设置值
	 * 将选中节点数据放入this._nodeData中并填写输入域相关信息。
	 */
	_setValue: function() {
		this._nodeData = this._tree.otree("getData", this._tree.otree("getSelected"));
		var text = this._nodeData[this.options.displayField];
		this.element.val(text).attr({"title": text});
	}
	
});

})(jQuery);