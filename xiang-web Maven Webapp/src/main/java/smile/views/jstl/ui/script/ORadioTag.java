package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.ORadio;


public class ORadioTag extends AbstractCheckedTag {

	private static final long serialVersionUID = 8237666868225037813L;
	
	@Override
	public Component getBean() {
		return new ORadio();
	}

}
