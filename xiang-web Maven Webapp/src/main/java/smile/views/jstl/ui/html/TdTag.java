package smile.views.jstl.ui.html;

import smile.components.Component;
import smile.components.html.Td;
import smile.views.jstl.ui.AbstractClosingUIBeanTag;

public class TdTag extends AbstractClosingUIBeanTag {

	private static final long serialVersionUID = 1420176575283053094L;
	
    protected String colspan;
    protected String rowspan;
    protected String valign;
    protected String width;

	@Override
	public Component getBean() {
		return new Td();
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Td bean = (Td) component;
		bean.setColspan(colspan);
		bean.setRowspan(rowspan);
		bean.setValign(valign);
		bean.setWidth(width);
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
