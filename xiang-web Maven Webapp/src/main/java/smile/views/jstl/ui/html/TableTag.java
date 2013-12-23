package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Table;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class TableTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 1079677689139595479L;
	
	protected String width;
	protected String layout;

	@Override
	public Component getBean() {
		return new Table();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Table table = (Table) component;
		table.setWidth(width);
		table.setLayout(layout);
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

}
