/*
 * Smile UI Box 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	smile.ui.core.js
 *	smile.ui.odialog.js
 */

(function($, undefined) {
	
var d = "<div>";
	
$.extend($.smile, {
	
	box: {
		/*
		{
			iconCls: "",
			title: "信息",
			content: "请填写提示信息内容!",
			ok: $.noop, // 点击确定是触发。
			cancel: $.noop // 点击取消时触发，confirm时有效。
		}
		*/
		dlg: function(options) {
			var settings = $.extend(true, {
				autoOpen: true,
				iconCls: "box-info",
				title: "标题",
				content: "请填写信息内容，选项名：content。",
				modal: true,
				width: 380,
				height: 220,
				resizable: false,
				buttons: {
					"确定": function() {
						$( this ).odialog( "destroy" );
						$( this ).remove();
						if(options && options.ok) {
							options.ok();
						}
					}
				}
			}, options);
			$(d).addClass("box " + settings.iconCls)
				.text(settings.content)
				.wrap(d)
				.parent()
				.odialog(settings);
		},
		// 成功提示框
		success: function(options) {
			this.dlg($.extend(true, {
				iconCls: "box-success",
				title: "成功",
				content: "请填写成功信息内容，选项名：content。",
			}, options));
		},
		// 信息提示框
		info: function(options) {
			this.dlg($.extend(true, {
				iconCls: "box-info",
				title: "提示",
				content: "请填写提示信息内容，选项名：content。",
			}, options));
		},
		// 警告对话框
		alert: function(options) {
			this.dlg($.extend(true, {
				iconCls: "box-alert",
				title: "警告",
				content: "请填写警告信息内容，选项名：content。",
			}, options));
		},
		// 确认对话框
		confirm: function(options) {
			this.dlg($.extend(true, {
				iconCls: "box-confirm",
				title: "确认",
				content: "请填写确认信息内容，选项名：content。",
				buttons: {
					"取消": function() {
						$( this ).odialog( "destroy" );
						$( this ).remove();
						if(options && options.cancel) {
							options.cancel();
						}
					}
				}
			}, options));
		},
		// 错误提示框
		error: function(options) {
			this.dlg($.extend(true, {
				iconCls: "box-error",
				title: "出错啦",
				content: "请填写错误信息内容，选项名：content。",
			}, options));
		},
		// 正在构建中...
		construction: function(options) {
			this.dlg($.extend(true, {
				iconCls: "box-construction",
				title: "构建",
				content: "正在建设中...",
			}, options));
		}
	}

});

})(jQuery);
