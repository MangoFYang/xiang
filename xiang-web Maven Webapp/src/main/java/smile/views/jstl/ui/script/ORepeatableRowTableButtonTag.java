package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.ORepeatableRowTableButton;

public class ORepeatableRowTableButtonTag extends OTableButtonTag {

	private static final long serialVersionUID = -6684098526987522443L;

	@Override
	public Component getBean() {
		return new ORepeatableRowTableButton();
	}
	
}
