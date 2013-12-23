package smile.components.script;

/**
 * 
 * @author 杨帆
 *
 */
/**
 * @author fange
 *
 */
public abstract class AbstractBaseList extends AbstractList4ExcludeInput {
	
	protected String multiSelect;
	protected String selectedClass;
	protected String hoverClass;
	
	protected String select;
	protected String unselect;
	
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(multiSelect != null) {
			this.addParameter("multiSelect", multiSelect);
		}
		if(selectedClass != null) {
			this.addParameter("selectedClass", selectedClass);
		}
		if(hoverClass != null) {
			this.addParameter("hoverClass", hoverClass);
		}
		if(select != null) {
			this.addParameter("select", select);
		}
		if(unselect != null) {
			this.addParameter("unselect", unselect);
		}
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
