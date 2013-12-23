package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OLocation;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OLocationTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 3796341679452903899L;
	
	protected String location;
	protected String separator;

	@Override
	public Component getBean() {
		return new OLocation();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OLocation olocation = (OLocation) this.component;
		
		olocation.setLocation(location);
		olocation.setSeparator(separator);
		
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

}
