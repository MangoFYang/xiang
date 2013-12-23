package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.A;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class ATag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 4342891017517983757L;
	
	protected String href;

	@Override
	public Component getBean() {
		return new A();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		A a = (A) component;
		a.setHref(href);
	}

	public void setHref(String href) {
		this.href = href;
	}

}
