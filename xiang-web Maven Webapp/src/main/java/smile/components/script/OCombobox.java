package smile.components.script;


public class OCombobox extends AbstractList4Input {
	
    /**
     * OComboboxTag默认的模板名
     */
    public static final String TEMPLATE = "ocombobox";
    
	protected String autoFocus;
	protected String delay;
	protected String menuMaxHeight;
	protected String minLength;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(autoFocus != null) {
			this.addParameter("autoFocus", autoFocus);
		}
		if(minLength != null) {
			this.addParameter("minLength", minLength);
		}
		if(delay != null) {
			this.addParameter("delay", delay);
		}
		if(menuMaxHeight != null) {
			this.addParameter("menuMaxHeight", menuMaxHeight);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setAutoFocus(String autoFocus) {
		this.autoFocus = autoFocus;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setMenuMaxHeight(String menuMaxHeight) {
		this.menuMaxHeight = menuMaxHeight;
	}

	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}

}
