package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Textarea;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class TextareaTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 2160926788923743356L;
	
	@Override
	public Component getBean() {
		return new Textarea();
	}

}
