/*
 * Smile UI oinputnumber 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *
 *	smile.ui.otextfield.js
 *
 */
(function($, undefined) {
	
// 只允许输入字符的正则表达式
var matcher = new RegExp(/[0-9-+\.]/),
	//触发按钮的宽度
	triggerWidth = 20;
	
$.widget("smile.oinputnumber", $.smile.otextfield, {
	
	options:{
		// 精度。
		decimal: 2,
		// 最大值。
		max: null,
		// 最小值。
		min: null,
		// 步长。
		step: 0.01,
		// 按pageUp/pageDown时，跳过的步长，step的倍数。
		page: 10,
		
		// 回调
		change: null,
		// spin开始时触发。
		start: null,
		// 旋转时触发。
		spin: null,
		// spin结束时触发。
		stop: null
	},
	
	_create : function() {
		$.smile.otextfield.prototype._create.apply( this );
		var self = this;
		
		self.element.addClass("o-oinputnumber");
		/**
		 * 覆盖spinner的_parse方法。
		 * @param value
		 * @returns
		 */
		$.ui.spinner.prototype._parse = function(value) {
			var t;
			if ( typeof value === "string" && value !== "" ) {
				value = + value.replace(/,/g, "");
			}
			return value === "" || isNaN( value ) ? null : value;
		}
		/**
		 * 覆盖spinner的_format方法。
		 * @param value
		 * @returns
		 */
		$.ui.spinner.prototype._format = function(value) {
			if ( value === "" ) {
				return "";
			}
			value = value.toFixed(self.options.decimal);
			if(value.length <= 3) {
		        return value;
		    }
		    if(!/^(\+|-)?(\d+)(\.\d+)?$/.test(value)) {
		    	return value;
		    }
		    var a = RegExp.$1,
		    	b = RegExp.$2,
		    	c = RegExp.$3;

		    var re = new RegExp();  
		    re.compile("(\\d)(\\d{3})(,|$)");
		    while(re.test(b)) {
		        b = b.replace(re, "$1,$2$3");
		    }
		    return a +""+ b +""+ c;
		}
		
		self.element.spinner({
			incremental: true,
			max: self.options.max,
			min: self.options.min,
			step: self.options.step,
			page: self.options.page,
			/*
			 * spinner提供的change会调用两次。
			change: function(event, data) {
				self._trigger("change", event, data);
			},
			*/
			start: function(event, data) {
				self._trigger("start", event, data);
			},
			spin: function(event, data) {
				self._trigger("spin", event, data);
			},
			stop: function(event, data) {
				self._trigger("stop", event, data);
			},
        });
		
		self.element.spinner("widget")
			.removeClass("ui-widget ui-widget-content ui-corner-all")
			.addClass("ui-corner-tr ui-corner-br")
			.on({
				contextmenu: function() {
					return false;
				},
				paste: function() {
					return false;
				},
				keypress: function(event) {
				 	if(event.charCode !== 0) {
				 		return matcher.test(Smile.keys[event.which]);
				 	}
				},
				change: function(event, data) {
					self._trigger("change", event, data);
				}
			});
		
		this._initEvent();
	},
	
	_initEvent: function() {
		var self = this;
		self.element.change(function() {
            self.element.spinner( "value", self.element.spinner( "value" ) );
        });
	},
	
	// input宽度，父类输入框的宽度 - trigger的宽度
	_inputWidth: function() {
		return $.smile.otextfield.prototype._inputWidth.apply( this ) - triggerWidth;
	},
	
	readOnly: function() {
		$.smile.otextfield.prototype.readOnly.apply( this );
		this.element.siblings().hide();
	},
	
	nonreadOnly: function() {
		$.smile.otextfield.prototype.nonreadOnly.apply( this );
		this.element.siblings().show();
	},
	
	setValue: function(value) {
		this.element.spinner( "value", value );
	},
	
	getValue: function() {
		return this.element.spinner( "value" );
	}
	
});

}(jQuery));