/*
 * Smile UI odialog 1.0.2
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
	
var d = "<div>", 
	iframe = "<iframe>";
	
// 不对IE6、IE7做主流支持
$.widget("smile.odialog", $.smile.obase, {
	
	options: {
		// 内嵌页面地址
		url: null,
		// 请求内嵌页面地址时传入的参数
		data: null,
		// 嵌入类型，
		// 可取值：
		// snippet(嵌入页面片段，片段开发模板：EmbeddedJSPTemplate.jsp)
		// page(嵌入整个页面，StandardJSPTemplate.jsp)
		embedType: null,
		closeOnEscape: false,
		resizable: true,
		draggable: true,
		autoOpen: true,
		width: 800,
		height: 600,
		minWidth: 300,
		minHeight: 240,
		maxWidth: false,
		maxHeight: false,
		modal: true,
		stack: true,
		title: "",
		zIndex: 1000,
		cachable: false,
		
		// 事件
		dragStart: $.noop,
		dragStop: $.noop,
		resizeStart: $.noop,
		resizeStop: $.noop
	},
	
	_iframe: undefined,
	_cached: false,
	_embedLoading: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.call(this);
		var self = this,
			opts = self.options;
		
		// 使内容紧贴窗口
		// self.element.css({padding: 0});
		
		if(opts.embedType != null) {
			// 若嵌入类型为page，则在容器中添加iframe。
			if(opts.embedType === "page") {
				self.element
					.css({
						overflow: "hidden"
					})
					.append(
							self._iframe = $(iframe, {
								frameborder: "no",
								border: "0"
							})
							.addClass("o-iframe")
					);
			}
		}
		var settings = $.extend(true, {}, opts, {
			open: function(event, data) {
				var embedType = opts.embedType;
				if(!opts.cachable) {
					self._cached = false;
				}
				if(embedType && !self._cached) {
					self._cached = true;
					switch (embedType) {
					case "page":
						// 生成url
						var url = opts.url;
						if(opts.data) {
							url = opts.url + "?" + $.param(opts.data);
						}
						self._iframe.attr("src", url);
						self._hide();
						break;
					case "snippet":
						Smile.ajax({
							url: opts.url,
							type: "GET",
							data: opts.data,
							hasContextPath: false,
							dataType: "html",
							onComplete: function(data, textStatus){
								self.element.empty();
								self.element.append(data);
								self._hide();
							}
						});
						break;
					default:
						Smile.box.alert({
						    content: Smile.util.formatString(
					    				Smile.mesageCode.dev.dev00004, "embedType", opts.embedType)
						});
						break;
					}
				}
			},
			dragStart: function(event, data) {
				self.element.css({visibility: "hidden"});
				self._trigger("dragStart", event, data);
			},
			dragStop: function(event, data) {
				self.element.css({visibility: "visible"});
				self._trigger("dragStop", event, data);
			},
			resizeStart: function(event, data) {
				self.element.css({visibility: "hidden"});
				self._trigger("resizeStart", event, data);
			},
			resizeStop: function(event, data) {
				// 窗口改变大小完成时触发窗口的resize事件调整布局。
				self.element.css({visibility: "visible"});
				Smile.util.resize();
				self._trigger("resizeStop", event, data);
			}
		});
		self.element.dialog(settings);
		if(opts.embedType != null) {
			self._embedLoading = $(d).addClass("o-dialog-loading").insertAfter(self.element);
		}
	},
	
	_init: function() {
	},
	
	_hide: function() {
		var self = this;
		setTimeout(function() {
			if(self.options.embedType != null) {
				self._embedLoading.fadeOut(500);
			}
		}, 1);
	},
	
	widget: function() {
		return this.element.dialog("widget");
	},
	
	close: function() {
		return this.element.dialog("close");
	},
	
	open: function() {
		return this.element.dialog("open");
		Smile.util.resize();
	},
	
	isOpen: function() {
		return this.element.dialog("isOpen");
	},
	
	moveToTop: function(force) {
		return this.element.dialog("moveToTop", force);
	},
	
	// 为了提高性能增加hide/show函数，尽量避免使用open/close函数
	isShow: function() {
		return this.widget().is(":visible");
	},
	
	hide: function(event) {
		this.widget().hide();
		this._trigger('hide', event);
	},
	
	show: function(event) {
		// 如果对话框未打开，则打开。
		// 如果已打开，则显示。
		if(!this.isOpen()) {
			this.open();
		} else {
			this.widget().show();
			this.moveToTop(true, event);
		}
		Smile.util.resize();
		this._trigger('show', event);
	},
	
	toggleShow: function() {
		if(!this.isShow()) {
			this.show();
		} else {
			this.hide();
		}
	},
	
	destroy: function() {
		this.element.dialog("destroy");
	}
		
});

})(jQuery);

