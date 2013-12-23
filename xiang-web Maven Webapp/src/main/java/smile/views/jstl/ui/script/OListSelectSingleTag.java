package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OListSelectSingle;


/**
 * 
 * @author 杨帆
 *
 */
public class OListSelectSingleTag extends AbstractSingleBoxTag {

	private static final long serialVersionUID = 6814086747855089428L;
	
	protected String select;
	
	@Override
	public Component getBean() {
		return new OListSelectSingle();
	}
	
    protected void populateParams() {
        super.populateParams();
        OListSelectSingle single = (OListSelectSingle) component;
        single.setSelect(select);
    }

	public void setSelect(String select) {
		this.select = select;
	}
	
}
