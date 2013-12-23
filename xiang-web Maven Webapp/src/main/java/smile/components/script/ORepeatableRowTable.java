package smile.components.script;

public class ORepeatableRowTable extends OTable {
	
    public static final String TEMPLATE = "orepeatablerowtable";
	public static final String TEMPLATE_CLOSE = "orepeatablerowtable-close";
	
	protected String data;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(data != null) {
			this.addParameter("data", data);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
