package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTableButton;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OTableButtonTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 3924078400082290628L;
	
	protected String click;
	protected String label;

	@Override
	public Component getBean() {
		return new OTableButton();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTableButton gridButton = (OTableButton) component;
		gridButton.setLabel(label);
		gridButton.setClick(click);
	}

	public void setClick(String click) {
		this.click = click;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
