package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OListSelect;


/**
 * 
 * @author 杨帆
 *
 */
public class OListSelectTag extends AbstractTwoBoxTag {

	private static final long serialVersionUID = -1953000411772430357L;
	
	@Override
	public Component getBean() {
		return new OListSelect();
	}

}
