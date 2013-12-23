/*
 * Smile UI otree 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery.jstree.js
 *	smile.ui.olist4excludeinput.js
 */
(function($, undefined) {
	
var d = "<div>", 
	defaults = {
		core : {
			html_titles: true,
			animation: 200
		},
		themes : {
			theme : "apple",
			url : false,
			dots: true,
			icons: true
		},
		json_data : {
			data : []
		},
		ui : {
			select_limit: 1,
			select_multiple_modifier: "ctrl",
			select_range_modifier: "shift",
			selected_parent_close: "select_parent",
			selected_parent_open: true,
			select_prev_on_delete: true,
			disable_selecting_children: false,
			initially_select: []
		},
		checkbox : {
			override_ui: true,
			checked_parent_open: true,
			two_state: false,
			real_checkboxes: false,
			real_checkboxes_names: function (n) { 
				return [("check_" + (n[0].id || Math.ceil(Math.random() * 10000))), 1]; 
			}
		},
		types : {
			types : {
				// the default type
				"default" : {
					max_children	: -1,
					max_depth		: -1,
					valid_children: "all",

					// Bound functions - you can bind any other function here (using boolean or function)
					select_node : _selectable,
					// check_node : _selectable,
					// uncheck_node : _selectable,
					hover_node : _selectable
					//"open_node"	: true,
					//"close_node"	: true,
					//"create_node"	: true,
					//"delete_node"	: true
				}
			}
		},
		search : {
			search_method: "jstree_contains",
			case_insensitive: true,
			show_only_matches: false
		},
		plugins : [ "themes", "json_data", "ui", "hotkeys", "unique", "types", "search" ]
	};

function _selectable(n) {
	return n.attr("selectable") !== "false";
}

function adaptOption(options) {
	var settings = $.extend(true, {}, defaults, options);
	// 设置json数据源。
	settings.json_data.data = options.data;
	// 检测是否启用checkbox。
	if(!options.checkboxDisabled) {
		settings.plugins.push("checkbox");
	}
	return settings;
}

$.widget("smile.otree", $.smile.olist4excludeinput, {
	
	options: {
		selectableField: "selectable",
		stateField: "state",
		
		// adjacency、nested(未实现)、original
		model: "adjacency",
		adjacency: {
			parentIdField: "parentId",
			parent4Root: null
		},
		
		checkboxDisabled: true,
		checkbox: {
			two_state: false
		},
		
		// callback
		loaded: $.noop,
		afterOpen: $.noop,
		openNode: $.noop,
		afterClose: $.noop,
		closeNode: $.noop,
		selectNode: $.noop,
		deselectNode: $.noop,
		checkNode: $.noop,
		uncheckNode: $.noop
	},
	
	_create: function() {
		$.smile.olist4excludeinput.prototype._create.apply( this );
		var self = this, 
			ele = self.element,
			opts = self.options;
		
		ele.wrap(d)
			.parent()
			.css({
				overflow: "auto",
				height: opts.height
			})
			.wrap(d)
			.parent()
			.addClass("o-border-box ui-widget ui-widget-content ui-corner-all")
			.css({
				width: opts.width
			});
		
		if(this.options.model === "adjacency") {
			this.options.data = this._adjacencyTree(this.options.data);
		}
		
		var settings = adaptOption(opts);
	
		ele.bind("loaded.jstree", function (event, data) {
				$(this).find("li[selectable=false] > a").addClass("ui-state-disabled");
				self._trigger("loaded", event, data);
			})
			.bind("after_open.jstree", function (event, data) {
				self._trigger("afterOpen", event, data);
			})
			.bind("open_node.jstree", function (event, data) {
				self._trigger("openNode", event, data);
			})
			.bind("after_close.jstree", function (event, data) {
				self._trigger("afterClose", event, data);
			})
			.bind("close_node.jstree", function (event, data) {
				self._trigger("closeNode", event, data);
			})
			.bind("select_node.jstree", function (event, data) {
				self._trigger("selectNode", event, data);
			})
			.bind("deselect_node.jstree", function (event, data) {
				self._trigger("deselectNode", event, data);
			})
			.bind("check_node.jstree", function (event, data) {
				self._trigger("checkNode", event, data);
			})
			.bind("uncheck_node.jstree", function (event, data) {
				self._trigger("uncheckNode", event, data);
			})
			.jstree(settings);
	},
	
	_normalizeNode: function(n) {
		var self = this;
		return {
			attr : {
				id : n[self.options.valueField],
				selectable : n[self.options.selectableField]
			},
			metadata : n,
			// state : "open",
			data : {
				title : n[self.options.displayField],
				// a
				attr : {
					id : n[self.options.valueField] + "-a",
					href : "javascript:void(0)"
				}
			}
		};
	},
	
	// start adjacencyAdapter
	_adjacencyTree: function(d) {
		var self = this, 
			tree = [],
			roots = self._findRoots(d);
		$.each(roots, function(i, n) {
			var o = self._normalizeNode(n);
			self._fillChildren(o, d);
			tree.push(o);
		});
		return tree;
	},
	
	/**
	 * 查找树根节点。
	 * @param d
	 * @returns {Array}
	 */
	_findRoots: function(d) {
		var self = this, 
			roots = [];
		$.each(d, function(i, n) {
			if(n) {
				if (n[self.options.adjacency.parentIdField]
					== self.options.adjacency.parent4Root) {
					roots.push(n);
				}
			}
		});
		return roots;
	},
	
	_fillChildren: function (p, d) {
		var self = this;
		$.each(d, function(i, n) {
			if(n) {
				if (n[self.options.adjacency.parentIdField] === p.attr.id) {
					var o = self._normalizeNode(n);
					if (!p.children) {
						p.children = [];
					}
					p.children.push(o);
					self._fillChildren(o, d);
				}
			}
		});
		// 非叶子节点全部展开。
		if(p.children && p.children.length !== 0) {
			p.state = d[self.options.stateField];
		}
	},
	// end adjacencyAdapter
	
	invoke: function(methodName) {
		var args = Array.prototype.slice.call(arguments, 1);
		return this.element.jstree(methodName, args);
	},
	
	/**
	 * 
	 * 获取节点的原始数据。
	 * 
	 * @param node 树节点对象。
	 * @returns 该节点的原始数据。
	 */
	getData: function(node) {
		return $(node).data();
	},
	
	selectNode: function(node, check, event) {
		return this.element.jstree("select_node", node, check, event);
	},
	
	deselectNode: function(node) {
		return this.element.jstree("deselect_node", node);
	},
	
	toggleSelect: function(node) {
		return this.element.jstree("toggle_select", node);
	},
	
	deselectAll: function(context) {
		return this.element.jstree("deselect_all", context);
	},
	
	isSelected: function(node) {
		return this.element.jstree("is_selected", node);
	},
	
	getSelected: function(context) {
		return this.element.jstree("get_selected", context);
	},
	
	checkNode: function(node) {
		return this.element.jstree("check_node", node);
	},
	
	uncheckNode: function(node) {
		return this.element.jstree("uncheck_node", node);
	},
	
	checkAll: function() {
		return this.element.jstree("check_all");
	},
	
	uncheckAll: function() {
		return this.element.jstree("uncheck_all");
	},
	
	isChecked: function(node) {
		return this.element.jstree("is_checked", node);
	},
	
	getChecked: function(context, get_all) {
		return this.element.jstree("get_checked", context, get_all);
	},
	
	getUnchecked: function(context, get_all) {
		return this.element.jstree("get_unchecked", context, get_all);
	},
	
	showCheckboxes: function() {
		return this.element.jstree("show_checkboxes");
	},
	
	hideCheckboxes: function() {
		return this.element.jstree("hide_checkboxes");
	},
	
	getText: function(node) {
		return this.element.jstree("get_text", node);
	},
	
	search: function(str, skip_async) {
		return this.element.jstree("search", str, skip_async);
	},
	
	clearSearch: function() {
		return this.element.jstree("clear_search");
	}
	
});
	
})(jQuery);