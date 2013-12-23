package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class P extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "p";
    public static final String TEMPLATE_CLOSE = "p-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
