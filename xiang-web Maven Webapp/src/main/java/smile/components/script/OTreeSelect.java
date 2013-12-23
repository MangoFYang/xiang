package smile.components.script;


/**
 * 
 * @author 杨帆
 *
 */
public class OTreeSelect extends AbstractTwoBox {
	
    /**
     * OListSelectTag默认的模板名
     */
    public static final String TEMPLATE = "otreeselect";
    
	protected String model;
	protected String parent4Root;
	protected String parentIdField;
	protected String selectableField;
	protected String twoState;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(selectableField != null) {
			this.addParameter("selectableField", selectableField);
		}
		if(model != null) {
			this.addParameter("model", model);
		}
		if(parentIdField != null) {
			this.addParameter("parentIdField", parentIdField);
		}
		if(parent4Root != null) {
			this.addParameter("parent4Root", parent4Root);
		}
		if(twoState != null) {
			this.addParameter("twoState", twoState);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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