package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Pre extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "pre";
    public static final String TEMPLATE_CLOSE = "pre-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
