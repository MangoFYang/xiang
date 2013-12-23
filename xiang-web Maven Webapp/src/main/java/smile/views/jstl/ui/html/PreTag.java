package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Pre;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class PreTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 3446460192076454338L;

	@Override
	public Component getBean() {
		return new Pre();
	}

}
