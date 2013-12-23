package smile.components.script;

import java.io.StringWriter;

import org.codehaus.jackson.map.ObjectMapper;

import smile.components.AbstractUIBean;

public class Output extends AbstractUIBean {
	
    /**
     * InputTag默认的模板名
     */
    public static final String TEMPLATE = "output";
    
	protected String var;
	
	protected Object value;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(var != null) {
			this.addParameter("var", var);
		}
		if(value != null) {
			StringWriter writer = new StringWriter();
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				objectMapper.writeValue(writer, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.addParameter("value", writer.toString());
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
