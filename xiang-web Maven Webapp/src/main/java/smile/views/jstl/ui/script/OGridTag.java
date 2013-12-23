package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OGrid;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

/**
 * 
 * @author 杨帆
 *
 */
public class OGridTag extends AbstractClosingUIBeanTag {
	
	private static final long serialVersionUID = -8063455357890117475L;

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
	public Component getBean() {
		return new OGrid();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OGrid oGrid = (OGrid) component;
		oGrid.setUrl(url);
		oGrid.setDatatype(datatype);
		oGrid.setGridview(gridview);
		oGrid.setRowNum(rowNum);
		oGrid.setRowList(rowList);
		oGrid.setViewrecords(viewrecords);
		oGrid.setMultiselect(multiselect);
		oGrid.setRownumbers(rownumbers);
		oGrid.setHiddengrid(hiddengrid);
		oGrid.setHidegrid(hidegrid);
		oGrid.setSortname(sortname);
		oGrid.setSortorder(sortorder);
		oGrid.setFooterrow(footerrow);
		oGrid.setShrinkToFit(shrinkToFit);
		oGrid.setAutowidth(autowidth);
		oGrid.setWidth(width);
		oGrid.setHeight(height);
		oGrid.setCaption(caption);
		oGrid.setBottomPager(bottomPager);
		oGrid.setEditModel(editModel);
		oGrid.setCellurl(cellurl);
		oGrid.setEditurl(editurl);
		oGrid.setSerializeRowData(serializeRowData);
		oGrid.setBeforeRequest(beforeRequest);
		oGrid.setLoadBeforeSend(loadBeforeSend);
		oGrid.setSerializeGridData(serializeGridData);
		oGrid.setLoadError(loadError);
		oGrid.setBeforeProcessing(beforeProcessing);
		oGrid.setGridComplete(gridComplete);
		oGrid.setLoadComplete(loadComplete);
		oGrid.setOnSelectRow(onSelectRow);
		oGrid.setOndblClickRow(ondblClickRow);
		oGrid.setFormatCell(formatCell);
		oGrid.setBeforeEditCell(beforeEditCell);
		oGrid.setAfterEditCell(afterEditCell);
		oGrid.setBeforeSaveCell(beforeSaveCell);
		oGrid.setBeforeSubmitCell(beforeSubmitCell);
		oGrid.setAfterSubmitCell(afterSubmitCell);
		oGrid.setAfterSaveCell(afterSaveCell);
		oGrid.setErrorCell(errorCell);
		oGrid.setOnSelectCell(onSelectCell);
		oGrid.setAfterRestoreCell(afterRestoreCell);
		oGrid.setSerializeCellData(serializeCellData);
		oGrid.setOneditfunc(oneditfunc);
		oGrid.setAfterrestorefunc(afterrestorefunc);
		oGrid.setSuccessfunc(successfunc);
		oGrid.setErrorfunc(errorfunc);
		oGrid.setTreeGrid(treeGrid);
		oGrid.setExpandColumn(expandColumn);
		oGrid.setLevelField(levelField);
		oGrid.setParentIdField(parentIdField);
		oGrid.setLeafField(leafField);
		oGrid.setExpandedField(expandedField);
		oGrid.setSortable(sortable);
		oGrid.setToppager(toppager);
		oGrid.setRowTotal(rowTotal);
		oGrid.setLoadonce(loadonce);
		oGrid.setScroll(scroll);
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
