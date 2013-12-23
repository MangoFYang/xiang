package smile.views.jstl.ui;

import smile.components.Component;
import smile.components.Demo;

public class DemoTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 6665137551026275479L;
	
	public Component getBean() {
		return new Demo();
	}
	
}
