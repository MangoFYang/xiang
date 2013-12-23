package smile.components.html;

import smile.components.AbstractUIBean;

public class Input extends AbstractUIBean {
	
    /**
     * InputTag默认的模板名
     */
    public static final String TEMPLATE = "input";
    
    protected String name;
    
    protected String type;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(name != null) {
			this.addParameter("name", name);
		}
		if(type != null) {
			this.addParameter("type", type);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
