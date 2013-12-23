package smile.components.script;

import smile.components.AbstractClosingUIBean;

public class Script extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "script";
    public static final String TEMPLATE_CLOSE = "script-close";
    
    protected String src;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(src != null) {
			this.addParameter("src", src);
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

	public void setSrc(String src) {
		this.src = src;
	}
	
}
