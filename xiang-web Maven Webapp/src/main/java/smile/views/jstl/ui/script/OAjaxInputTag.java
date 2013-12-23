package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OAjaxInput;

public class OAjaxInputTag extends OTextFieldTag {

	private static final long serialVersionUID = 2439905956360736589L;
	
	protected String onComplete;
	protected String termName;
	protected String url;
	
    @Override
	public Component getBean() {
		return new OAjaxInput();
	}

	protected void populateParams() {
        super.populateParams();
        OAjaxInput oajaxInput = (OAjaxInput) this.component;
        oajaxInput.setUrl(url);
        oajaxInput.setTermName(termName);
        oajaxInput.setOnComplete(onComplete);
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
