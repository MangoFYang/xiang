package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Tab;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class TabTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = -3280315657914186598L;
	
    protected String height;

	@Override
	public Component getBean() {
		return new Tab();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Tab tab = (Tab) this.component;
		tab.setHeight(height);
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
}
