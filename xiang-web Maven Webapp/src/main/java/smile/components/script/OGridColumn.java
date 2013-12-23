package smile.components.script;

import smile.components.AbstractUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class OGridColumn extends AbstractUIBean {
	
	/**
	 * OGridTag默认的模板名
	 */
	public static final String TEMPLATE = "ogridcolumn";
	
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
	protected void evaluateParams() {
		super.evaluateParams();
		if(name != null) {
			this.addParameter("name", name);
		}
		if(label != null) {
			this.addParameter("label", label);
		}
		if(width != null) {
			this.addParameter("width", width);
		}
		if(align != null) {
			this.addParameter("align", align);
		}
		if(hidden != null) {
			this.addParameter("hidden", hidden);
		}
		if(hidedlg != null) {
			this.addParameter("hidedlg", hidedlg);
		}
		if(formatterAlias != null) {
			this.addParameter("formatterAlias", formatterAlias);
		}
		if(editorAlias != null) {
			this.addParameter("editorAlias", editorAlias);
		}
		if(sortable != null) {
			this.addParameter("sortable", sortable);
		}
		if(resizable != null) {
			this.addParameter("resizable", resizable);
		}
		if(sortname != null) {
			this.addParameter("sortname", sortname);
		}
		if(sortorder != null) {
			this.addParameter("sortorder", sortorder);
		}
		if(frozen != null) {
			this.addParameter("frozen", frozen);
		}
		if(key != null) {
			this.addParameter("key", key);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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
