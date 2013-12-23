package smile.components.script;


public class OTextarea extends OTextField {
	
    /**
     * OTextareaTag默认的模板名
     */
    public static final String TEMPLATE = "otextarea";
    
    protected String height;
    
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(height != null) {
			this.addParameter("height", height);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setHeight(String height) {
		this.height = height;
	}

}
