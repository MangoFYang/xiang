package smile.components.script;


/**
 * 
 * @author 杨帆
 *
 */
public class OListSelectSingle extends AbstractSingleBox {
	
    /**
     * OListSelectTag默认的模板名
     */
    public static final String TEMPLATE = "olistselectsingle";
    
    protected String select;
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(select != null) {
			this.addParameter("select", select);
		}
	}
	
	public void setSelect(String select) {
		this.select = select;
	}

}