package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Body;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class BodyTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 8449576389987149369L;

	@Override
	public Component getBean() {
		return new Body();
	}

}
