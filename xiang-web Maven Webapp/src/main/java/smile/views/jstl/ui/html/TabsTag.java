package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Tabs;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class TabsTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = -5281087308158340368L;

	@Override
	public Component getBean() {
		return new Tabs();
	}

}
