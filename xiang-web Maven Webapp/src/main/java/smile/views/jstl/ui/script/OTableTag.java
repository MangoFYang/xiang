package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTable;
import smile.views.jstl.ui.AbstractUIBeanTag;

/**
 * 
 * @author 杨帆
 *
 */
public class OTableTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 2043003446082000307L;
	
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
	public Component getBean() {
		return new OTable();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTable oTable = (OTable) this.component;
		oTable.setCaption(caption);
		oTable.setCollapsible(collapsible);
		oTable.setHideCaption(hideCaption);
		oTable.setHideTopToolbar(hideTopToolbar);
		oTable.setHideBottomToolbar(hideBottomToolbar);
		oTable.setClearable(clearable);
		oTable.setResetable(resetable);
		oTable.setToolbarAlign(toolbarAlign);
		oTable.setCollapsing(collapsing);
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
