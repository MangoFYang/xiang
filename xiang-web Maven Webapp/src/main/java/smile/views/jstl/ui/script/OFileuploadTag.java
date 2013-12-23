package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OFileupload;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OFileuploadTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 5583687689229339288L;
	
	protected String label;
	protected String url;
	protected String detailAppendTo;
	protected String add;
	protected String done;
	protected String fail;

	@Override
	public Component getBean() {
		return new OFileupload();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OFileupload oFileupload = (OFileupload) this.component;
		
		oFileupload.setLabel(label);
		oFileupload.setUrl(url);
		oFileupload.setDetailAppendTo(detailAppendTo);
		oFileupload.setAdd(add);
		oFileupload.setDone(done);
		oFileupload.setFail(fail);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDetailAppendTo(String detailAppendTo) {
		this.detailAppendTo = detailAppendTo;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}

}
