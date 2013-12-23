package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.Output;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OutputTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 3796341679452903899L;
	
	protected String var;
	
	protected Object value;

	@Override
	public Component getBean() {
		return new Output();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Output output = (Output) this.component;
		output.setVar(var);
		output.setValue(value);
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
