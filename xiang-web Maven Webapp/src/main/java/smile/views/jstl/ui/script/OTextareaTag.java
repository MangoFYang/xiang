package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTextarea;

public class OTextareaTag extends OTextFieldTag {

	private static final long serialVersionUID = 3796341679452903899L;
	
	protected String height;
	
	@Override
	public Component getBean() {
		return new OTextarea();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTextarea otextarea = (OTextarea) this.component;
		otextarea.setHeight(height);
	}

	public void setHeight(String height) {
		this.height = height;
	}

}
