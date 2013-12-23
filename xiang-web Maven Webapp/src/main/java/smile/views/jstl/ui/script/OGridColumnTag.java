package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OGridColumn;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OGridColumnTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 6665137551026275479L;
	
	protected String align;
	protected String editorAlias;
	protected String formatterAlias;
	protected String frozen;
	protected String hidden;
	protected String hidedlg;
	protected String key;
	protected String label;
	protected String name;
	protected String resizable;
	protected String sortable;
	protected String sortname;
	protected String sortorder;
	protected String width;

	@Override
	public Component getBean() {
		return new OGridColumn();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OGridColumn gridColumn = (OGridColumn) component;
		gridColumn.setName(name);
		gridColumn.setLabel(label);
		gridColumn.setWidth(width);
		gridColumn.setAlign(align);
		gridColumn.setHidden(hidden);
		gridColumn.setHidedlg(hidedlg);
		gridColumn.setFormatterAlias(formatterAlias);
		gridColumn.setEditorAlias(editorAlias);
		gridColumn.setSortable(sortable);
		gridColumn.setSortname(sortname);
		gridColumn.setSortorder(sortorder);
		gridColumn.setFrozen(frozen);
		gridColumn.setKey(key);
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public void setEditorAlias(String editorAlias) {
		this.editorAlias = editorAlias;
	}

	public void setFormatterAlias(String formatterAlias) {
		this.formatterAlias = formatterAlias;
	}

	public void setFrozen(String frozen) {
		this.frozen = frozen;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public void setHidedlg(String hidedlg) {
		this.hidedlg = hidedlg;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResizable(String resizable) {
		this.resizable = resizable;
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

	public void setWidth(String width) {
		this.width = width;
	}
	
}
