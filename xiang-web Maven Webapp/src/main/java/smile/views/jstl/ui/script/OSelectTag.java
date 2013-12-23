package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OSelect;


/**
 * 
 * @author 杨帆
 *
 */
public class OSelectTag extends AbstractSingleBoxTag {

	private static final long serialVersionUID = 6814086747855089428L;
	
	protected String select;
	
	@Override
	public Component getBean() {
		return new OSelect();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		OSelect oselect = (OSelect) component;
		oselect.setSelect(select);
	}

	public void setSelect(String select) {
		this.select = select;
	}
	
}
