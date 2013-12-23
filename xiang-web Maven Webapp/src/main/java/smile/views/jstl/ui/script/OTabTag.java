package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTab;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OTabTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = -3141181493676815986L;
	
	protected String caption;
	protected String closable;
	protected String embedType;
	protected String url;
	protected String data;

	@Override
	public Component getBean() {
		return new OTab();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTab oTab = (OTab) component;
		oTab.setCaption(caption);
		oTab.setUrl(url);
		oTab.setEmbedType(embedType);
		oTab.setClosable(closable);
		oTab.setData(data);
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setClosable(String closable) {
		this.closable = closable;
	}

	public void setEmbedType(String embedType) {
		this.embedType = embedType;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setData(String data) {
		this.data = data;
	}

}
