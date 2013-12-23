/*
 * Smile UI oFileupload 1.0.2
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
var fieldId = 100, 
	d = "<div>",
	span = "<span>",
	// xxx.txt，文件大小：10M，已上传：5M，上传速度：90K/S
	toolTipInfoTemplate = "{0}，文件大小：{1}，已上传：{2}，上传速度：{3}";

function getId() {
	return "fu-" + (++ fieldId);
}
/* fileupload
<div class="o-border-box o-unselect ui-widget o-form-item-ele-file ui-state-default ui-corner-all">
	<div class="o-form-item-ele-file-icon ui-icon ui-icon-arrowthick-1-n"></div>
	<div class="o-form-item-ele-file-text">添加文件</div>
	<input id="fileupload" type="file">
</div>
*/
/* fileupload detail
<div class="o-border-box o-unselect ui-corner-all o-form-item-ele-file-detail">
	<div class="o-form-item-ele-file-detail-filename">Java中的缓存技术该如何实现.docx</div>
	<div class="ui-icon ui-icon-close o-form-item-ele-file-detail-close"></div>
	<div id="pb" class="o-form-item-ele-file-detail-progressbar"></div>
	<div id="pb_txt" class="o-form-item-ele-file-detail-progress"><span>0</span>%</div>
	<div class="o-form-item-ele-file-detail-status">, 剩余时间：<span>00:01:30</span></div>
</div>
*/

