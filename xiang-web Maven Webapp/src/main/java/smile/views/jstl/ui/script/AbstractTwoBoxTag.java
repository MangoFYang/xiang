package smile.views.jstl.ui.script;

import smile.components.script.AbstractTwoBox;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractTwoBoxTag extends AbstractList4InputTag {

	private static final long serialVersionUID = 570347114534062401L;
	
	protected String leftGtRight;
	protected String odialogHeight;
	protected String odialogWidth;
	protected String title;
	protected String valueSeparator;

    protected void populateParams() {
        super.populateParams();
        AbstractTwoBox twoBox = (AbstractTwoBox) component;
        twoBox.setTitle(title);
        twoBox.setOdialogWidth(odialogWidth);
        twoBox.setOdialogHeight(odialogHeight);
        twoBox.setLeftGtRight(leftGtRight);
        twoBox.setValueSeparator(valueSeparator);
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
