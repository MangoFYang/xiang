package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Div;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class DivTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 8068929733159231870L;

	@Override
	public Component getBean() {
		return new Div();
	}

}
