package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Checkbox;

public class CheckboxTag extends InputTag {

	private static final long serialVersionUID = -4038289188229218117L;

	@Override
	public Component getBean() {
		return new Checkbox();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Checkbox bean = (Checkbox) component;
		bean.setType("checkbox");
	}

}
