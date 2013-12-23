package smile.components.script;


/**
 * 
 * @author 杨帆
 *
 */
public class OList extends AbstractBaseList {
	
	/**
	 * OListTag默认的模板名
	 */
	public static final String TEMPLATE = "olist";
	
	protected String autoRefresh;
	protected String value;
	protected String valueSeparator;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(value != null) {
			this.addParameter("value", value);
		}
		if(valueSeparator != null) {
			this.addParameter("valueSeparator", valueSeparator);
		}
		if(autoRefresh != null) {
			this.addParameter("autoRefresh", autoRefresh);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setAutoRefresh(String autoRefresh) {
		this.autoRefresh = autoRefresh;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setValueSeparator(String valueSeparator) {
		this.valueSeparator = valueSeparator;
	}

}