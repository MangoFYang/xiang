package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTabs;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

/**
 * 
 * @author 杨帆
 *
 */
public class OTabsTag extends AbstractClosingUIBeanTag {
	
	private static final long serialVersionUID = -8063455357890117475L;

	protected String load;
	protected String select;
	protected String show;
	protected String tabsDirection;
	
	@Override
	public Component getBean() {
		return new OTabs();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		
		OTabs oTabs = (OTabs) this.component;
		oTabs.setSelect(select);
		oTabs.setLoad(load);
		oTabs.setShow(show);
		oTabs.setTabsDirection(tabsDirection);

	}

	public void setLoad(String load) {
		this.load = load;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setTabsDirection(String tabsDirection) {
		this.tabsDirection = tabsDirection;
	}
	
}
