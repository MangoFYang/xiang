package smile.components.script;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractTwoBox extends AbstractList4Input {
	
	protected String leftGtRight;
	protected String odialogHeight;
	protected String odialogWidth;
	protected String title;
	protected String valueSeparator;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(title != null) {
			this.addParameter("title", title);
		}
		if(odialogWidth != null) {
			this.addParameter("odialogWidth", odialogWidth);
		}
		if(odialogHeight != null) {
			this.addParameter("odialogHeight", odialogHeight);
		}
		if(leftGtRight != null) {
			this.addParameter("leftGtRight", leftGtRight);
		}
		if(valueSeparator != null) {
			this.addParameter("valueSeparator", valueSeparator);
		}
	}

	public void setLeftGtRight(String leftGtRight) {
		this.leftGtRight = leftGtRight;
	}

	public void setOdialogHeight(String odialogHeight) {
		this.odialogHeight = odialogHeight;
	}

	public void setOdialogWidth(String odialogWidth) {
		this.odialogWidth = odialogWidth;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setValueSeparator(String valueSeparator) {
		this.valueSeparator = valueSeparator;
	}

}