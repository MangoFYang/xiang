package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Span extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "span";
    public static final String TEMPLATE_CLOSE = "span-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
