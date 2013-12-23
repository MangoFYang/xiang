package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Input;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class InputTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = -5991010405041319424L;
	
	protected String name;
	
	protected String type;

	@Override
	public Component getBean() {
		return new Input();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Input bean = (Input) component;
		bean.setName(name);
		bean.setType(type);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
