/*
 * Smile UI ogrid 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jqgrid/..
 *
 * Grid使用最佳实践：
 * 1.列模型中第一列为id列。
 * 2.使用formatterAlias格式化数据，使用editorAlias在直接编辑数据。
 * 3.对齐方式：金额右对齐，时间居中对齐，其余左对齐。
 * 
 */
(function($, undefined) {
	
$.jgrid.useJSON = true;
// 不兼容经典api
$.jgrid.no_legacy_api = true;

var d = "<div>", 
	defaults = {
		// 请求地址
		url : "",
		// 请求方式
		mtype: "POST",
		// 数据类型
		// 定义期望的数据格式。
		// 可取xml(xml格式)、xmlstring(xml字符串格式)、json(json格式)、jsonstring(json字符串格式)、
		// local(数据定义在客户端的数组中)、function(自定义函数)、clientSide(相当于local)
		// 如果希望ogrid初始化完成时不请求数据，可以设置为local，再次调用research方法时请求url选项地址
		datatype: "json",
		// 列名
		// colNames : [ "Inv No", "Date", "Client", "Amount", "Tax", "Total", "Notes" ],
		// 定义grid的列模型模板，对所有列生效。
		cmTemplate: {
			// 排序
			sortable: false,
			// 编辑
			editable: false,
			// 改变大小
			resizable: true
		},
		colModel : [
		],
		// json数据解析器, 在返回数据的的分页信息中当前页和总页数必须正确，其余信息jqGrid会经过计算得出
		jsonReader : {
			// root描述数据的开始
			root: "content",
			// 当前页号
			page: "number",
			// 总页数: The total number of pages
			total: "totalPages",
			// 总记录数: The total number of records
			records: "totalElements",
			// 设置这个选项为false指示jqGrid在json数据中使用name查询元素, 
			// 这个name来自colModel的name选项或者jsonmap(优先)选项。
			// json数据中, 当repeatitems为false时,
			// colModel的name和jsonmap选项可以使用点标记(item.price)和索引标记(item["price"])
			repeatitems: false,
			// id为行的唯一标识，默认为第一列
			// id: "id",
			// 额外信息
			userdata: "userdata"
		},
		prmNames: {
			// 当前页号
			page: "page.page",
			// 每页记录数
			rows: "page.size",
			// 排序排序属性名
			sort: "page.sort",
			// desc、asc
			order: "page.sort.dir",
			// 参考loadonce和rowTotal选项
			totalrows: "page.size",
			// 通过传入时间(对于IE浏览器不缓存请求)
			nd: "timestamp"
		},
		postData: {
			// 指示请求为Grid请求
			gridRequest: true
		},
		// 工具条
		toolbar: [false, "bottom"],
		// 分页元素。
		// pager : "",
		
		// 分页按钮
		pgbuttons: true,
		// 分页输入域
		pginput: true,
		// 分页条在grid上部
		toppager: false,
		// 分页按钮的水平位置
		pagerpos: "center",
		// 设置为true，grid一次将插入所有数据，启用这个选项有一些限制，
		// 如果设置为true将不能使用treeGrid、subGrid和afterInsertRow事件，
		// 如果不是用这3个功能，就将gridview设置为true，会得到可观的速度。
		gridview: true,
		// 显示在grid的中的记录数，如果rowNum为10，
		// 服务器返回15条记录，只有10条会被装载。
		rowNum : 15,
		// 可选显示在grid的中的记录数。
		rowList : [ 15, 20, 30 ,50, 100 ],
		// 如果为true，jqGrid显示记录信息，显示内容可以调整emptyrecords、recordtext
		viewrecords : true,
		// 也可以在jqgrid资源文件中设置
		// recordtext: "View {0} - {1} of {2}",
	    // emptyrecords: "No records to view",
		// pgtext : "Page {0} of {1}",
		loadtext: "正在请求数据，请稍候...",
		// 设置viewrecords信息的位置
		recordpos: "right",
		// 设置这个参数能指示服务器端需要加载记录的总数。
		// 注意：rowNum决定显示在grid中的记录数，而rowTotal决定grid能操作的记录总数。
		// 比如，一页显示15条记录，一共查1000条记录，这是rowNum为15，rowTotal为1000。
		// 当这个参数被设置时，则发送额外的参数到服务器被默认命名为totalrows，参数名可以在prmNames选项被更改。
		// 或者检查此参数，如果可用则替换掉rows参数。大部分这个选项需要结合loadonce选项设置为true。
		// rowTotal: 1000,
		// 如果这个选项设置为true，grid只从服务器加载一次数据(需要使用合适的datatype，这里使用json)。
		// 第一次请求之后datatype选项自动设置成local，并且所有之后的操作都在客户端进行。
		loadonce: false,
		// 创建动态滚动grid
		// 启用时，分页元素自动禁用并且能使用垂直滚动条加载数据。
		// 设置为true时grid总是持有所有记录从开始到最新点。
		// 当此参数为数字时，表格只控制可见的几行，所有数据都在这几行中加载
		scroll: false,
		
		// 启用多选，会产生新列checkbox用于多选。
		multiselect: false,
		// 当multiselect为true时，multiboxonly也为true，
		// 只有点击checkbox是才为多选操作(雅虎风格)，
		// 点行时除本行外其他都会取消选择。
		multiboxonly: true,
		multiselectWidth: 20,
		// 会产生新列显示行号。
		rownumbers: true,
		// 行号的宽度。
		rownumWidth: 40,
		// id行的前缀。
		idPrefix: "",
		// 初始化隐藏grid，不请求数据，值显示caption层，
		// 当点击显示/隐藏按钮时，显示grid的并请求数据。
		hiddengrid: false,
		// 当caption不为""时，启用或者禁用隐藏grid按钮。
		hidegrid: true,
		// hover效果
		hoverrows: true,
		// 排序列名
		sortname : "",
		// 顺序，可设置：desc、asc
		sortorder : "asc",
		// 设置列头的title属性
		headertitles: false,
		// 设置成true， < 将被转化成 &lt;。
		autoencode: true,
		// 如果设置为true，将在grid记录之下，分页条之上放置一行footer table，列的数量等于在colModel中定义的。
		footerrow: false,
		// 如果设置为true，一列的宽度改变，右侧相邻的列的宽度将被调整，所以整个grid的宽度维持不变，
		// 例如：第2列宽度减少30px，将增加第3列30px，在这种情况下不会出现水平滚动条。
		// 注意：这个选项不兼容shrinkToFit选项，如果shrinkToFit设置为false，forceFit将被忽略。
		forceFit: false,
		// 此选项如果被设置，定义的列宽度可能将根据grid整个的宽度被重新计算，
		// 如果设置为true，并且列的宽度也被设置,那时每一列是其宽度的比例。
		// 例如，如果定义2列，宽度分别为80px和120px，但是grid的宽度为300px，那时两列将伸展占满grid
		// 重新计算：如下：第一列，300 / 200 × 80 = 120，第二列：300 / 200 × 120 = 180，现在两列的总和为300px
		// 如果shrinkToFit设置为false，无论什么列都不会被重新计算。
		shrinkToFit: false,
		// 列可拖动排序
		sortable: true,
		// 当设置成true时，grid的宽度会自动根据父元素重新计算，
		// 这步只有初始化grid的时候会做，当父元素改变宽度时为了自适应，
		// 请使用setGridWidth方法
		autowidth: true,
		// grid宽度
		width: 300,
		// grid高度
		height: 355,
		// grid的标题，为""时无标题条
		caption : "ogrid caption",
		
		//** grid回调
		//** 请求之前
		// 在请求任何数据之前调用，如果datatype为function此函数不会调用。
		// 如果返回false，则不会请求服务器。
	    beforeRequest: undefined,
	    // 回调参数: xhr, settings
	    // 在发送请求之前调用，在beforeRequest之后调用，可以修改XHR，设置用户http头等，返回false取消请求。
	    // 设置为同步请求数据settings.async = false;
	    loadBeforeSend: undefined,
	    // 回调参数: postData
		// 发请求之前序列化数据，函数返回被序列化的数据。
		// 常常用来传入用户数据
	    serializeGridData: undefined,
	    //** 请求之后
	    // 回调参数: xhr, status, error
	    // 如果请求失败，此函数被调用。
	    loadError: undefined,
	    // 回调参数: data, status, xhr
		// 从服务器端获取到数据返回，还未交给grid处理，数据格式依赖datatype参数
		// 如果datatype为"json"，则数据为JS对象。
	    // 如果返回false，则不会渲染数据。
	    beforeProcessing: undefined,
	    // 所有数据被grid处理完并且其他(分页、排序)也处理完之后调用。
	    gridComplete: undefined,
	    // 回调参数: data
		// Grid请求最后一个调用
	    loadComplete: undefined,
	    
	    // 操作回调
	    // 回调参数: rowid, status, e
	    // 点击一行时执行
	    // rowid: 行号,
	    // status: 选择的状态, 能被multiselect为true是使用，true为选择，false为取消选择。
	    // e: 事件对象。
	    onSelectRow: undefined,
	    // 回调参数: rowid, iRow, iCol, e
	    // 双击一行时执行
	    ondblClickRow: undefined,
		
		//** cell编辑
		// 是否启用cell编辑，默认不启用。
		cellEdit : false,
		// 决定cell的内容保存的位置，可取值："remote"、"clientArray"。
		cellsubmit : "remote",
		// cell编辑请求路径URL。 
		cellurl : "",
		// 当保存数据到服务器时，cell编辑使用此选项设置全局的ajax选项。
		// 注意：保存请求(包括完成事件)此选项可能覆盖所有当前的ajax选项
		ajaxCellOptions: {},
		
		// Cell编辑回调
		// 下列事件使用的参数含义：
		// rowid - 行id
		// cellname - 列名(来自colModel)
		// value - cell的值
		// iRow - 行的索引号
		// iCol - 列的索引号
		/*
		当cellSubmit设置为remote时，回调函数的调用顺序。
	    1.formatCell (rowid, cellname, value, iRow, iCol) : 可以改变cell的值，将被编辑模式使用
	    2.beforeEditCell (rowid, cellname, value, iRow, iCol) : cell跳到编辑状态之前调用
	    3.afterEditCell (rowid, cellname, value, iRow, iCol) : cell跳到编辑状态之后调用
	    4.beforeSaveCell (rowid, cellname, value, iRow, iCol) : 保存cell之前调用, 此处保存的值发送到服务器
	    5.beforeSubmitCell (rowid, cellname, value, iRow, iCol) : 发送到服务器之前调用, 可以添加额外的请求参数，返回对象。
	    6.afterSubmitCell (serverresponse, rowid, cellname, value, iRow, iCol) : 成功提交到服务器之后调用, 可以返回错误信息，使用对话框提示用户。
	    7.afterSaveCell (rowid, cellname, value, iRow, iCol) : cell被保存之后调用
	    8.errorCell (serverresponse, status) : 服务器错误时调用(例如：403, 404, 500等)
	    9.onSelectCell (rowid, celname, value, iRow, iCol) : cell不可编辑时调用
		*/
		// 回调参数：rowid, cellname, value, iRow, iCol
		// 这个事件允许在编辑之前格式化cell内容，返回格式化之后的值
		formatCell: undefined,
		// 回调参数：rowid, cellname, value, iRow, iCol
		// cell跳到编辑状态之前调用
		beforeEditCell: undefined,
		// 回调参数：rowid, cellname, value, iRow, iCol。
		// cell跳到编辑状态之后调用
		afterEditCell: undefined,
		// 回调参数：rowid, cellname, value, iRow, iCol。
		// 保存cell之前调用, 此处保存的值发送到服务器, 可以用于校验，可返回新值替换旧值。
		beforeSaveCell: undefined,
		// 回调参数：rowid, cellname, value, iRow, iCol。
		// 发送到服务器之前调用, 可以添加额外的请求参数，返回对象，提交到服务器。
		beforeSubmitCell: undefined,
		// 回调参数：serverresponse, rowid, cellname, value, iRow, iCol。
		// cell和其他数据发送到服务器之后调用，返回值格式：[success(boolean),message]。
		// 如：
		// [true,""]，cell值保存成功，
		// [false,"Error message"]，弹出错误对话框，cell内容未保存。
		// servereresponse是服务器响应。
		// 应该使用serverresponse.responseText获取信息。
		afterSubmitCell: undefined,
		// 回调参数：rowid, cellname, value, iRow, iCol。
		// cell被保存之后调用，这是改变其他值最理想的地方。
		afterSaveCell: undefined,
		// 回调参数：serverresponse, status。
		// 服务器错误时调用(例如：403, 404, 500等)，servereresponse是服务器响应。
		// 使用serverresponse.responseText获取来自服务器的信息
		// status是错误状态，如果不使用，则出现模态对话框。
		errorCell: undefined,
		// 回调参数：rowid, celname, value, iRow, iCol。
		// 用于cell不可编辑，当cell被选择时调用。
		onSelectCell: undefined,
		// 回调参数：rowid, value, iRow, iCol。
		// 调用restoreCell或者用户按ESC离开编辑状态时调用。
		afterRestoreCell: undefined,
		// 回调参数：postdata。
		// 当保存单元格时，这个事件序列化数据传入ajax请求。
		// 这个函数应该返回被序列化的数据。
		// 当用户数据需要传到服务器时这个事件可以用到。
		// 例如JSON字符串，XML字符串等。
		serializeCellData: undefined,
		
		//** inline编辑
		// inline编辑编辑请求路径URL。
		editurl: "",
		ajaxRowOptions: {},
		serializeRowData: undefined,
		//** inline编辑回调
		// 参考_create函数inline编辑部分。
		
	    //** treegrid
		// treeGrid是在grid中展现层次结构的一种形式。
		// treeGrid支持Nested和Adjacency两种模型，默认使用adjacency。
		// 启用或者禁用treeGrid风格。
	    treeGrid: false,
	    // 使用adjacency模型。
	    treeGridModel: "adjacency",
	    // 指示treeGrid用来展开的列，name来自colModel。
	    ExpandColumn: undefined,
	    // 当设置为true时，点击可展开列的文本时treeGrid被展开或者收缩。
	    // 当设置为false时，只能点击图标才能展开或者收缩。
	    ExpandColClick: false,
	    // 延伸基础grid定义的colModel。
	    // 这些field被追加到colModel数组后面并且被隐藏。
	    // 这就意味着从服务器端返回的数据应该有哪些fields。
	    treeReader: {
	    	// 此域决定元素在层级中的水平。
	    	// 通常root元素被设置为0，root的第一个孩子是1，等等。
	    	// grid需要此信息设置每个元素的缩进。
			level_field: "level",
			// 指示父节点的id，如果父id设置为null，则元素为root节点。
			parent_id_field: "pid",
			// 指示是否为叶子，可取true或者false。
			// 是否为叶子节点关系到元素的图片和是否能被展开。
			leaf_field: "leaf",
			// 指示grid元素在加载时是否应该被展开，可取true或者false。
			// 如果没有值，则设置为false。
			// 注意：数据可以为null，但是不应该被移除。
			expanded_field: "expanded",
			// 指示数据是否已加载是否。
			loaded: "loaded"
   		}
		
	};

function custom_element(value, options) {
	var editor = options.editor;
	var settings = $.extend(true, {
		hideLabel: true,
		value: value,
		width: $("#"+this.id+"_"+options.name).width() - 20
	}, editor.options);
	return $("<input>")[editor.type](settings)[editor.type]("widget");
}

function custom_value(elem, operation, value) {
	var input = $(elem).find("input");
	var xtype = $(elem).data("xtype");
    if(operation === "get") {
    	// elem的id由行id_列名构成，使用"_"分割得到行id和列名的数组，
    	// 第一个元素rc[0]为行id，第二个元素rc[1]为列名。
    	var rc = $(elem).attr("id").split("_");
    	// 将提交值按列名临时存储在ogrid.gridId命名空间下。
    	// 列名 = 提交值
    	$.smile.ogrid[this.id].edit[rc[1]] = input[xtype]("getValue");
    	// 用于editrules.custom_func的数据检验。
    	$.smile.ogrid[this.id].field = input;
    	// 显示值
    	var display = input.val();
    	return display;
    } else if(operation === "set") {
    	input[xtype]("setValue", value);
    }
}
	
$.widget("smile.ogrid", $.smile.obase, {
	
/*
 * <table id="grid" class="o-unselect"></table>
 * <div id="pager"></div>
 */	
	
	options: {
		// 是否显示下分页条
		bottomPager: true,
		// 可取值：inline(行内编辑--可同时编辑多个单元格)、cell(单元格编辑)
		editModel: false,
		/**
		 * 用户按钮
			buttons: [{
				click: function(e) {
					alert("aaa");
				}
			}, {
				id: "add",
				label: "添加",
				click: function(e) {
					
				}
			}],
		 */
		buttons: undefined
	},
	
	// 下侧分页条
	_pager: undefined,
	// 用于放置用户按钮
	_toolbarId: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		var self = this, 
			ele = self.element,
			opts = $.extend(true, {}, self.options, $.smile.ogrid.globle),
			id = ele.attr("id");
		
		// 为grid开辟命名空间，用于存放此grid临时变量，
		// 如gridId为：demo1，则$.smile.ogrid.demo1 = {}
		$.smile.ogrid[id] = {};
		
		ele.addClass("o-unselect");
		
		// 是否显示下侧分页条，id=<gridId>_pager。
		if(opts.bottomPager) {
			var pagerId = id + "_pager";
			self._pager = $(d, {
				id: pagerId
			}).insertAfter(ele);
			opts.pager = "#" + pagerId;
			self._toolbarId = id + "_pager_left";
		} else {
			opts.toolbar = [true, "bottom"];
			self._toolbarId = "t_" + id;
		}
		
		// 为支持grid edit开辟命名空间$.smile.ogrid[id].edit
		if(opts.editModel !== undefined) {
			$.smile.ogrid[id].edit = {};
		}
		
		// cell编辑
		if(opts.editModel === "cell") {
			opts.cellEdit = true;
			if(opts.cellsubmit !== "clientArray" && 
					(opts.cellurl == undefined || $.trim(opts.cellurl) == "")) {
				Smile.box.alert({
				    content: Smile.util.formatString(
				    			Smile.mesageCode.dev.dev00003, "cellurl", id)
				});
			}

			var showAddEditButtons = function()  {
				$("#"+id+"_cellsave").addClass("ui-state-disabled");
				$("#"+id+"_cellcancel").addClass("ui-state-disabled");
				$("#"+id+"_celladd").removeClass("ui-state-disabled");
				$("#"+id+"_celledit").removeClass("ui-state-disabled");
			}
			
			var showSaveCancelButtons = function()  {
				$("#"+id+"_cellsave").removeClass("ui-state-disabled");
				$("#"+id+"_cellcancel").removeClass("ui-state-disabled");
				$("#"+id+"_celladd").addClass("ui-state-disabled");
				$("#"+id+"_celledit").addClass("ui-state-disabled");
			}
			
			// cell编辑参数序列化回调
			// 返回json对象，提交到服务器。
			// 获取$.smile.ogrid.gridId命名空间下的参数，解决提交id，显示name问题。
			opts.serializeCellData = function(postdata) {
				return $.extend(true, postdata, $.smile.ogrid[id].edit);;
			}

			opts.onSelectCell = function(rowid, celname, value, iRow, iCol) {
				// 保存被选择单元格的信息
				$.smile.ogrid[id].selectedCell = {
						rowid: rowid,
						celname: celname,
						value: value,
						iRow: iRow,
						iCol: iCol
				};
				self._trigger("onSelectCell", null, {
					rowid: rowid,
					celname: celname,
					value: value,
					iRow: iRow,
					iCol: iCol
				});
			}
			
			opts.afterRestoreCell = function(rowid, value, iRow, iCol) {
				showAddEditButtons();
				self._trigger("afterRestoreCell", null, {
					rowid: rowid,
					value: value,
					iRow: iRow,
					iCol: iCol
				});
			}
			opts.afterSaveCell = function(rowid, cellname, value, iRow, iCol) {
				showAddEditButtons();
				self._trigger("afterSaveCell", null, {
					rowid: rowid, 
					cellname: cellname,
					value: value, 
					iRow: iRow, 
					iCol: iCol
				});
			}
			
			opts.afterEditCell = function(rowid, cellname, value, iRow, iCol) {
				showSaveCancelButtons();
				$.smile.ogrid[id].edit = {};
				self._trigger("afterEditCell", null, {
					rowid: rowid,
					cellname: cellname,
					value: value,
					iRow: iRow, 
					iCol: iCol
				});
			}
			
			// 双击进入编辑模式
			opts.ondblClickRow = function(rowid, iRow, iCol, e) {
				$("#"+id+"_celledit").click();
				self._trigger("ondblClickRow", null, {
					rowid: rowid, 
					iRow: iRow, 
					iCol: iCol, 
					e: e
				});
			}
			
		}
		
		// inline编辑, 双击进入编辑状态。
		if(opts.editModel === "inline") {
			if(opts.editurl === undefined || $.trim(opts.editurl) == "") {
				Smile.box.alert({
				    content: Smile.util.formatString(
			    				Smile.mesageCode.dev.dev00003, "editurl", id)
				});
			}
			// 行内编辑参数序列化回调
			// 返回json对象，提交到服务器。
			// 获取$.smile.ogrid.gridId命名空间下的参数，解决提交id，显示name问题。
			opts.serializeRowData = function(postdata) {
				return $.extend(true, postdata, $.smile.ogrid[id].edit);;
			}
			// 双击进入编辑模式
			opts.ondblClickRow = function(rowid, iRow, iCol, e) {
				$("#"+id+"_iledit").click();
				self._trigger("ondblClickRow", null, {
					rowid: rowid, 
					iRow: iRow, 
					iCol: iCol, 
					e: e
				});
			}
		}
		
		// 预处理列模型
		$.each(opts.colModel, function(i, v) {
			// 主键列预处理
			if(v.key) {
				v.hidedlg = true;
			}
			// 冻结列预处理
			if(v.frozen) {
				opts.sortable = false;
			}
			// formatter预处理
			if(!v.formatterAlias) {
				v.formatterAlias = "--";
			}			
			var formatter = $.smile.ogrid.formatterAlias[v.formatterAlias];
			v.formatter = formatter.type;
			v.formatoptions = formatter.options;
			
			// editor预处理
			if(v.editorAlias) {
				var editor = $.smile.ogrid.editorAlias[v.editorAlias];
				v.editable = true;
				v.edittype = "custom";
				v.editoptions = {
					custom_element: custom_element,
					custom_value: custom_value,
					editor: editor
				};
				v.editrules = {
					custom: true,
					custom_func: function(value, colname) {
						var $field = $($.smile.ogrid[this.id].field);
						return [$field[$field.data("xtype")]("validate"), Smile.mesageCode.invalidInput];
					}
				}
			}
		});
		
		/*
		// 处理服务器端分页从零开始
		opts.beforeProcessing = function(data, status, xhr) {
			if(data && data.number != null) {
				data.number = data.number + 1
			}
		}
		*/
		
		var settings = $.extend(true, {}, defaults, opts);
		
		// 启用treeGrid时，显示行号修改。
		if(settings.treeGrid && settings.rownumbers) {
			if(!settings.ExpandColumn) {
				settings.ExpandColumn = settings.colModel[0].name;
			}
			$.each(settings.colModel, function(i, n) {
				if(n.name === settings.ExpandColumn) {
					settings.ExpandColumn = settings.colModel[i + 1].name;
					return false;
				}
			});
		}
		
		// 初始化grid
		ele.jqGrid(settings);
		
		// 设置序号列。
		$("#jqgh_"+id+"_rn").text("序号");
		
		// 启用上分页条上的刷新功能，禁用其他功能。
		ele.jqGrid("navGrid", "#"+id+"_toppager", {
			edit : false,
			add : false,
			del : false,
			view: false,
			search: false,
			refresh: true,
			beforeRefresh: function() {
				// 解决cell编辑，在编辑状态点击刷新按钮，无法在次编辑的问题
				$("#" + id + "_cellcancel").click();
			}
		});
		
		/*
		// 添加Grid按钮
		self.addButton({
			id: id + "_refresh",
			label: "刷新",
			click: function(event) {
				$("#" + id + "_cellcancel").click();
				self.refresh();
			}
		});
		self.addButton({
			id: id + "_refresh",
			label: "选择列",
			click: function(event) {
				ele.jqGrid("columnChooser", {
					modal: true
				});
			}
		});
		*/
		
		// cell编辑按钮，应该在navGrid之后调用。
		if(opts.editModel === "cell") {
			
			ele.jqGrid("navButtonAdd", "#"+id+"_toppager", {
				caption : "",
				title : "编辑",
				buttonicon : "ui-icon-pencil",
				id : id + "_celledit",
				onClickButton : function () {
					var selectedCell = $.smile.ogrid[id].selectedCell;
					// alert("请选择需要修改的单元格!");
					ele.jqGrid("editCell", selectedCell.iRow, selectedCell.iCol, true);
				}
			});
			ele.jqGrid("navButtonAdd", "#"+id+"_toppager", {
				caption : "",
				title : "保存",
				buttonicon : "ui-icon-disk",
				id : id + "_cellsave",
				onClickButton : function () {
					var selectedCell = $.smile.ogrid[id].selectedCell;
					ele.jqGrid("saveCell", selectedCell.iRow, selectedCell.iCol);
				}
			});
			ele.jqGrid("navButtonAdd", "#"+id+"_toppager", {
				caption : "",
				title : "取消",
				buttonicon : "ui-icon-cancel",
				id : id + "_cellcancel",
				onClickButton : function () {
					var selectedCell = $.smile.ogrid[id].selectedCell;
					ele.jqGrid("restoreCell", selectedCell.iRow, selectedCell.iCol);
				}
			});
			
			showAddEditButtons();
		}
		
		// 行内编辑，inlineNav应该在navGrid之后调用。
		if(opts.editModel === "inline") {
			ele.jqGrid("inlineNav", "#"+id+"_toppager", {
				position: "left",
				edit: true,
				editicon: "ui-icon-pencil",
				edittitle: "编辑",
				add: false,
				addicon: "ui-icon-plus",
				addtitle: "添加",
				save: true,
				saveicon: "ui-icon-disk",
				savetitle: "保存",
				cancel: true,
				cancelicon: "ui-icon-cancel",
				canceltitle: "取消",
				addParams: {useFormatter : false},
				editParams: {
					// url: null,
					mtype: "POST",
					extraparam: {},
					// 当设置为true时我们能使用Enter键保存编辑行，使用Esc键取消编辑行。
					keys: true,
					// 在成功进入编辑状态时调用，允许用户访问之前的input域。
					oneditfunc: function(rowid) {
						self._trigger("oneditfunc", null, {
							rowid: rowid
						});
					},
					// 调用restoreRow之后被调用
					// 传入rowid
					afterrestorefunc: function(rowid) {
						self._trigger("afterrestorefunc", null, {
							rowid: rowid
						});
					},
					// 请求返回之后立即调用
					// 传入从服务器传回的信息
					// 返回值结构：
					/**
					 * 服务器端响应，response参数基本结构：
					 * {
					 * 	success: true或false，用于判断是否更新成功。
					 * 	row: {}修改行的数据对象，用于显示。
					 * }
					 */
					successfunc: function(response) {
						return self._trigger("successfunc", null, {
							response: response
						});
					},
					// successfunc返回true时调用
					// 传入rowid(行id), response(服务器响应)
					// 当url被设置为clientArray时也被调用
					aftersavefunc: function(rowid, response) {
						self._trigger("aftersavefunc", null, {
							rowid: rowid,
							response: response
						});
					},
					// successfunc返回false时或者服务器错误时(例如：403, 404, 500等)调用
					// 传入rowid(行id), response(服务器响应)
					errorfunc: function(rowid, response) {
						self._trigger("errorfunc", null, {
							rowid: rowid,
							response: response
						});
					},
					// 出错之后取消编辑状态
					restoreAfterError: false
				}
			});
		}
		
		// 添加用户按钮
		if(opts.buttons) {
			$.each(opts.buttons, function(i, v) {
				if($.isPlainObject(v)) {
					self.addButton(v);
				}
			});
		}
		
		// 在导航条上增加按钮，用于grid选择列。
		ele.jqGrid("navButtonAdd", "#"+id+"_toppager",{ 
			caption: "", 
			title: "选择列", 
			onClickButton : function (){ 
				ele.jqGrid("columnChooser", {
					modal: true
				}); 
			} 
		});
		
		// 处理grid自适应，防止连续调用。
		var canResize = true
		$(window).resize(function() {
			if(canResize) {
				canResize = false;
				var parent = $("#gbox_"+id).parent();
				ele.jqGrid("setGridWidth", parent.width() - 2);
				window.setTimeout(function() {
					var parent = $("#gbox_"+id).parent();
					ele.jqGrid("setGridWidth", parent.width() - 2);
					canResize = true;
				}, 800);
			}
		});
		
	},
	
	_init: function() {
		this.element.ogrid("setFrozenColumns");
	},
	
	widget: function() {
		return $("#gbox_" + this.element.attr("id"));
	},
	
	invoke: function(methodName) {
		var args = Array.prototype.slice.call(arguments, 1);
		return this.element.jqGrid(methodName, args);
	},
	
	// 添加一行记录。
	// rowid：行标识。
	// data：行数据。
	addRowData: function(rowid, data) {
		return this.element.jqGrid("addRowData", rowid, data, "first");
	},
	
	// 添加一行记录。
	// rowid：行标识。
	// data：行数据。
	delRowData: function(rowid) {
		return this.element.jqGrid("delRowData", rowid);
	},
	
	// 返回请求行的数据对象，返回对象类型：键值对{name: value}，name来自colModel，value来自这行关联的列。
	// 如果rowid不存在，则返回空对象。
	// 1. 当编辑row或者cell时，不要使用这个方法，他将返回cell的内容，而不是input元素的实际值。
	// 2. 不要在循环体中使用此方法，因为会有性能问题(当调用方法一次，将计算行数据一次)。
	// 如果rowid没有被设置，则返回grid中的所有数据。
	getRowData: function(rowid) {
		return this.element.jqGrid("getRowData", rowid);
	},
	
	// 返回单元格的内容，rowid: 行的id，iCol: 列的索引或者colModel中列的name。
	// 当编辑row或者cell时，不要使用这个方法，他将返回cell的内容，而不是input元素的实际值。
	getCell: function(rowid, iCol) {
		return this.element.jqGrid("getCell", rowid, iCol);
	},
	
	// 返回单元格td，rowid: 行的id，colName: 列的colModel中列的name。
	getCellEle: function(rowid, colName) {
		return $("#" + rowid, this.element).find("td[aria-describedby='"+this.element.attr("id")+"_"+colName+"']");
	},
	
	// 返回指定行：tr，rowid: 行的id。
	getRowEle: function(rowid) {
		return $("#" + rowid, this.element);
	},
	
	// 返回指定列：td的数组，colName: 列的colModel中列的name。
	getColEle: function(colName) {
		return this.element.find("td[aria-describedby='"+this.element.attr("id")+"_"+colName+"']");
	},
	
	// 返回请求的参数。name来自options数组，如果name没有设置，所有选项被返回。
	getGridParam: function(name) {
		return this.element.jqGrid("getGridParam", name);
	},
	
	// 设置具体的选项，参数类型：键值对{name: value}。
	// 注意：一些选项将会影响下一个trigger(“reloadGrid”)的执行。
	// 注意：这个方法能覆盖选项。name来自options
	setGridParam: function(object) {
		return this.element.jqGrid("setGridParam", object);
	},
	
	// 设置请求参数，参数类型：键值对{name: value}。
	setPostParam: function(object) {
		return this.element.jqGrid("setGridParam", {"postData": object});
	},
	
	// 刷新grid
	// 重新装载grid的当前设置。
	// 这意味着如果datatype是xml或者json，一个新的请求被发送到服务器。
	// 这个方法应该应用到一个已经被构造的grid中。
	// 注意：这个方法不能改变HEADER信息，这意味着colModel的改变将不会生效。
	// 应该使用gridUnload重新加载不同的colModel。它只能工作在loadonce为false!
	refresh: function() {
		this.element.trigger("reloadGrid");
	},
	
	// 重新查询数据。
	// 将datatype设置为json，page设置为第一页，一个新的请求被发送到服务器。
	// 这个方法应该应用到一个已经被构造的grid中。
	// 注意：这个方法不能改变HEADER信息，这意味着colModel的改变将不会生效。
	// 应该使用gridUnload重新加载不同的colModel。它只能工作在loadonce为false!
	research: function() {
		this.element.jqGrid("setGridParam",{datatype:"json", page: 1}).trigger("reloadGrid");
	},
	
	//** cell编辑
	// 编辑行，索引iRow(也可以为行id)，列索引iCol的单元格
	// 如果edit设置为false，cell仅仅被选择而不被编辑，设置为true cell被选择而且被编辑。
	editCell: function(iRow, iCol, edit) {
		return this.element.jqGrid("editCell", iRow, iCol, edit);
	},
	// 恢复cell编辑，行索引iRow(也可以为行id)，列索引iCol的单元格
	restoreCell: function(iRow, iCol) {
		return this.element.jqGrid("restoreCell", iRow, iCol);
	},
	// 保存cell，行索引iRow(也可以为行id)，列索引iCol的单元格
	saveCell: function(iRow, iCol) {
		return this.element.jqGrid("saveCell", iRow, iCol);
	},
	// 获取改变的cell，method为"all"时返回所有改变的行，为"dirty"时至返回改变的cell和行id，默认为"all"。
	// 一般和cellsubmit="clientArray"配合使用。
	getChangedCells: function(method) {
		return this.element.jqGrid("getChangedCells", method);
	},
	/**
	 * 在下分页条上添加按钮
	 * option结构：
	 * {
	 *  id: button的id,
	 * 	label: 按钮上的文字,
	 * 	click: function() {
	 * 		点击后的动作
	 * 	}
	 * }
	 */
	addButton: function(option) {
		$("<button>")
			.attr("id", option.id)
			.obutton({label: option.label || "label"})
			.click(option.click)
			.css({"margin-left": "4px"})
			.appendTo("#" + this._toolbarId);
	},
	/**
	 * 当选项multiselect为true时，返回被选中行id的一维数组，否则返回最后选择的行id。
	 */
	getSelectedRow: function() {
		if(this.options.multiselect === true) {
			// selarrrow：只读选项，multiselect选项为true是可用，返回被选中行id的一维数组。
			return this.getGridParam("selarrrow");
		} else {
			// selrow：只读选项，返回最后选择的行id，如果使用sort或paging，此选项被设置为null。
			return this.getGridParam("selrow");
		}
	},
	/**
	 * 
	 * 传入需要隐藏的列名，可以为单个列名："columnName"，也可以为列名的数组：["columnName1", "columnName2"]。
	 * NB：grid的宽度不会改变。
	 * 
	 * @param colname 需要隐藏的列名。
	 */
	hideCol: function(colname) {
		this.element.jqGrid("hideCol", colname);
	},
	/**
	 * 
	 * 传入需要显示的列名，可以为单个列名："columnName"，也可以为列名的数组：["columnName1", "columnName2"]。
	 * NB：grid的宽度不会改变。
	 * 
	 * @param colname 需要隐藏的列名。
	 */
	showCol: function(colname) {
		this.element.jqGrid("showCol", colname);
	},
	
	// 冻结列
	setFrozenColumns: function() {
		return this.element.jqGrid("setFrozenColumns");
	},
	
	destroyFrozenColumns: function() {
		return this.element.jqGrid("destroyFrozenColumns");
	},
	
	/**
	 * 设置复杂列头
	 * option结构：
	 * {
	 *  useColSpanStyle: 是否跨列,
	 *  groupHeaders: [
	 *      {startColumnName: 需要合并列的开始列名, numberOfColumns: 合并列数, titleText: 合并列名},
	 *      ...
	 *   ]
	 * }
	 */
	setGroupHeaders: function(options) {
		this.element.jqGrid("setGroupHeaders", $.extend(true, {
			useColSpanStyle: true
		}, options));
		// 修复在添加grid复杂列头时有序号列对不齐的BUG。
		$("#jqgh_"+this.element.attr("id")+"_rn").parent().width(this.options.rownumWidth || defaults.rownumWidth);
	},
	
	/**
	 * 从grid中清除当前加载的数据。
	 * @param clearfooter 设置为true，则同时清除footer row的数据。
	 */
	clearGridData: function(clearfooter) {
		return this.element.jqGrid("clearGridData", clearfooter);
	},
	
	/**
	 * 删除grid中id等于rowid的记录。
	 */
	delRowData: function(rowid) {
		return this.element.jqGrid("delRowData", rowid);
	}
	
});

$.extend($.smile.ogrid, {
	
	/**
	 * 创建列格式化函数
	 * @param {String} alias 格式化函数名
	 * @param {Function} formatter(cellvalue, options, row) 格式化函数
	 * @param {Function} unformat(cellvalue, options, cell) 恢复格式化函数
	 * 
		$.extend($.fn.fmatter , {
		    currencyFmatter : function(cellvalue, options, rowdata) {
			    return "$"+cellvalue;
			}
		});
		$.extend($.fn.fmatter.currencyFmatter , {
		    unformat : function(cellvalue, options) {
			    return cellvalue.replace("$","");
			}
		});
	*/
	createFormatterAlias: function(alias, formatter, unformat) {
		$.fn.fmatter[alias] = formatter;
		$.fn.fmatter[alias].unformat = unformat;
		this.formatterAlias(alias, {type: alias})
	},
	
	/**
	 * 创建格式化别名
	 * @param {String} alias 别名
	 * @param {Object} formatter 格式化定义，结构如下：
	 * {
	 * 	type: "对应列模型中的formatter选项",
	 * 	options: {
	 * 		对应列模型中的formatoptions选项
	 * 	}
	 * }
	 */
	formatterAlias: function(alias, formatter) {
		$.smile.ogrid.formatterAlias[alias] = formatter;
	},
	
	/**
	 * 创建编辑器函数
	 * @param {String} editorAlias 编辑器别名
	 * @param {Function} customElement(value, options) 创建元素函数
	 * @param {Function} customValue(elem, operation, value) 访问值函数
	 */
	createEditorAlias: function(alias, customElement, customValue) {
		this.editorAlias(alias, {type: alias})
	},
	
	/**
	 * 创建编辑器别名
	 * @param {String} alias 别名
	 * @param {Object} editor 编辑器定义，editor结构如下：
	 * {
	 * 	type: "编辑器的类型",
	 * 	options: {
	 * 		编辑器的初始化选项
	 * 	}
	 * }
	 */
	editorAlias: function(alias, editor) {
		$.smile.ogrid.editorAlias[alias] = editor;
	},
	
	/**
	 * 设置grid全局选项。
	 * @param options
	 */
	setGloble: function(options) {
		$.smile.ogrid.globle = options;
	}

});

// 预置格式化
// num1 - num9 分别保留 1 - 9位小数。
// defaultValue为默认值。
for(var i = 1; i < 10; i++) {
	$.smile.ogrid.formatterAlias("num"+i, {
		type: "number", 
		options: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: i, defaultValue: "--"}
	});
}

