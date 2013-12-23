package smile.components.script;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractSingleBox extends AbstractList4Input {
	
	protected String odialogHeight;
	protected String odialogWidth;
	protected String title;
	protected String clear;
	
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
		if(clear != null) {
			this.addParameter("clear", clear);
		}
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