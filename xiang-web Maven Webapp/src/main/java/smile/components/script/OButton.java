package smile.components.script;

import smile.components.AbstractUIBean;

public class OButton extends AbstractUIBean {
	
    /**
     * OButtonTag默认的模板名
     */
    public static final String TEMPLATE = "obutton";
    
    protected String disabled;
    protected String primaryIcon;
    protected String secondaryIcon;
    protected String text;
    protected String click;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(disabled != null) {
			this.addParameter("disabled", disabled);
		}
		if(text != null) {
			this.addParameter("text", text);
		}
		if(primaryIcon != null) {
			this.addParameter("primaryIcon", primaryIcon);
		}
		if(secondaryIcon != null) {
			this.addParameter("secondaryIcon", secondaryIcon);
		}
		if(click != null) {
			this.addParameter("click", click);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setPrimaryIcon(String primaryIcon) {
		this.primaryIcon = primaryIcon;
	}

	public void setSecondaryIcon(String secondaryIcon) {
		this.secondaryIcon = secondaryIcon;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setClick(String click) {
		this.click = click;
	}

}
