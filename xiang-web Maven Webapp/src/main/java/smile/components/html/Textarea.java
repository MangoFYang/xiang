package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Textarea extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "textarea";
    public static final String TEMPLATE_CLOSE = "textarea-close";
    
	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

}
