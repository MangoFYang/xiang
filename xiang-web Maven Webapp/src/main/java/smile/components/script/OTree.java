package smile.components.script;


/**
 * 
 * @author 杨帆
 *
 */
public class OTree extends AbstractList4ExcludeInput {
	
	/**
	 * OTreeTag默认的模板名
	 */
	public static final String TEMPLATE = "otree";
	
	protected String afterClose;
	protected String afterOpen;
	protected String checkboxDisabled;
	protected String selectNode;
	protected String deselectNode;
	protected String checkNode;
	protected String closeNode;
	protected String loaded;
	
	protected String model;
	protected String openNode;
	protected String parent4Root;
	protected String parentIdField;
	protected String selectableField;
	protected String stateField;
	protected String twoState;
	protected String uncheckNode;

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
		if(checkboxDisabled != null) {
			this.addParameter("checkboxDisabled", checkboxDisabled);
		}
		if(twoState != null) {
			this.addParameter("twoState", twoState);
		}
		if(loaded != null) {
			this.addParameter("loaded", loaded);
		}
		if(afterOpen != null) {
			this.addParameter("afterOpen", afterOpen);
		}
		if(closeNode != null) {
			this.addParameter("closeNode", closeNode);
		}
		if(checkNode != null) {
			this.addParameter("checkNode", checkNode);
		}
		if(uncheckNode != null) {
			this.addParameter("uncheckNode", uncheckNode);
		}
		if(selectNode != null) {
			this.addParameter("selectNode", selectNode);
		}
		if(deselectNode != null) {
			this.addParameter("deselectNode", deselectNode);
		}
		if(stateField != null) {
			this.addParameter("stateField", stateField);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setAfterClose(String afterClose) {
		this.afterClose = afterClose;
	}

	public void setAfterOpen(String afterOpen) {
		this.afterOpen = afterOpen;
	}

	public void setCheckboxDisabled(String checkboxDisabled) {
		this.checkboxDisabled = checkboxDisabled;
	}

	public void setCheckNode(String checkNode) {
		this.checkNode = checkNode;
	}

	public void setCloseNode(String closeNode) {
		this.closeNode = closeNode;
	}

	public void setLoaded(String loaded) {
		this.loaded = loaded;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOpenNode(String openNode) {
		this.openNode = openNode;
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

	public void setUncheckNode(String uncheckNode) {
		this.uncheckNode = uncheckNode;
	}

	public void setSelectNode(String selectNode) {
		this.selectNode = selectNode;
	}

	public void setDeselectNode(String deselectNode) {
		this.deselectNode = deselectNode;
	}

	public void setStateField(String stateField) {
		this.stateField = stateField;
	}

}