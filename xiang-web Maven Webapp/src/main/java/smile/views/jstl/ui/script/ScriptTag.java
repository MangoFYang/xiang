package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.Script;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class ScriptTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 8068929733159231870L;
	
	protected String src;

	@Override
	public Component getBean() {
		return new Script();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Script script = (Script) this.component;
		script.setSrc(src);
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
}
