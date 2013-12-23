package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OList;

/**
 * 
 * @author 杨帆
 *
 */
public class OListTag extends AbstractBaseListTag {
	
	private static final long serialVersionUID = 8607007231149812022L;
	
	protected String autoRefresh;
	protected String value;
	protected String valueSeparator;
	
	@Override
	public Component getBean() {
		return new OList();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OList oList = (OList) component;
		oList.setValue(value);
		oList.setValueSeparator(valueSeparator);
		oList.setAutoRefresh(autoRefresh);
	}

	public void setAutoRefresh(String autoRefresh) {
		this.autoRefresh = autoRefresh;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setValueSeparator(String valueSeparator) {
		this.valueSeparator = valueSeparator;
	}

}