package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OPageableList;

/**
 * 
 * @author 杨帆
 *
 */
public class OPageableListTag extends AbstractBaseListTag {
	
	private static final long serialVersionUID = -6940277852443226558L;
	
	protected String size;
	protected String ptext;
	protected String btext;
	
	@Override
	public Component getBean() {
		return new OPageableList();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OPageableList opageablelist = (OPageableList) component;
		opageablelist.setSize(size);
		opageablelist.setPtext(ptext);
		opageablelist.setBtext(btext);
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPtext(String ptext) {
		this.ptext = ptext;
	}

	public void setBtext(String btext) {
		this.btext = btext;
	}

}