package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Tabs extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "tabs";
    public static final String TEMPLATE_CLOSE = "tabs-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
