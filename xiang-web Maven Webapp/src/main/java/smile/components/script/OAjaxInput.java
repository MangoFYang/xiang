package smile.components.script;

public class OAjaxInput extends OTextField {
	
    /**
     * OAjaxInputTag默认的模板名
     */
    public static final String TEMPLATE = "oajaxinput";
	
	protected String onComplete;
	protected String termName;
	protected String url;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(url != null) {
			this.addParameter("url", url);
		}
		if(termName != null) {
			this.addParameter("termName", termName);
		}
		if(onComplete != null) {
			this.addParameter("onComplete", onComplete);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}
	
	public void setOnComplete(String onComplete) {
		this.onComplete = onComplete;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
