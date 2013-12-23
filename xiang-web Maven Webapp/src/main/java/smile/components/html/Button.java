package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Button extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "button";
    public static final String TEMPLATE_CLOSE = "button-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
