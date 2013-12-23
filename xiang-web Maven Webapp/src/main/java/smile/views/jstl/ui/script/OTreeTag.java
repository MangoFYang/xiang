package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTree;

/**
 * 
 * @author 杨帆
 *
 */
public class OTreeTag extends AbstractList4ExcludeInputTag {
	
	private static final long serialVersionUID = 8607007231149812022L;
	
	protected String afterClose;
	protected String afterOpen;
	protected String checkboxDisabled;
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
	protected String selectNode;
	protected String deselectNode;
	
	@Override
	public Component getBean() {
		return new OTree();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTree oTree = (OTree) component;
		oTree.setSelectableField(selectableField);
		oTree.setModel(model);
		oTree.setParentIdField(parentIdField);
		oTree.setParent4Root(parent4Root);
		oTree.setCheckboxDisabled(checkboxDisabled);
		oTree.setStateField(stateField);
		oTree.setTwoState(twoState);
		
		oTree.setLoaded(loaded);
		oTree.setAfterOpen(afterOpen);
		oTree.setOpenNode(openNode);
		oTree.setAfterClose(afterClose);
		oTree.setCloseNode(closeNode);
		oTree.setCheckNode(checkNode);
		oTree.setUncheckNode(uncheckNode);
		oTree.setSelectNode(selectNode);
		oTree.setDeselectNode(deselectNode);
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