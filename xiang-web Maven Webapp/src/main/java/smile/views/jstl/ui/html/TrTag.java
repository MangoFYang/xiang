package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Tr;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class TrTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = -8208667631668293097L;

	@Override
	public Component getBean() {
		return new Tr();
	}

}
