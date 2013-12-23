package smile.components.script;

import smile.components.AbstractUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class OTab extends AbstractUIBean {
	
	/**
	 * OTabTag默认的模板名
	 */
	public static final String TEMPLATE = "otab";
	
	protected String caption;
	protected String closable;
	protected String embedType;
	protected String url;
	protected String data;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(caption != null) {
			this.addParameter("caption", caption);
		}
		if(url != null) {
			this.addParameter("url", url);
		}
		if(embedType != null) {
			this.addParameter("embedType", embedType);
		}
		if(closable != null) {
			this.addParameter("closable", closable);
		}
		if(data != null) {
			this.addParameter("data", data);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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
