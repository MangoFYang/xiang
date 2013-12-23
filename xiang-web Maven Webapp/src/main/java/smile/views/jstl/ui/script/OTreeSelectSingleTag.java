package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTreeSelectSingle;


/**
 * 
 * @author 杨帆
 *
 */
public class OTreeSelectSingleTag extends AbstractSingleBoxTag {

	private static final long serialVersionUID = -1953000411772430357L;
	
	protected String model;
	protected String parent4Root;
	protected String parentIdField;
	protected String selectableField;
	protected String select;
	
	@Override
	public Component getBean() {
		return new OTreeSelectSingle();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTreeSelectSingle otreeSelectSingle = (OTreeSelectSingle) component;
		otreeSelectSingle.setSelectableField(selectableField);
		otreeSelectSingle.setModel(model);
		otreeSelectSingle.setParentIdField(parentIdField);
		otreeSelectSingle.setParent4Root(parent4Root);
		otreeSelectSingle.setSelect(select);
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

	public void setSelect(String select) {
		this.select = select;
	}
	
}
