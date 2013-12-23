package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Ul extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "ul";
    public static final String TEMPLATE_CLOSE = "ul-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
