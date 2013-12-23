package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Html;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class HtmlTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 7010348910198860989L;
	
    protected String overflowX;
    protected String overflowY;

	@Override
	public Component getBean() {
		return new Html();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Html html = (Html) this.component;
		html.setOverflowX(overflowX);
		html.setOverflowY(overflowY);
	}

	public void setOverflowX(String overflowX) {
		this.overflowX = overflowX;
	}

	public void setOverflowY(String overflowY) {
		this.overflowY = overflowY;
	}
	
}
