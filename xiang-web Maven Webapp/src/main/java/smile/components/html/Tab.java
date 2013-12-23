package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Tab extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "tab";
    public static final String TEMPLATE_CLOSE = "tab-close";
    
    protected String height;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(height != null) {
			this.addParameter("height", height);
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

	public void setHeight(String height) {
		this.height = height;
	}
	
}
