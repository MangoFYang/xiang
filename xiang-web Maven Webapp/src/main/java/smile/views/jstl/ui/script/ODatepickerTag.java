package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.ODatepicker;

public class ODatepickerTag extends OTriggerInputTag {

	private static final long serialVersionUID = -4288652149350463940L;

	@Override
	public Component getBean() {
		return new ODatepicker();
	}

}
