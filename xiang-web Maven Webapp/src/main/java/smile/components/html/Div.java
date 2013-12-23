package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Div extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "div";
    public static final String TEMPLATE_CLOSE = "div-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
