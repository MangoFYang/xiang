package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Radio;

public class RadioTag extends InputTag {

	private static final long serialVersionUID = 1632134584813654201L;

	@Override
	public Component getBean() {
		return new Radio();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Radio bean = (Radio) component;
		bean.setType("radio");
	}

}
