package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.File;

public class FileTag extends InputTag {

	private static final long serialVersionUID = 1632134584813654201L;

	@Override
	public Component getBean() {
		return new File();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		File bean = (File) component;
		bean.setType("file");
	}

}
