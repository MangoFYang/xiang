package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Li extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "li";
    public static final String TEMPLATE_CLOSE = "li-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
