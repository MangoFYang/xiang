package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.ORepeatableRowTableColumn;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class ORepeatableRowTableColumnTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = -3028329735141244699L;
	
	protected String name;
	protected String label;
	protected String type;
	protected String options;

	@Override
	public Component getBean() {
		return new ORepeatableRowTableColumn();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		ORepeatableRowTableColumn orepeatablerowtablecolumn = (ORepeatableRowTableColumn) component;
		orepeatablerowtablecolumn.setName(name);
		orepeatablerowtablecolumn.setLabel(label);
		orepeatablerowtablecolumn.setType(type);
		orepeatablerowtablecolumn.setOptions(options);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
}
