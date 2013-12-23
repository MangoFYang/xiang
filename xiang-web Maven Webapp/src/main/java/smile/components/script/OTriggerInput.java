package smile.components.script;

public class OTriggerInput extends OTextField {
	
    /**
     * OTriggerInputTag默认的模板名
     */
    public static final String TEMPLATE = "otriggerinput";
	
	protected String hideTrigger;
	protected String readOnlyInput;
	protected String triggerCls;
	protected String triggerWidth;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(hideTrigger != null) {
			this.addParameter("hideTrigger", hideTrigger);
		}
		if(triggerWidth != null) {
			this.addParameter("triggerWidth", triggerWidth);
		}
		if(triggerCls != null) {
			this.addParameter("triggerCls", triggerCls);
		}
		if(readOnlyInput != null) {
			this.addParameter("readOnlyInput", readOnlyInput);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public String getHideTrigger() {
		return hideTrigger;
	}

	public String getReadOnlyInput() {
		return readOnlyInput;
	}

	public String getTriggerCls() {
		return triggerCls;
	}

	public String getTriggerWidth() {
		return triggerWidth;
	}

	public void setHideTrigger(String hideTrigger) {
		this.hideTrigger = hideTrigger;
	}

	public void setReadOnlyInput(String readOnlyInput) {
		this.readOnlyInput = readOnlyInput;
	}

	public void setTriggerCls(String triggerCls) {
		this.triggerCls = triggerCls;
	}

	public void setTriggerWidth(String triggerWidth) {
		this.triggerWidth = triggerWidth;
	}
	
}
