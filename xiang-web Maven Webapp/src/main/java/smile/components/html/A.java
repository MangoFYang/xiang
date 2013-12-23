package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class A extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "a";
    public static final String TEMPLATE_CLOSE = "a-close";
    
    protected String href;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(href != null) {
			this.addParameter("href", href);
		}
	}

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
