package smile.views.jstl.ui.script;

import smile.components.script.AbstractChecked;
import smile.views.jstl.ui.AbstractUIBeanTag;

public abstract class AbstractCheckedTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 3796341679452903899L;
	
	protected String label;
	protected String value;
	protected String checked;
	protected String check;
	protected String uncheck;

	@Override
	protected void populateParams() {
		super.populateParams();
		AbstractChecked abstractChecked = (AbstractChecked) this.component;
		
		abstractChecked.setLabel(label);
		abstractChecked.setValue(value);
		abstractChecked.setChecked(checked);
		abstractChecked.setCheck(check);
		abstractChecked.setUncheck(uncheck);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public void setUncheck(String uncheck) {
		this.uncheck = uncheck;
	}

}
