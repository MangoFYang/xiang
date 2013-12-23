package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Ul;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class UlTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = -8165161273086348039L;

	@Override
	public Component getBean() {
		return new Ul();
	}

}