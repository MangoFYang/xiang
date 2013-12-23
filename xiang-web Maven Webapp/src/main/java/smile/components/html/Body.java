package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Body extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "body";
    public static final String TEMPLATE_CLOSE = "body-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
