package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Html extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "html";
    public static final String TEMPLATE_CLOSE = "html-close";
    
    protected String overflowX;
    protected String overflowY;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(overflowX != null) {
			this.addParameter("overflowX", overflowX);
		}
		if(overflowY != null) {
			this.addParameter("overflowY", overflowY);
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

	public void setOverflowX(String overflowX) {
		this.overflowX = overflowX;
	}

	public void setOverflowY(String overflowY) {
		this.overflowY = overflowY;
	}
	
}
