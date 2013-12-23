package smile.components.script;

import smile.components.AbstractClosingUIBean;

public class OTable extends AbstractClosingUIBean {
	
	public static final String TEMPLATE = "otable";
	public static final String TEMPLATE_CLOSE = "otable-close";
    
    protected String caption;
    protected String collapsible;
    protected String collapsing;
    protected String hideBottomToolbar;
    protected String hideCaption;
    protected String hideTopToolbar;
    protected String clearable;
    protected String resetable;
    protected String toolbarAlign;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(caption != null) {
			this.addParameter("caption", caption);
		}
		if(collapsible != null) {
			this.addParameter("collapsible", collapsible);
		}
		if(hideCaption != null) {
			this.addParameter("hideCaption", hideCaption);
		}
		if(hideTopToolbar != null) {
			this.addParameter("hideTopToolbar", hideTopToolbar);
		}
		if(hideBottomToolbar != null) {
			this.addParameter("hideBottomToolbar", hideBottomToolbar);
		}
		if(clearable != null) {
			this.addParameter("clearable", clearable);
		}
		if(resetable != null) {
			this.addParameter("resetable", resetable);
		}
		if(toolbarAlign != null) {
			this.addParameter("toolbarAlign", toolbarAlign);
		}
		if(collapsing != null) {
			this.addParameter("collapsing", collapsing);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}
	
	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setCollapsible(String collapsible) {
		this.collapsible = collapsible;
	}

	public void setHideBottomToolbar(String hideBottomToolbar) {
		this.hideBottomToolbar = hideBottomToolbar;
	}

	public void setHideCaption(String hideCaption) {
		this.hideCaption = hideCaption;
	}

	public void setHideTopToolbar(String hideTopToolbar) {
		this.hideTopToolbar = hideTopToolbar;
	}

	public void setClearable(String clearable) {
		this.clearable = clearable;
	}

	public void setResetable(String resetable) {
		this.resetable = resetable;
	}

	public void setToolbarAlign(String toolbarAlign) {
		this.toolbarAlign = toolbarAlign;
	}

	public void setCollapsing(String collapsing) {
		this.collapsing = collapsing;
	}

}
