package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTreeSelect;


/**
 * 
 * @author 杨帆
 *
 */
public class OTreeSelectTag extends AbstractTwoBoxTag {

	private static final long serialVersionUID = -1953000411772430357L;
	
	protected String model;
	protected String parent4Root;
	protected String parentIdField;
	protected String selectableField;
	protected String twoState;
	
	@Override
	public Component getBean() {
		return new OTreeSelect();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTreeSelect otreeSelect = (OTreeSelect) component;
		otreeSelect.setSelectableField(selectableField);
		otreeSelect.setModel(model);
		otreeSelect.setParentIdField(parentIdField);
		otreeSelect.setParent4Root(parent4Root);
		otreeSelect.setTwoState(twoState);
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setParent4Root(String parent4Root) {
		this.parent4Root = parent4Root;
	}

	public void setParentIdField(String parentIdField) {
		this.parentIdField = parentIdField;
	}

	public void setSelectableField(String selectableField) {
		this.selectableField = selectableField;
	}

	public void setTwoState(String twoState) {
		this.twoState = twoState;
	}
	
}
