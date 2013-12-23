package smile.views.jstl.ui.script;

import smile.components.script.AbstractSingleBox;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractSingleBoxTag extends AbstractList4InputTag {

	private static final long serialVersionUID = 570347114534062401L;
	
	protected String odialogHeight;
	protected String odialogWidth;
	protected String title;
	protected String clear;

    protected void populateParams() {
        super.populateParams();
        AbstractSingleBox singleBox = (AbstractSingleBox) component;
        singleBox.setTitle(title);
        singleBox.setOdialogWidth(odialogWidth);
        singleBox.setOdialogHeight(odialogHeight);
        singleBox.setClear(clear);
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

	public void setClear(String clear) {
		this.clear = clear;
	}

}
