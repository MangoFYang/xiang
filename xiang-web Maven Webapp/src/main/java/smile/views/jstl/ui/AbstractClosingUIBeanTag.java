package smile.views.jstl.ui;

import smile.components.AbstractClosingUIBean;

public abstract class AbstractClosingUIBeanTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 2155100412587869267L;
	
    protected String openTemplate;

    protected void populateParams() {
        super.populateParams();

        ((AbstractClosingUIBean) component).setOpenTemplate(openTemplate);
    }

    public void setOpenTemplate(String openTemplate) {
        this.openTemplate = openTemplate;
    }


}
