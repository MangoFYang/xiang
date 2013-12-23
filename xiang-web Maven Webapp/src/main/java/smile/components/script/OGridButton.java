package smile.components.script;

import smile.components.AbstractUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class OGridButton extends AbstractUIBean {
	
	/**
	 * OGridTag默认的模板名
	 */
	public static final String TEMPLATE = "ogridbutton";
	
	protected String click;
	protected String label;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(label != null) {
			this.addParameter("label", label);
		}
		if(click != null) {
			this.addParameter("click", click);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
