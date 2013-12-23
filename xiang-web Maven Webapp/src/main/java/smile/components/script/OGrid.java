package smile.components.script;

import smile.components.AbstractClosingUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class OGrid extends AbstractClosingUIBean {
	
	/**
	 * OGridTag默认的模板名
	 */
	public static final String TEMPLATE = "ogrid";
	public static final String TEMPLATE_CLOSE = "ogrid-close";
	
	protected String afterEditCell;
	protected String afterRestoreCell;
	protected String afterrestorefunc;
	protected String afterSaveCell;
	protected String aftersavefunc;
	protected String afterSubmitCell;
	protected String autowidth;
	protected String beforeEditCell;
	protected String beforeProcessing;
	protected String beforeRequest;
	protected String beforeSaveCell;
	protected String beforeSubmitCell;
	protected String bottomPager;
	protected String caption;
	protected String cellurl;
	protected String datatype;
	protected String editModel;
	protected String editurl;
	protected String errorCell;
	protected String errorfunc;
	protected String expandColumn;
	protected String expandedField;
	protected String footerrow;
	protected String formatCell;
	protected String gridComplete;
	protected String gridview;
	protected String height;
	protected String hiddengrid;
	protected String hidegrid;
	protected String leafField;
	protected String levelField;
	protected String loadBeforeSend;
	protected String loadComplete;
	protected String loadError;
	protected String multiselect;
	protected String ondblClickRow;
	protected String oneditfunc;
	protected String onSelectCell;
	protected String onSelectRow;
	protected String parentIdField;
	protected String rowList;
	protected String rowNum;
	protected String rownumbers;
	protected String serializeCellData;
	protected String serializeGridData;
	protected String serializeRowData;
	protected String shrinkToFit;
	protected String sortable;
	protected String sortname;
	protected String sortorder;
	protected String successfunc;
	protected String treeGrid;
	protected String url;
	protected String viewrecords;
	protected String width;
	protected String toppager;
	protected String loadonce;
	protected String rowTotal;
	protected String scroll;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(datatype != null) {
			this.addParameter("datatype", datatype);
		}
		if(url != null) {
			this.addParameter("url", url);
		}
		if(gridview != null) {
			this.addParameter("gridview", gridview);
		}
		if(rowNum != null) {
			this.addParameter("rowNum", rowNum);
		}
		if(rowList != null) {
			this.addParameter("rowList", rowList);
		}
		if(viewrecords != null) {
			this.addParameter("viewrecords", viewrecords);
		}
		if(multiselect != null) {
			this.addParameter("multiselect", multiselect);
		}
		if(rownumbers != null) {
			this.addParameter("rownumbers", rownumbers);
		}
		if(hiddengrid != null) {
			this.addParameter("hiddengrid", hiddengrid);
		}
		if(hidegrid != null) {
			this.addParameter("hidegrid", hidegrid);
		}
		if(sortname != null) {
			this.addParameter("sortname", sortname);
		}
		if(sortorder != null) {
			this.addParameter("sortorder", sortorder);
		}
		if(footerrow != null) {
			this.addParameter("footerrow", footerrow);
		}
		if(shrinkToFit != null) {
			this.addParameter("shrinkToFit", shrinkToFit);
		}
		if(autowidth != null) {
			this.addParameter("autowidth", autowidth);
		}
		if(width != null) {
			this.addParameter("width", width);
		}
		if(height != null) {
			this.addParameter("height", height);
		}
		if(caption != null) {
			this.addParameter("caption", caption);
		}
		if(bottomPager != null) {
			this.addParameter("bottomPager", bottomPager);
		}
		
		if(editModel != null) {
			this.addParameter("editModel", editModel);
		}
		if(cellurl != null) {
			this.addParameter("cellurl", cellurl);
		}
		if(editurl != null) {
			this.addParameter("editurl", editurl);
		}
		if(serializeRowData != null) {
			this.addParameter("serializeRowData", serializeRowData);
		}
		
		if(beforeRequest != null) {
			this.addParameter("beforeRequest", beforeRequest);
		}
		if(loadBeforeSend != null) {
			this.addParameter("loadBeforeSend", loadBeforeSend);
		}
		if(serializeGridData != null) {
			this.addParameter("serializeGridData", serializeGridData);
		}
		if(loadError != null) {
			this.addParameter("loadError", loadError);
		}
		if(beforeProcessing != null) {
			this.addParameter("beforeProcessing", beforeProcessing);
		}
		if(gridComplete != null) {
			this.addParameter("gridComplete", gridComplete);
		}
		if(loadComplete != null) {
			this.addParameter("loadComplete", loadComplete);
		}
		
		if(onSelectRow != null) {
			this.addParameter("onSelectRow", onSelectRow);
		}
		if(ondblClickRow != null) {
			this.addParameter("ondblClickRow", ondblClickRow);
		}
		
		if(formatCell != null) {
			this.addParameter("formatCell", formatCell);
		}
		if(beforeEditCell != null) {
			this.addParameter("beforeEditCell", beforeEditCell);
		}
		if(afterEditCell != null) {
			this.addParameter("afterEditCell", afterEditCell);
		}
		if(beforeSaveCell != null) {
			this.addParameter("beforeSaveCell", beforeSaveCell);
		}
		if(beforeSubmitCell != null) {
			this.addParameter("beforeSubmitCell", beforeSubmitCell);
		}
		if(afterSubmitCell != null) {
			this.addParameter("afterSubmitCell", afterSubmitCell);
		}
		if(afterSaveCell != null) {
			this.addParameter("afterSaveCell", afterSaveCell);
		}
		if(errorCell != null) {
			this.addParameter("errorCell", errorCell);
		}
		if(onSelectCell != null) {
			this.addParameter("onSelectCell", onSelectCell);
		}
		if(afterRestoreCell != null) {
			this.addParameter("afterRestoreCell", afterRestoreCell);
		}
		if(serializeCellData != null) {
			this.addParameter("serializeCellData", serializeCellData);
		}
		
		if(oneditfunc != null) {
			this.addParameter("oneditfunc", oneditfunc);
		}
		if(afterrestorefunc != null) {
			this.addParameter("afterrestorefunc", afterrestorefunc);
		}
		if(successfunc != null) {
			this.addParameter("successfunc", successfunc);
		}
		if(aftersavefunc != null) {
			this.addParameter("aftersavefunc", aftersavefunc);
		}
		if(errorfunc != null) {
			this.addParameter("errorfunc", errorfunc);
		}
		
		if(treeGrid != null) {
			this.addParameter("treeGrid", treeGrid);
		}
		if(expandColumn != null) {
			this.addParameter("expandColumn", expandColumn);
		}
		if(levelField != null) {
			this.addParameter("levelField", levelField);
		}
		if(parentIdField != null) {
			this.addParameter("parentIdField", parentIdField);
		}
		if(leafField != null) {
			this.addParameter("leafField", leafField);
		}
		if(expandedField != null) {
			this.addParameter("expandedField", expandedField);
		}
		if(sortable != null) {
			this.addParameter("sortable", sortable);
		}
		if(toppager != null) {
			this.addParameter("toppager", toppager);
		}
		if(loadonce != null) {
			this.addParameter("loadonce", loadonce);
		}
		if(rowTotal != null) {
			this.addParameter("rowTotal", rowTotal);
		}
		if(scroll != null) {
			this.addParameter("scroll", scroll);
		}
		
	}
	
	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}
	
	public void setAfterEditCell(String afterEditCell) {
		this.afterEditCell = afterEditCell;
	}

	public void setAfterRestoreCell(String afterRestoreCell) {
		this.afterRestoreCell = afterRestoreCell;
	}

	public void setAfterrestorefunc(String afterrestorefunc) {
		this.afterrestorefunc = afterrestorefunc;
	}

	public void setAfterSaveCell(String afterSaveCell) {
		this.afterSaveCell = afterSaveCell;
	}

	public void setAftersavefunc(String aftersavefunc) {
		this.aftersavefunc = aftersavefunc;
	}

	public void setAfterSubmitCell(String afterSubmitCell) {
		this.afterSubmitCell = afterSubmitCell;
	}

	public void setAutowidth(String autowidth) {
		this.autowidth = autowidth;
	}

	public void setBeforeEditCell(String beforeEditCell) {
		this.beforeEditCell = beforeEditCell;
	}

	public void setBeforeProcessing(String beforeProcessing) {
		this.beforeProcessing = beforeProcessing;
	}

	public void setBeforeRequest(String beforeRequest) {
		this.beforeRequest = beforeRequest;
	}

	public void setBeforeSaveCell(String beforeSaveCell) {
		this.beforeSaveCell = beforeSaveCell;
	}

	public void setBeforeSubmitCell(String beforeSubmitCell) {
		this.beforeSubmitCell = beforeSubmitCell;
	}

	public void setBottomPager(String bottomPager) {
		this.bottomPager = bottomPager;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setCellurl(String cellurl) {
		this.cellurl = cellurl;
	}

	public void setEditModel(String editModel) {
		this.editModel = editModel;
	}

	public void setEditurl(String editurl) {
		this.editurl = editurl;
	}

	public void setErrorCell(String errorCell) {
		this.errorCell = errorCell;
	}

	public void setErrorfunc(String errorfunc) {
		this.errorfunc = errorfunc;
	}

	public void setExpandColumn(String expandColumn) {
		this.expandColumn = expandColumn;
	}

	public void setExpandedField(String expandedField) {
		this.expandedField = expandedField;
	}
	
	public void setFooterrow(String footerrow) {
		this.footerrow = footerrow;
	}

	public void setFormatCell(String formatCell) {
		this.formatCell = formatCell;
	}

	public void setGridComplete(String gridComplete) {
		this.gridComplete = gridComplete;
	}

	public void setGridview(String gridview) {
		this.gridview = gridview;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setHiddengrid(String hiddengrid) {
		this.hiddengrid = hiddengrid;
	}

	public void setHidegrid(String hidegrid) {
		this.hidegrid = hidegrid;
	}

	public void setLeafField(String leafField) {
		this.leafField = leafField;
	}

	public void setLevelField(String levelField) {
		this.levelField = levelField;
	}

	public void setLoadBeforeSend(String loadBeforeSend) {
		this.loadBeforeSend = loadBeforeSend;
	}

	public void setLoadComplete(String loadComplete) {
		this.loadComplete = loadComplete;
	}

	public void setLoadError(String loadError) {
		this.loadError = loadError;
	}

	public void setMultiselect(String multiselect) {
		this.multiselect = multiselect;
	}

	public void setOndblClickRow(String ondblClickRow) {
		this.ondblClickRow = ondblClickRow;
	}

	public void setOneditfunc(String oneditfunc) {
		this.oneditfunc = oneditfunc;
	}

	public void setOnSelectCell(String onSelectCell) {
		this.onSelectCell = onSelectCell;
	}

	public void setOnSelectRow(String onSelectRow) {
		this.onSelectRow = onSelectRow;
	}

	public void setParentIdField(String parentIdField) {
		this.parentIdField = parentIdField;
	}

	public void setRowList(String rowList) {
		this.rowList = rowList;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public void setRownumbers(String rownumbers) {
		this.rownumbers = rownumbers;
	}

	public void setSerializeCellData(String serializeCellData) {
		this.serializeCellData = serializeCellData;
	}

	public void setSerializeGridData(String serializeGridData) {
		this.serializeGridData = serializeGridData;
	}

	public void setSerializeRowData(String serializeRowData) {
		this.serializeRowData = serializeRowData;
	}

	public void setShrinkToFit(String shrinkToFit) {
		this.shrinkToFit = shrinkToFit;
	}

	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public void setSuccessfunc(String successfunc) {
		this.successfunc = successfunc;
	}

	public void setTreeGrid(String treeGrid) {
		this.treeGrid = treeGrid;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setViewrecords(String viewrecords) {
		this.viewrecords = viewrecords;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public void setToppager(String toppager) {
		this.toppager = toppager;
	}

	public void setLoadonce(String loadonce) {
		this.loadonce = loadonce;
	}

	public void setRowTotal(String rowTotal) {
		this.rowTotal = rowTotal;
	}

	public void setScroll(String scroll) {
		this.scroll = scroll;
	}

}
