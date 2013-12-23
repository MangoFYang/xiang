package smile.components.html;

import smile.components.AbstractUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class Head extends AbstractUIBean {
	
	/**
	 * OHeadTag默认的模板名
	 */
	public static final String TEMPLATE = "head";
	
	protected String description;
	protected String keywords;
	protected String title;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(title != null) {
			this.addParameter("title", title);
		}
		if(keywords != null) {
			this.addParameter("keywords", keywords);
		}
		if(description != null) {
			this.addParameter("description", description);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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
