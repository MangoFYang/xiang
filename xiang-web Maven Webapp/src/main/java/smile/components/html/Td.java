package smile.components.html;

import smile.components.AbstractClosingUIBean;

public class Td extends AbstractClosingUIBean {
	
    public static final String TEMPLATE = "td";
    public static final String TEMPLATE_CLOSE = "td-close";
    
    protected String colspan;
    protected String rowspan;
    protected String valign;
    protected String width;

	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(colspan != null) {
			this.addParameter("colspan", colspan);
		}
		if(rowspan != null) {
			this.addParameter("rowspan", rowspan);
		}
		if(valign != null) {
			this.addParameter("valign", valign);
		}
		if(width != null) {
			this.addParameter("width", width);
		}
	}

	@Override
	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
	}

	public void setValign(String valign) {
		this.valign = valign;
	}

	public void setWidth(String width) {
		this.width = width;
	}

}
