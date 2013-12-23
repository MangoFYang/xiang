package smile.components.script;

import smile.components.AbstractClosingUIBean;

public class OTabs extends AbstractClosingUIBean {
	
    /**
     * OTabsTag默认的模板名
     */
	public static final String TEMPLATE = "otabs";
	public static final String TEMPLATE_CLOSE = "otabs-close";
	
	protected String load;
	protected String select;
	protected String show;
	protected String tabsDirection;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(select != null) {
			this.addParameter("select", select);
		}
		if(load != null) {
			this.addParameter("load", load);
		}
		if(show != null) {
			this.addParameter("show", show);
		}
		if(tabsDirection != null) {
			this.addParameter("tabsDirection", tabsDirection);
		}
	}

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
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
