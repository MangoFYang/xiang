package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OCombobox;

/**
 * 
 * @author 杨帆
 *
 */
public class OComboboxTag extends AbstractList4InputTag {

	private static final long serialVersionUID = -5646390113255371804L;
	
	protected String autoFocus;
	protected String delay;
	protected String menuMaxHeight;
	protected String minLength;
	
	@Override
	public Component getBean() {
		return new OCombobox();
	}

    protected void populateParams() {
        super.populateParams();
        OCombobox oCombobox = (OCombobox) component;
        oCombobox.setAutoFocus(autoFocus);
        oCombobox.setMinLength(minLength);
        oCombobox.setDelay(delay);
        oCombobox.setMenuMaxHeight(menuMaxHeight);
    }

	public void setAutoFocus(String autoFocus) {
		this.autoFocus = autoFocus;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setMenuMaxHeight(String menuMaxHeight) {
		this.menuMaxHeight = menuMaxHeight;
	}

	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}

}
