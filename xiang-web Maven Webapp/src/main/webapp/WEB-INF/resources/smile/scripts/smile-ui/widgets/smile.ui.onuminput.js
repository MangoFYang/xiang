/*
 * Smile UI onuminput 1.0.2
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
var matcher = new RegExp(/[0-9-+\.]/);
	
$.widget("smile.onuminput", $.smile.otextfield, {
	
	options:{
		decimal: 4,
		negative:true,
	},
	
	_realValue: "",
	
	_create : function() {
		$.smile.otextfield.prototype._create.apply( this );
		var self = this, 
			options = this.options, 
			ele = this.element;
		ele.addClass("o-onuminput");
	},
	
	_initEvent: function() {
		$.smile.otextfield.prototype._initEvent.apply( this );
		var self = this;
		this.element.on({
			contextmenu: function() {
				return false;
			},
			paste: function() {
				return false;
			},
			focus: function() {
				self.element.val(self._realValue);
				self.element.get(0).selectionStart = 0;
				self.element.get(0).selectionEnd = self._realValue.length;
			},
			blur: function() {
				self._realValue = self.element.val(),
				self.element.val(self._format(self._realValue));
			},
			keypress: function(event) {
			 	if(event.charCode !== 0) {
			 		return matcher.test(Smile.keys[event.which]);
			 	}
			}
			/*
			,
			click: function() {
				$(document.body).append("<p>" + self._curpos() + "</p>");
			}
			*/
		});
		
	},
	
	_format: function(strNum) {
		if(strNum.length <= 3) {
	        return strNum;
	    }
	    if(!/^(\+|-)?(\d+)(\.\d+)?$/.test(strNum)) {
	    	return strNum;
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
	},
	
	// 获取光标位置
	_curpos:function(){
		var self = this, 
			options = this.options,
			ele = this.element,
			pos;
		if($.browser.msie){
			var tb = ele.get(0);
			tb.focus();
			var curRange = document.selection.createRange();//取得当前光标所在位置的TextRange
			curRange.collapse(false);
			curRange.setEndPoint("StartToStart", tb.createTextRange());
			pos = curRange.text.length;	           
		} else{
			pos = ele.get(0).selectionStart;
		}
		return pos;
	},
	
	/**
	 * 
	 * 校验顺序
	 * 1. allowBlank 是否允许为空，如果校验失败则不进行其他校验
	 * 2. validator 用户自定义同步校验函数
	 * 3. vtype 按照vtype定义按顺序校验
	 * 4. 金额校验
	 * 
	 * @returns {Array} 校验错误信息
	 */
	_getErrors: function() {
		return $.merge($.smile.otextfield.prototype._getErrors.apply( this ), 
				/^(\+|-)?(\d+)(\.\d+)?$/.test(this.element.val()) ? [] : ['请输入合法数据!']);
	},
	
	setValue: function(value) {
		this._realValue = value;
		this.element.val(this._format(value));
	},
	
	getValue: function() {
		return this._realValue;
	}
	
	/*
	_validate:function(event){
		var s,self = this, options = this.options,ele=this.element,keyCode,curpos=self._curpos();
		if($.browser.msie){
			keyCode=event.keyCode
		}else{
			if(event.charCode==0){
				keyCode=event.keyCode;
			}else{
				keyCode=event.charCode;
			}
		}					
		if(keyCode > 47 && keyCode < 58){
			s=ele.val();
			s=s.substring(0,curpos).concat(String.fromCharCode(keyCode)).concat(s.substring(curpos,s.length));	
			s=s.split('.');
			if(s[0].length>options.intlen){
				return false;
			}else if(s[1]&&s[1].length>options.decimal){
				return false;
			}
		}else{
			if(!options.negative&&keyCode==45){
				return false;
			}
				
			return true;
		}
	},
	 */
	
});

}(jQuery));