//int 格式化整数
$.smile.ogrid.formatterAlias("int", {
	type: "integer", 
	options: {thousandsSeparator: ",", defaultValue: "--"}
});

//日期时间的defaultValue设置在grid.locale-cn.js文件的formatter中。
// jqgrid获取defaultValue的位置不同。
// 时间戳格式化成日期字符串
$.smile.ogrid.formatterAlias("date", {
	type: "date", 
	options: {srcformat:"u",newformat:"Y-m-d"}
});
// 时间戳格式化成时间字符串
$.smile.ogrid.formatterAlias("time", {
	type: "date", 
	options: {srcformat:"u",newformat:"H:i:s"}
});
//时间戳格式化成日期时间字符串
$.smile.ogrid.formatterAlias("datetime", {
	type: "date", 
	options: {srcformat:"u",newformat:"Y-m-d H:i:s"}
});

//链接格式化函数，如果内容为空，返回--
$.smile.ogrid.createFormatterAlias("a", function(cellvalue, options, row) {
	if(cellvalue && cellvalue !== "") {
		return '<a href="javascript:void(0)">' + cellvalue + '</a>';
	} else {
		return "--";
	}
}, function(cellvalue, options, cell) {
	return $(cell).text();
});

// 默认格式化函数，如果内容为空，返回--
$.smile.ogrid.createFormatterAlias("--", function(cellvalue, options, row) {
	if(cellvalue && cellvalue !== "") {
		return cellvalue;
	} else {
		return "--";
	}
}, function(cellvalue, options, cell) {
	return cellvalue.replace("--","");
});

$.smile.ogrid.createFormatterAlias("detail", function(cellvalue, options, row) {
	if(cellvalue && cellvalue !== "") {
		return '<div class="o-icon-wrap"><span class="ui-icon ui-icon-document"></span></div><span>'+cellvalue+'</span>';
	} else {
		return "--";
	}
}, function(cellvalue, options, cell) {
	return cellvalue.replace("--","");
});

// 预置编辑器
$.smile.ogrid.editorAlias("odatepicker", {
	type: "odatepicker",
	options: {
		allowBlank: false,
		hideLabel: true
	}
});

$.smile.ogrid.editorAlias("otextfield", {
	type: "otextfield",
	options: {
		allowBlank: false,
		hideLabel: true
	}
});

})(jQuery)