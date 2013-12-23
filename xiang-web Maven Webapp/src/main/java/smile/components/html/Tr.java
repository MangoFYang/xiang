package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Tr extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "tr";
    public static final String TEMPLATE_CLOSE = "tr-close";

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
