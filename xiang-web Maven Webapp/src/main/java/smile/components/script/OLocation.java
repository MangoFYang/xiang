package smile.components.script;

import smile.components.AbstractUIBean;

public class OLocation extends AbstractUIBean {
	
    /**
     * OLocation默认的模板名
     */
    public static final String TEMPLATE = "olocation";
    
	protected String location;
	protected String separator;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(location != null) {
			this.addParameter("location", location);
		}
		if(separator != null) {
			this.addParameter("separator", separator);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
}
