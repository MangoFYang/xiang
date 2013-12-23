package smile.views.jstl.ui.script;

import smile.components.script.AbstractBaseList;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractBaseListTag extends AbstractList4ExcludeInputTag {

	private static final long serialVersionUID = 1313381951452137891L;
	
	protected String multiSelect;
	protected String selectedClass;
	protected String hoverClass;
	
	protected String select;
	protected String unselect;
	
	@Override
	protected void populateParams() {
		super.populateParams();
		AbstractBaseList baseList = (AbstractBaseList) this.component;
		baseList.setMultiSelect(multiSelect);
		baseList.setSelectedClass(selectedClass);
		baseList.setHoverClass(hoverClass);
		baseList.setSelect(select);
		baseList.setUnselect(unselect);
	}

	public void setMultiSelect(String multiSelect) {
		this.multiSelect = multiSelect;
	}

	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
	}

	public void setHoverClass(String hoverClass) {
		this.hoverClass = hoverClass;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public void setUnselect(String unselect) {
		this.unselect = unselect;
	}

}
