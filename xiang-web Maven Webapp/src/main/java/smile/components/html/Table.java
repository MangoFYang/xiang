package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Table extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "table";
    public static final String TEMPLATE_CLOSE = "table-close";
    
    protected String width;
    protected String layout;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(width != null) {
			this.addParameter("width", width);
		}
		if(layout != null) {
			this.addParameter("layout", layout);
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

	public void setWidth(String width) {
		this.width = width;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

}
