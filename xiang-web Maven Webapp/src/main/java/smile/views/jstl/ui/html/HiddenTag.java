package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Hidden;

public class HiddenTag extends InputTag {

	private static final long serialVersionUID = 8576017757101881829L;
	
	@Override
	public Component getBean() {
		return new Hidden();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Hidden bean = (Hidden) component;
		bean.setType("hidden");
	}
	
}
