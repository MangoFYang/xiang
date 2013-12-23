package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OGridButton;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OGridButtonTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 6665137551026275479L;
	
	protected String click;
	protected String label;

	@Override
	public Component getBean() {
		return new OGridButton();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OGridButton gridButton = (OGridButton) component;
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
