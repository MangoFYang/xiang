package smile.components;

import java.io.Writer;

import smile.views.freemarker.FreemarkerManager;
import smile.views.freemarker.TemplateRenderingContext;

public abstract class AbstractClosingUIBean extends AbstractUIBean {

	protected String openTemplate;

    public abstract String getDefaultOpenTemplate();

    public void setOpenTemplate(String openTemplate) {
        this.openTemplate = openTemplate;
    }

    public boolean start(Writer writer) {
        boolean result = super.start(writer);
        try {
            evaluateParams();
            TemplateRenderingContext context = 
            		new TemplateRenderingContext(this.getDefaultOpenTemplate(), this.getParameters(), writer);
            FreemarkerManager.getInstance().renderTemplate(context);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
