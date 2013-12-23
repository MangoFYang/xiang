/*
 * Smile UI otable 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.obase.js
 */
(function($, undefined) {
	
var d = "<div>",
	span = "<span>",
	a = "<a>";

// 不对IE6、IE7做主流支持
$.widget("smile.otable", $.smile.obase, {
	
/**
<div class="o-table-container ui-widget">
	<div class="o-table-titlebar ui-widget-header ui-corner-top">
		<span class="o-table-title">我是Table</span>
		<a href="javascript:void(0)" style="float: right;"><span class="ui-icon ui-icon-circle-triangle-n"></span></a>
	</div>
	<div class="o-table-toolbar ui-state-default"></div>
	<div class="o-table-view">
		<table class="o-table">
			<tr class="ui-widget-content">
				<td><h:input id="olistselect1" /></td>
				<td><h:input id="olistselect2" /></td>
			</tr>
			<tr class="ui-widget-content">
				<td><h:input id="olistselect3" /></td>
				<td><h:input id="olistselect4" /></td>
			</tr>
		</table>
	</div>
	<div class="o-table-toolbar ui-state-default ui-corner-bottom"></div>
</div>
*/
	
	options: {
		caption: "oTable Title",
		collapsible: true,
		// 默认是否收缩。
		collapsing: false,
		hideCaption: false,
		hideTopToolbar: false,
		hideBottomToolbar: false,
		toolbarAlign: "left",
		
		clearable: true,
		resetable: true
	},
	
	_widget: undefined,
	_caption: undefined,
	_topToolbar: undefined,
	_bottomToolbar: undefined,
	_trArray: undefined,
	_collapseBtn: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		var self = this,
			opts = self.options,
			ele = self.element;
		
		self._trArray = ele.find("tr").addClass("ui-widget-content");
		
		self._widget = ele.addClass("o-table")
			.wrap(d)
			.parent()
			.addClass("o-table-view")
			.wrap(d)
			.parent()
			.addClass("o-border-box o-table-container ui-widget")
			.append(function() {
				if(!opts.hideBottomToolbar) {
					self._bottomToolbar = $(d)
						.css({"text-align": opts.toolbarAlign})
						.addClass("o-table-toolbar ui-state-default ui-corner-bottom");
					return self._bottomToolbar;
				}
			})
			.prepend(function() {
				if(!opts.hideTopToolbar) {
					self._topToolbar = $(d)
						.addClass("o-table-toolbar ui-state-default");
					if(opts.resetable) {
						$(d, {
							title: "重置"
						})
						.addClass("o-table-toptoolbar-button ui-corner-all")
						.hover(function() {
							$(this).addClass("ui-state-hover");
						}, function() {
							$(this).removeClass("ui-state-hover");
						})
						.bind("click."+self.widgetName, function() {
							self.reset();
						})
						.append($(span).addClass("ui-icon ui-icon-refresh"))
						.appendTo(self._topToolbar);
					}
					if(opts.clearable) {
						$(d, {
							title: "清空"
						})
						.addClass("o-table-toptoolbar-button ui-corner-all")
						.hover(function() {
							$(this).addClass("ui-state-hover");
						}, function() {
							$(this).removeClass("ui-state-hover");
						})
						.bind("click."+self.widgetName, function() {
							self.clear();
						})
						.append($(span).addClass("ui-icon ui-icon-trash"))
						.appendTo(self._topToolbar);
					}
					return self._topToolbar;
				}
			})
			.prepend(function() {
				if(!opts.hideCaption) {
					self._caption = $(d)
						.addClass("o-table-titlebar ui-widget-header ui-corner-top")
						.append($(span).addClass("o-table-title").html(opts.caption));
					
					// 收缩
					if(opts.collapsible) {
						self._caption.append(
							$(a, {href: "javascript:void(0)"})
							.append(
								self._collapseBtn = $(span).css({float: "right"})
									.addClass("ui-icon ui-icon-circle-triangle-n")
									.bind("click."+self.widgetName, function(e) {
										if ($(this).hasClass('ui-icon-circle-triangle-n')) {
											$(this).removeClass("ui-icon-circle-triangle-n").addClass("ui-icon-circle-triangle-s");
											self.element.hide();
										} else {
											$(this).removeClass("ui-icon-circle-triangle-s").addClass("ui-icon-circle-triangle-n");
											self.element.show();
										}
										return false;
									})
							)
							.hover(function() {
								$(this).addClass("ui-state-hover");
							}, function() {
								$(this).removeClass("ui-state-hover");
							})
						)
					}

					return self._caption;
				} else {
					if(self._topToolbar) {
						self._topToolbar.addClass("ui-corner-top");
					}
				}
			});
	},
	
	_init: function() {
		if(this.options.collapsing && this._collapseBtn) {
			this._collapseBtn.click();
		}
	},
	
	addButton: function(option) {
		$("<button>")
			.attr("id", option.id)
			.obutton({label: option.label || "label"})
			.click(option.click)
			.css({
				"margin-left": "4px"
			})
			.appendTo(this._bottomToolbar);
	},
	
	clear: function() {
		$.each(this.element.find("input.SmileField"), function(i, field) {
			$(field)[$(field).data("xtype")]("clear");
		});
	},
	
	reset: function() {
		$.each(this.element.find("input.SmileField"), function(i, field) {
			$(field)[$(field).data("xtype")]("reset");
		});
	},
	
	serialize: function() {
		var valid = true, 
			serialize = {};
		$.each(this.element.find("input.SmileField"), function(i, field) {
			if(!$(field)[$(field).data("xtype")]("validate")) {
				valid = false;
				return false;
			}
			serialize[field.name || field.id] = $(field)[$(field).data("xtype")]("getValue");
		});
		return valid ? serialize : false;
	},
	
	widget: function() {
		return this._widget;
	}
	
});

})(jQuery);

