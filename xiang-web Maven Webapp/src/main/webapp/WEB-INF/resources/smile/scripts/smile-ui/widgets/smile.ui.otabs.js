/*
 * Smile UI otabs 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 */
(function($, undefined) {
	
var SNIPPET = "snippet", 
	PAGE = "page",
	ul = "<ul>",
	d = "<div>",
	iframe = "<iframe>",
	tabTemplate = '<li><a href="{0}" title="{1}">{2}</a><span class="ui-icon ui-icon-close {3}"></span></li>',
	
	// tab选项模板
	tabOptionTemplate = {
		caption: "Tab Caption",
		tabId: null,
		url: null,
		data: null,
		embedType: "snippet",
		closable: false
	};
	
// 不对IE6、IE7做主流支持
$.widget("smile.otabs", $.smile.obase, {
	
/**
<div id="otab1">
	<ul>
		<li><a href="#otabs-1">Proin dolor</a></li>
		<li><a href="#otabs-2">Nunc tincidunt</a></li>
	</ul>
	<div id="otabs-1">
		<p>tabs-1.</p>
	</div>
	<div id="otabs-2">
		<p>tabs-2.</p>
	</div>
</div>
 */
	
	options: {
		// tab页的具体定义, 结构如下:
		/**
		[{
			caption: "tab页显示的名称",
			tabId: "指向tab的具体内容元素",
			url: "内嵌页面地址",
			data: "请求内嵌页面地址时传入的参数",
			// 嵌入类型，
			// 可取值：
			// snippet(嵌入页面片段，片段开发模板：EmbeddedJSPTemplate.jsp)
			// page(嵌入整个页面，StandardJSPTemplate.jsp)
			embedType: "嵌入类型",
			closable: "可关闭的"
		}, {
		  ...
		}]
		 */
		items: [],
		// tab页的方向，可取值：top、bottom、vertical。
		tabsDirection: "top",
		
		// 回调
		select: null,
		load: null,
		show: null
	},
	
	_ul: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		
		var self = this,
			opts = self.options,
			ele = self.element;
		
		ele.prepend(self._ul = $(ul));
		
		$.each(opts.items, function(i, n) {
			if($.isEmptyObject(n)) {
				return true;
			}
			var tabOption = $.extend(true, {}, tabOptionTemplate, n);
			// 如果只在JS中定义tab，而没有HTML容器，则自动生成。
			if($("#" + tabOption.tabId).length === 0) {
				ele.append($(d, {
					id: tabOption.tabId
				}).addClass("ui-tabs-hide"));
			}
			// 若嵌入类型为page，则在容器中添加iframe。
			if(tabOption.embedType === "page") {
				$("#" + tabOption.tabId)
				.css({
					overflow: "hidden"
				})
				.append(n.iframe = $(iframe, {
					frameborder: "no",
					border: "0"
				})
				.addClass("o-iframe"));
				tabOption.url = null;
			}
			// 生成tab表头。
			// 生成url
			var url = null;
			if(tabOption.url) {
				url = tabOption.url;
				if(tabOption.data) {
					url = url + "?" + $.param(tabOption.data);
				}
			} else {
				url = "#" + tabOption.tabId;
			}
			self._ul.append($(Smile.util.formatString(
				// 字符串模板。
				tabTemplate,
				// tab的内容，预定义内容或者嵌入内容。
				url,
				// 内容容器，规定在使用嵌入页面时也必须有内容容器。
				tabOption.tabId,
				// tab的标题
				tabOption.caption,
				// 是否可关闭
				tabOption.closable ? "" : "o-hidden")));
		});
		
		self.element.tabs({
			active: false,
			collapsible: true,
			cache: true,
			event: "click",
			show: false,
			ajaxOptions: {
				error: function( xhr, status, index, anchor ) {
					$(anchor.hash).html(xhr.responseText);
				}
			},
			beforeActivate: function(event, ui) {
				ui.newPanel.addClass("opacity0");
			},
			activate: function(event, ui) {
				ui.newPanel.removeClass("opacity0");
				Smile.util.resize();
			},
			show: function(event, ui) {
				self._trigger("show", event, ui);
			},
			load: function(event, ui) {
				self._trigger("load", event, ui);
			},
			select: function(event, data) {
				var item = self.options.items[data.index];
				// 内嵌页面，并且未显示过，则设置iframe的src属性，否则忽略。
				if(item.embedType === "page" && !item["iframe"].data("initated")) {
					// 生成url
					var url = item.url;
					if(item.data) {
						url = url + "?" + $.param(item.data);
					}
					item["iframe"].attr("src", url);
					item["iframe"].data("initated", true);
				}
				self._trigger("select", event, data);
			}
		});
		
		// vertical Tabs functionality
		if(opts.tabsDirection === "vertical") {
			self.widget().addClass( "ui-tabs-vertical ui-helper-clearfix" );
			self._ul.addClass("ui-tabs-vertical-nav ui-corner-left").removeClass("ui-corner-top");
		}
		
		// bottom Tabs functionality
		if(opts.tabsDirection === "bottom") {
			self._ul.after('<div class="tabs-spacer"></div>');
			self.widget().addClass( "ui-tabs-bottom" )
			self._ul.addClass("ui-tabs-bottom-nav")
				.find("li").andSelf().removeClass( "ui-corner-all ui-corner-top" ).addClass( "ui-corner-bottom" );
			self._ul.appendTo( self.widget() );
		}
		
	},
	
	_init: function() {
		this.element.tabs("option", "active", 0);
	},
	
	invoke: function(methodName) {
		var args = Array.prototype.slice.call(arguments, 1);
		return this.element.tabs(methodName, args);
	},
	
	select: function(index) {
		return this.element.tabs("option", "active", index);
	},
	
	load: function(index) {
		return this.element.tabs("load", index);
	},
	
	length: function() {
		return this.element.tabs("length");
	},
	
	abort: function() {
		return this.element.tabs("abort");
	},
	
	enable: function(index) {
		return this.element.tabs("enable", index);
	},
	
	disable: function(index) {
		return this.element.tabs("disable", index);
	},
	
	getSelected: function() {
		return this.element.tabs("option", "active");
	},

	widget: function() {
		return this.element.tabs("widget");
	}
	
});

})(jQuery);

