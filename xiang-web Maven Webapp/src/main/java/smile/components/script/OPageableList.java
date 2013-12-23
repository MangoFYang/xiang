package smile.components.script;


/**
 * 
 * @author 杨帆
 *
 */
public class OPageableList extends AbstractBaseList {
	
	/**
	 * OListTag默认的模板名
	 */
	public static final String TEMPLATE = "opageablelist";
	
	protected String size;
	protected String ptext;
	protected String btext;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(size != null) {
			this.addParameter("size", size);
		}
		if(ptext != null) {
			this.addParameter("ptext", ptext);
		}
		if(btext != null) {
			this.addParameter("btext", btext);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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