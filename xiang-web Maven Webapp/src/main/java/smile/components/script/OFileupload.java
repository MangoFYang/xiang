package smile.components.script;

import smile.components.AbstractUIBean;

public class OFileupload extends AbstractUIBean {
	
    /**
     * OFileTag默认的模板名
     */
    public static final String TEMPLATE = "ofileupload";
    
	protected String label;
	protected String url;
	protected String detailAppendTo;
	protected String add;
	protected String done;
	protected String fail;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(label != null) {
			this.addParameter("label", label);
		}
		if(url != null) {
			this.addParameter("url", url);
		}
		if(detailAppendTo != null) {
			this.addParameter("detailAppendTo", detailAppendTo);
		}
		if(add != null) {
			this.addParameter("add", add);
		}
		if(done != null) {
			this.addParameter("done", done);
		}
		if(fail != null) {
			this.addParameter("fail", fail);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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
