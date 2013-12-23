package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OButton;
import smile.views.jstl.ui.AbstractUIBeanTag;

/**
 * 
 * @author 杨帆
 *
 */
/**
 * @author fange
 *
 */
public class OButtonTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 2043003446082000307L;
	
    protected String disabled;
    protected String primaryIcon;
    protected String secondaryIcon;
    protected String text;
    protected String click;
	
	@Override
	public Component getBean() {
		return new OButton();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OButton obutton = (OButton) this.component;
		obutton.setDisabled(disabled);
		obutton.setText(text);
		obutton.setPrimaryIcon(primaryIcon);
		obutton.setSecondaryIcon(secondaryIcon);
		obutton.setClick(click);
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setPrimaryIcon(String primaryIcon) {
		this.primaryIcon = primaryIcon;
	}

	public void setSecondaryIcon(String secondaryIcon) {
		this.secondaryIcon = secondaryIcon;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setClick(String click) {
		this.click = click;
	}

}
