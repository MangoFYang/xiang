package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OCheckbox;


public class OCheckboxTag extends AbstractCheckedTag {

	private static final long serialVersionUID = -8302791329630763531L;
	
	@Override
	public Component getBean() {
		return new OCheckbox();
	}

}
