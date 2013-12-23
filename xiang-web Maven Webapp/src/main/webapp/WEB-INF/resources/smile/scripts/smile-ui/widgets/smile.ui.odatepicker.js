/*
 * Smile UI odatepicker 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otriggerinput.js
 *
 *	不对IE6、IE7做主流支持
 */
(function($, undefined) {

var cur_ins = null;

$.widget("smile.odatepicker", $.smile.otriggerinput, {
	
	options: {
		
		// 覆盖选项
		triggerCls: "ui-icon-calendar",
		autoValidation: true,
		allowBlank: true,
		validateEvent: "keyup",
		vtype: {
			date: true
		}
	},
	
	_create: function() {
		var self = this;
		$.smile.otriggerinput.prototype._create.call(this);
		self.element.removeAttr("readonly");
		self.element.datepicker({
			showOn: "none",
			showButtonPanel: true,
			changeMonth: true,
			changeYear: true,
			yearSuffix: "",
			showOtherMonths: true,
			selectOtherMonths: true,
			showWeek: true,
			firstDay: 0,
			weekHeader: "",
			numberOfMonths: 1,
			showButtonPanel: true,
			showCurrentAtPos: 1,
			
			onSelect: function(dateText, inst) { 
				self.validate();
				self._trigger( "onSelect", dateText, inst );
			}
		});
		
		self._trig.bind("click.odatepicker", function() {
			if($("#ui-datepicker-div").is(":visible")) {
				self.element.datepicker("hide");
				if(cur_ins != self.element) {
					self.element.datepicker("show");
					cur_ins = self.element;
				}
			} else {
				self.element.datepicker("show");
				cur_ins = self.element;
			}
			return false;
		});
		
		$("button.ui-datepicker-current")
			.live("click.odatepicker", function(e) {
				self.element.datepicker("hide");
				if(cur_ins == self.element) {
					self.setValue(new Date());
				}
			});
		
	},
	
	setValue: function(value) {
		this.element.datepicker("setDate", value);
	}
	
});
	
})(jQuery);