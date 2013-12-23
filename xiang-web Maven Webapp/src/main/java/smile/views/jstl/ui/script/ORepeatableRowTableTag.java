package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.ORepeatableRowTable;

/**
 * 
 * @author 杨帆
 *
 */
public class ORepeatableRowTableTag extends OTableTag {

	private static final long serialVersionUID = -2572521610708223488L;
	
	@Override
	public Component getBean() {
		return new ORepeatableRowTable();
	}
	
}
