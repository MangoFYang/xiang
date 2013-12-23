package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Head;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class HeadTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 6665137551026275479L;
	
	protected String description;
	protected String keywords;
	protected String title;

	@Override
	public Component getBean() {
		return new Head();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Head head = (Head) component;
		head.setTitle(title);
		head.setKeywords(keywords);
		head.setDescription(description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
