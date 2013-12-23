package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.P;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class PTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = -8165161273086348039L;

	@Override
	public Component getBean() {
		return new P();
	}

}
