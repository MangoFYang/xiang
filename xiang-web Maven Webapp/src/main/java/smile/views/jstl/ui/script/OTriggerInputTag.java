package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTriggerInput;

public class OTriggerInputTag extends OTextFieldTag {

	private static final long serialVersionUID = 2439905956360736589L;
	
	protected String hideTrigger;
	protected String readOnlyInput;
	protected String triggerCls;
	protected String triggerWidth;
	
    @Override
	public Component getBean() {
		return new OTriggerInput();
	}

	protected void populateParams() {
        super.populateParams();
        OTriggerInput oTriggerInput = (OTriggerInput) component;
        oTriggerInput.setHideTrigger(hideTrigger);
        oTriggerInput.setTriggerWidth(triggerWidth);
        oTriggerInput.setTriggerCls(triggerCls);
        oTriggerInput.setReadOnlyInput(readOnlyInput);
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
