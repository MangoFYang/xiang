package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Button;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class ButtonTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 6357491501617749681L;

	@Override
	public Component getBean() {
		return new Button();
	}

}
