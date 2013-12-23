package smile.components.script;

import smile.components.AbstractUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class ORepeatableRowTableColumn extends AbstractUIBean {
	
	public static final String TEMPLATE = "orepeatablerowtablecolumn";
	
	protected String name;
	protected String label;
	protected String type;
	protected String options;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(name != null) {
			this.addParameter("name", name);
		}
		if(label != null) {
			this.addParameter("label", label);
		}
		if(type != null) {
			this.addParameter("type", type);
		}
		if(options != null) {
			this.addParameter("options", options);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
}
