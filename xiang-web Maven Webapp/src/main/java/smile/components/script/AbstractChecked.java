package smile.components.script;

import smile.components.AbstractUIBean;

public abstract class AbstractChecked extends AbstractUIBean {
	
    /**
     * OCheckboxRadioTag默认的模板名
     */
    public static final String TEMPLATE = "ocheckboxradio";
    
	protected String label;
	protected String value;
	protected String checked;
	protected String check;
	protected String uncheck;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(label != null) {
			this.addParameter("label", label);
		}
		if(value != null) {
			this.addParameter("value", value);
		}
		if(checked != null) {
			this.addParameter("checked", checked);
		}
		if(check != null) {
			this.addParameter("check", check);
		}
		if(uncheck != null) {
			this.addParameter("uncheck", uncheck);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public void setUncheck(String uncheck) {
		this.uncheck = uncheck;
	}

}
