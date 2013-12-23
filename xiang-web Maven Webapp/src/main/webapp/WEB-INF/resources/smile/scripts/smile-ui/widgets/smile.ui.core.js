/*
 * Smile UI Core 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 */

(function($, undefined) {
	
// 阻止重复装载
// 这是一个问题，因为我们代理的现有功能
// 并且不希望多次代理他们
$.smile = $.smile || {};
window.Smile = window.Smile || {};
if ( $.smile.version ) {
	return;
}

var formatStringRe = /\{(\d+)\}/g,
	dateFormat = "yy-mm-dd",
	d = "<div>",
	errorCode = {
		// 服务器端响应解析为json对象时，解析失败，响应的数据格式错误。
		parsererror: "响应的数据格式错误。",
		// 404、500
		error: "服务器异常或者资源未找到。"
	},
	ONEDAY = 1000 * 3600 * 24;

$.extend($.smile, {
	
	version: "1.0.2",
	
	// 工具
	util : {
		
		/**
		 * 格式化日期，将Date对象转换成format格式的字符串
		 * @param {Date} date Date对象
		 * @returns format对应的日期字符串
		 */
		formatDate: function(date) {
			return $.datepicker.formatDate( dateFormat, date, null );
		},
		
		/**
		 * 解析日期字符串，将format格式的字符转解析成Date对象
		 * @param {String} value 和format相对应的日期字符串
		 * @returns Date对象
		 */
		parseDate: function(value) {
			return $.datepicker.parseDate( dateFormat, value, null );
		},
		
		/**
		 * 格式化字符串
		 * @param {String} format 需要格式化的字符串，比如：请输入一个长度介于 {0} 和 {1} 之间的字符串
		 * @param {String} p... 可变参数
		 * @returns {String} 替换后的字符串
		 */
		formatString: function(format) {
			var args = Array.prototype.slice.call(arguments, 1);
	        return format.replace(formatStringRe, function(m, i) {
	            return args[i];
	        });
		},
		
		/*
		 * 
		 * Depends: smile.pinyin.js
		 *
		hanzi2pinyin: function(haizi, onlyCaption) {
			return PinYin.go(haizi, onlyCaption);
		},
		*/
		
		/**
		 * 判断是否为Number类型
		 * @param {Object} v 待检测值
		 * @returns {Boolean} true表示是Number类型，反之不是
		 */
	    isNumber : function(v){
	        return typeof v === 'number' && isFinite(v);
	    },
	    
		/**
		 * 判断是否为String类型
		 * @param {Object} v 待检测值
		 * @returns {Boolean} true表示是String类型，反之不是
		 */
	    isString : function(v){
	        return typeof v === 'string';
	    },

		/**
		 * 判断是否为Boolean类型
		 * @param {Object} v 待检测值
		 * @returns {Boolean} true表示是String类型，反之不是
		 */
	    isBoolean : function(v){
	        return typeof v === 'boolean';
	    },
	    
	    /**
	     * 两个日期相差的天数
	     * @param {String} startDateStr 开始日期
	     * @param {String} endDateStr 结束日期
	     * @returns 相差天数
	     */
	    intevalDays : function(startDateStr, endDateStr) {
			var startDate = this.parseDate(startDateStr);
			var endDate = this.parseDate(endDateStr);
			var intevalDays = Math.abs((endDate - startDate) / ONEDAY);
			return intevalDays;
	    },
	    
		/**
		 * 触发窗口改变事件
		 * 使用之处：
		 * smile.ui.odialog.js
		 * smile.ui.otabs.js
		 */
		resize: function() {
			$(window).resize();
		},
		
		/**
		 * 
		 * 检测元素是否有滚动条
		 * 
		 * @param el 带检测元素
		 * @returns {Object}
		 */
		isScroll: function (el) {
	        // test targets
	        var elems = el ? [el] : [document.documentElement, document.body];
	        var scrollX = false, scrollY = false;
	        for (var i = 0; i < elems.length; i++) {
	            var o = elems[i];
	            // test horizontal
	            var sl = o.scrollLeft;
	            o.scrollLeft += (sl > 0) ? -1 : 1;
	            o.scrollLeft !== sl && (scrollX = scrollX || true);
	            o.scrollLeft = sl;
	            // test vertical
	            var st = o.scrollTop;
	            o.scrollTop += (st > 0) ? -1 : 1;
	            o.scrollTop !== st && (scrollY = scrollY || true);
	            o.scrollTop = st;
	        }
	        // ret
	        return {
	            scrollX: scrollX,
	            scrollY: scrollY
	        };
	    },
	    
	    /**
	     * 
	     * 将普通button美化成obutton组件。
	     * 此方法会自动调用，但是如果button为动态创建，则需要手动调用此方法。
	     * 
	     * @param context 范围，美化范围内的button，缩小范围可以提高效率，如果context未定义，则取document.body。
	     */
	    obutton: function(context) {
	    	$(context || document.body).find("button").obutton();
	    },
	    
	    /**
	     * 
	     * 创建校验别名，提供给Smile输入域组件校验数据使用，可参见输入域组件vtype选项。
	     * 将创建的校验规则下挂在$.smile.vtypes中
	     * 
	     * @param {String} alias 校验别名
	     * @param {Object} rules 校验规则，Smile.vtypes中基本校验规则组合使用
	     */
	    createVtypeAlias: function(alias, rules) {
	    	$.smile.vtypes.alias[alias] = rules;
	    }
	    
	},
	
	// 校验类型
	vtypes : {
		// 创建校验别名使用此命名空间。
		alias: {
			
		},
		required: {
			handler: function(v) {
				return v && $.trim(v).length < 1;
			},
			message: "必输字段"
		},
		email: {
			handler: function(v) {
				return /^(\w+)([\-+.][\w]+)*@(\w[\-\w]*\.){1,5}([A-Za-z]){2,6}$/.test(v);
			},
			message: "请输入正确的email地址，例如：user@example.com"
		},
		url: {
			handler: function(v) {
				return /(((^https?)|(^ftp)):\/\/([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?)/i.test(v);
			},
			message: "请输入正确的url地址，例如：http://www.example.com"
		},
		minLength: {
			handler: function(v, p) {
				v = $.trim(v);
				return v.length >= p;
			},
			message: "请输入一个长度最少是 {0} 的字符串"
		},
		maxLength: {
			handler: function(v, p) {
				v = $.trim(v);
				return v.length <= p;
			},
			message: "请输入一个长度最多是 {0} 的字符串"
		},
		rangeLength: {
			handler: function(v, p) {
				v = $.trim(v);
				return v.length >= p[0] && v.length <= p[1] ;
			},
			message: "请输入一个长度介于 {0} 和 {1} 之间的字符串"	
		},
		min: {
			handler: function(v, p) {
				return v >= p;
			},
			message: "请输入一个最小为 {0} 的值"	
		},
		max: {
			handler: function(v, p) {
				return v <= p;
			},
			message: "请输入一个最大为 {0} 的值"	
		},
		range: {
			handler: function(v, p) {
				return v >= p[0] && v <= p[1];
			},
			message: "请输入一个介于 {0} 和 {1} 之间的值"	
		},
		date: {
			handler: function(v, p) {
				return /^\d{4}[\/-]\d{2}[\/-]\d{2}$/.test(v);
			},
			message: "请输入合法的日期，格式：yyyy-mm-dd，例如：2012-01-01"
		}
	},
	
	/**
	 * 跳转到URL
	 * @param url 跳转到的URL
	 */
	redirect: function(url) {
		window.location.href = contextPath + url;
	},
	
	/**
	 * 对$.ajax的封装，兼容原生ajax选项。
	 * url选项默认添加上下文根, window.contextPath作为全局变量可以随时在JS代码中使用，
	 * 可以使用hasContextPath控制是否添加上下文根，默认为true，false表示不添加。
	 * 若要处理发送请求之后的动作，只用传入onComplete回调函数即可
	 * @param options ajax选项，options结构如下：
	 * 	{
	 * 		原生ajax选项,
	 * 		overlay: 是否需要请求期间拥有遮罩,
	 * 		onComplete: function(data, textStatus) {
	 * 			// 后续处理
	 * 		}
	 * 	}
	 */
	ajax: function(options) {
		delete options.success;
		delete options.error;
		var overlay = null;
		if(options.overlay) {
			overlay = $(d).css({"z-index": 50000}).addClass("ui-widget-overlay").appendTo(document.body);
		}
		// 默认所有请求前添加上下文根。
		if(options.hasContextPath !== false) {
			options.url = window.contextPath + options.url;
		}
		var settings = $.extend(true, {
			type: "POST",
			dataType: "json",
			async: true,
			data: {
				isXhr: true
			},
			success: function(data, textStatus) {
				if(overlay) {
					overlay.remove();
				}
				if($.isFunction(options.onComplete)) {
					options.onComplete(data, textStatus);
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				if(overlay) {
					overlay.remove();
				}
				$(d).html(XMLHttpRequest.responseText)
					.appendTo(document.body).odialog({
						title: textStatus,
						close: function(event) {
							$( this ).odialog("destroy");
							$( this ).remove();
						}
					});
			}
		}, options);
		return $.ajax(settings);
	},
	
	keys: {
		// 0-9
		48: 0, 49: 1, 50: 2, 51: 3, 52: 4, 53: 5, 54: 6, 55: 7, 56: 8, 57: 9,
		// a-z
		97: 'a', 98: 'b', 99: 'c', 100: 'd', 101: 'e', 102: 'f', 103: 'g', 104: 'h', 105: 'i', 106: 'j', 107: 'k', 108: 'l', 109: 'm', 110: 'n', 111: 'o', 112: 'p', 113: 'q', 114: 'r', 115: 's', 116: 't', 117: 'u', 118: 'v', 119: 'w', 120: 'x', 121: 'y', 122: 'z',
		// A-Z
		65: 'A', 66: 'B', 67: 'C', 68: 'D', 69: 'E', 70: 'F', 71: 'G', 72: 'H', 73: 'I', 74: 'J', 75: 'K', 76: 'L', 77: 'M', 78: 'N', 79: 'O', 80: 'P', 81: 'Q', 82: 'R', 83: 'S', 84: 'T', 85: 'U', 86: 'V', 87: 'W', 88: 'X', 89: 'Y', 90: 'Z',

		// ` - =
		96: '`', 45: '-', 61: '=',
		// ~ ! @ # $ % ^ & * ( ) _ +
		126: '~', 33: '!', 64: '@', 35: '#', 36: '$', 37: '%', 38: '&', 40: '(', 41: ')', 42: '*', 43: '+', 94: '^', 95: '_',
		// [ ] \ { } |
		91: '[', 93: ']', 92: '\\', 123: '{', 125: '}', 124: '|',
		// ; ' : "
		59: ';', 39: '\'', 58: ':', 34: '"',
		// , . / < > ?
		44: ',', 46: '.', 47: '/', 60: '<', 62: '>', 63: '?'
	}
	
});

Smile = $.smile;

})(jQuery);
