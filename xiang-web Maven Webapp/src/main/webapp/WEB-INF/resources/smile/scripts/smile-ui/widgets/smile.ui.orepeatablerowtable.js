/*
 * Smile UI orepeatablerowtable 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.otable.js
 */
(function($, undefined) {
	
var tr = '<tr>', 
	td = '<td>',
	span = '<span>',
	d = '<div>',
	tdTemplate = '<td><input name="{0}" /></td>';
	
// 不对IE6、IE7做主流支持
$.widget("smile.orepeatablerowtable", $.smile.otable, {
	
	options: {
		/*
		 * 列模型结构
		colModel: [{
			// 输入域name属性。
			name: "tf1",
			// 列头。
			label: "五百罗汉",
			// 输入域组件名称。
			type: "otextfield",
			// 输入域组件选项。
			options: {
				width: 150,
				hideLabel: true,
				value: 111
			}
		}, {
			name: "dp1",
			label: "开始日期",
			type: "odatepicker",
			options: {
				width: 150,
				hideLabel: true
			}
		}]
		 */
		data: [],
		colModel: []
	},
	
	_columnTemplate: undefined,
	_labelTemplate: undefined,
	
	_create: function() {
		$.smile.otable.prototype._create.apply( this );
		var self = this,
			opts = self.options,
			ele = self.element;
		
		$(d, {
			title: "添加"
		}).addClass("o-table-toptoolbar-button ui-corner-all")
			.hover(function() {
				$(this).addClass("ui-state-hover");
			}, function() {
				$(this).removeClass("ui-state-hover");
			})
			.bind("click."+self.widgetName, function() {
				self.addRow();
			})
			.append($(span).addClass("ui-icon ui-icon-plus"))
			.appendTo(self._topToolbar);
		
		$(d, {
			title: "删除"
		}).addClass("o-table-toptoolbar-button ui-corner-all")
			.hover(function() {
				$(this).addClass("ui-state-hover");
			}, function() {
				$(this).removeClass("ui-state-hover");
			})
			.bind("click."+self.widgetName, function() {
				self.removeRow();
			})
			.append($(span).addClass("ui-icon ui-icon-minus"))
			.appendTo(self._topToolbar);
		
		
		// 预处理列模型、初始化表头模板和列模板
		self._columnTemplate = $(tr).addClass("ui-widget-content");
		self._labelTemplate = $(tr).addClass("ui-state-default");
		for(var i = 0; i < opts.colModel.length; i ++) {
			if(!$.isEmptyObject(opts.colModel[i])) {
				
				// 预处理列模型
				if(!opts.colModel[i].options) {
					opts.colModel[i].options = {};
				}
				opts.colModel[i].options["title"] = opts.colModel[i].label;
				opts.colModel[i].options["hideLabel"] = true;
				if(!opts.colModel[i].options["width"]) {
					opts.colModel[i].options["width"] = 150;
				}
				
				// 初始化表头模板和列模板
				self._columnTemplate.append(Smile.util.formatString(tdTemplate, opts.colModel[i].name))
				self._labelTemplate.append($(td).css({"text-align": "center"}).text(opts.colModel[i].label));
			}
		}
		this.element.append(self._labelTemplate);
		
		self._columnTemplate.addClass("ui-widget-content")
			.hover(function() {
				$(this).addClass("ui-state-default");
			}, function() {
				$(this).removeClass("ui-state-default");
			})
			.click(function() {
				self._trArray.removeClass("ui-state-highlight");
				$(this).addClass("ui-state-highlight");
			});
		
		self._initValue();
		
	},
	
	_initValue: function() {
		var self = this;
		$.each(this.options.data, function(i, v) {
			self.addRow(v);
		});
	},
	
	addRow: function(rowData) {
		var row = this._columnTemplate.clone(true);
		$.merge(this._trArray, row);
		this.element.append(row);
		this._renderRow(row, rowData);
	},
	
	_renderRow: function(row, rowData) {
		var colModel = this.options.colModel;
		for(var i = 0; i < colModel.length; i ++) {
			if(!$.isEmptyObject(colModel[i])) {
				var $input = row.find("input:eq(" + i + ")");
				$input[colModel[i].type](colModel[i].options);
				if(rowData && rowData[$input.attr("name")]) {
					$input[colModel[i].type]("setValue", rowData[$input.attr("name")])
				}
			}
		}
	},
	
	removeRow: function() {
		var selected = this._getSelectRow();
		if(selected.length) {
			selected.remove();
		}
	},
	
	_getSelectRow: function() {
		return this.element.find("tr.ui-state-highlight");
	},
	
	serialize: function() {
		var self = this,
			valid = true,
			serialize = {},
			index = 0,
			indexFlag = false;
		$.each(this.element.find("tr"), function(i, tr) {
			indexFlag = false;
			$.each($(tr).find("input.SmileField"), function(j, field) {
				indexFlag = true;
				if(!$(field)[$(field).data("xtype")]("validate")) {
					valid = false;
					return false;
				}
				serialize[self._nameResolver(field.name, index) || field.id] = $(field)[$(field).data("xtype")]("getValue");
			});
			if(indexFlag) {
				index ++;
			}
			return valid;
		});
		return valid ? serialize : false;
	},
	
	// userVO.addressList[?].city
	_nameResolver: function(name, rowNum) {
		if(name.indexOf("?") != -1) {
			name = name.replace("?", rowNum);
		}
		return name;
	}
	
});

})(jQuery);