// Google Chrome
// Apple Safari 5.0+
// Mozilla Firefox 3.6+
// Opera 11.0+
// Microsoft Internet Explorer 10.0+
$.widget("smile.ofileupload", $.smile.obase, {

	options: {
		label: "上传文件",
		// 上传路径
		url: null,
		// 最大允许文件字节大小。
		maxFileSize: 1024 * 1024 * 50, // 50M
		// 上传明细位置
		detailAppendTo: null,
		
		// 回调
		add: null,
		done: null,
		fail: null
	},
	
	_widget: null,
	// 上传文件详细信息。
	_uploadDetail: null,
	_xhr: null,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		
		var self = this,
			ele = self.element,
			opts = self.options,
			id = ele.attr("id") || getId();
		
		self._widget = ele.attr("id", id)
			.wrap(d)
			.before(function() {
				return $(d).addClass("o-form-item-ele-file-icon ui-icon ui-icon-arrowthick-1-n");
			})
			.before(function() {
				return $(d).addClass("o-form-item-ele-file-text").text(opts.label);
			})
			.parent()
			.addClass("o-border-box o-unselect ui-widget o-form-item-ele-file ui-state-default ui-corner-all");
		
		// 组件名称分别放入widget和ele中，key为xtype。
		self._widget.data("xtype", this.widgetName);
		ele.data("xtype", this.widgetName);
		
		ele.fileupload({
	    	url: opts.url,
	    	type: "POST",
	        dataType: "json",
	        // 禁止拖拽
	        dropZone: null,
	        // 禁止粘贴
	        pasteZone: null,
	        // 最大允许文件字节大小
	        maxFileSize: opts.maxFileSize,
	        // 计算和触发progress事件的最小时间间隔
	        progressInterval: 1000,
	    	multipart: true,
	    	// 自动上传
	    	autoUpload: true,
	    	// maxChunkSize: 1024 * 50,
	        sequentialUploads: true,
	        formAcceptCharset: "utf-8",
	        // 添加上传文件
	        add: function (e, data) {
	        	if(self._trigger("add", e, data)) {
	        		if(data.files[0].size > opts.maxFileSize) {
	        			Smile.box.alert({
	        				content: "上传文件大小不能超过50M!"
	        			});
	        		} else {
	        			self._createUploadDetail(e, data);
	        			self._xhr = data.submit();
	        		}
	        	}
	        },
	        // 上传中...
	        progress: function (e, data) {
	        	var detail = self._uploadDetail;
	        	var progress = parseInt(data.loaded / data.total * 100);
	        	// 更新进度。
	        	self._updateProgress(detail, progress);
	        	// 更新剩余时间。
		        detail["lefttime"].text(self._getLeftTime(e, data));
	        	// tooltip如果可用，则更新提示信息。
		        if(!detail["detailCt"].tooltip("option", "disabled")) {
		        	detail["detailCt"].tooltip("option", "content", self._getTooltipInfo(e, data));
		        }
		    },
		    // 上传完。
	        done: function(e, data) {
	        	var detail = self._uploadDetail;
	        	// 更新进度。
	        	self._updateProgress(detail, 100);
	        	
	        	// 禁用tooltip。
	        	detail["detailCt"].tooltip("disable");
	        	detail["detailCt"].off("mouseenter mouseleave");
	        	
	        	// 更新上传状态
	        	detail["statusCt"].css({
	        		"padding-left": "10px",
	        		"color": "red"
	        	}).text("上传完成");
	        	self._trigger("done", e, data);
	        },
	        // 失败时触发。
	        fail: function(e, data) {
	        	var detail = self._uploadDetail;
	        	detail["statusCt"].css({
	        		"padding-left": "10px",
	        		"color": "red"
	        	}).text("上传失败");
	        	self._trigger("fail", e, data);
	        }
	    });
		self._initEvent();
	},
	
	_initEvent: function() {
		this._hoverable(this.widget());
		this._on( this.widget(), {
			mousedown: function( event ) {
				$( event.currentTarget ).addClass( "ui-state-active" );
			},
			mouseup: function( event ) {
				$( event.currentTarget ).removeClass( "ui-state-active" );
			}
		});
	},
	
	widget: function() {
		return this._widget;
	},
	/**
	 * 
	 * 创建上传文件消息信息
	 * 
	 * @param e
	 * @param data
	 */
	_createUploadDetail: function(e, data) {
		var self = this, 
			detail = {},
			detailCt = $(d)
			.attr("title", "")
			.addClass("o-border-box o-unselect ui-corner-all o-form-item-ele-file-detail")
			// 文件名
			.append(
				$(d).addClass("o-form-item-ele-file-detail-filename")
					.text(data.files[0].name)
			)
			// 关闭
			.append(
				$(d).addClass("ui-icon ui-icon-close o-form-item-ele-file-detail-close")
					.on({
						click: function(event) {
							self._xhr.abort();
							detailCt.remove();
						},
						mouseenter: function( event ) {
							$( event.currentTarget ).addClass( "ui-icon-closethick" );
						},
						mouseleave: function( event ) {
							$( event.currentTarget ).removeClass( "ui-icon-closethick" );
						}
					})
			)
			// 进度条
			.append(function() {
				var pb = $(d).addClass("o-form-item-ele-file-detail-progressbar")
					.progressbar({
						value: 0,
						max: 100
					});
				detail["progressbar"] = pb;
				return pb;
			})
			// 进度条信息
			.append(function() {
				var progressCt = $(d).addClass("o-form-item-ele-file-detail-progress"),
					progress = $(span).text(0);
				progressCt.text("%").prepend(progress);
				detail["progress"] = progress;
				detail["progressCt"] = progressCt;
				return progressCt;
			})
			// 上传状态
			.append(function() {
				var statusCt = $(d).addClass("o-form-item-ele-file-detail-status"),
					lefttime = $(span);
				statusCt.text(", 剩余时间: ").append(lefttime);
				detail["lefttime"] = lefttime;
				detail["statusCt"] = statusCt;
				return statusCt;
			})
			.on({
				mouseenter: function( event ) {
					detailCt.tooltip("enable");
				},
				mouseleave: function( event ) {
					detailCt.tooltip("disable");
				}
			});
		
		detailCt.tooltip({
			content: this._getTooltipInfo(e, data)
		})
		detail["detailCt"] = detailCt;
		this._uploadDetail = detail;
		
		// 初始换上传信息容器
		if(this.options.detailAppendTo === null) {
			this.options.detailAppendTo = $(d).insertAfter(this.widget());
		} 
		$(this.options.detailAppendTo).empty();
		$(this.options.detailAppendTo).append(detailCt);
	},
	/**
	 * 获取提示信息
	 */
	_getTooltipInfo: function(e, data) {
		return Smile.util.formatString(toolTipInfoTemplate, 
					data.files[0].name, 
					this._appropriateUnit(data.total),
					this._appropriateUnit(data.loaded),
					this._appropriateUnit(data.bitrate / 8) + "/S")
	},
	/**
	 * 剩余时间
	 */
	_getLeftTime: function(e, data) {
		if(data.bitrate) {
			var ts = parseInt((data.total - data.loaded) * 8 / data.bitrate)
			return this._appropriateLength(parseInt(ts / 3600))  + ":" + 
				this._appropriateLength(parseInt(ts / 60) % 60) + ":" + 
				this._appropriateLength(ts % 60);
		}
	},
	
	/**
	 * 更新进度，进度条和进度信息。
	 */
	_updateProgress: function(detail, progress) {
		detail["progressbar"].progressbar("option", "value", progress);
        detail["progress"].text(progress);
	},
	/**
	 * 用于时分秒一位前补零。
	 */
	_appropriateLength: function(p) {
		return p < 10 ? "0" + p : p;
	},
	
	/**
	 * 调整到合适的速率单位
	 * 比如:
	 * 1000B转换为1K
	 * 1000K转换为1M
	 */
	_appropriateUnit: function(bytes) {
		if(!bytes) {
			return "";
		}
		if(bytes > 1000000 ) {
			return (bytes / 1000000).toFixed(2) + "MB";
		}
		if(bytes > 1000) {
			return (bytes / 1000).toFixed(2) + "KB";
		}
		return bytes.toFixed(2) + "B";
	}

});
	
})(jQuery);