package smile.components;

import java.io.Writer;
import java.util.Map;

import smile.SmileException;
import smile.support.Configurer;
import smile.views.freemarker.FreemarkerManager;
import smile.views.freemarker.TemplateRenderingContext;

/**
 * 
 * 所有UI标签的基类
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractUIBean extends Component {
	
	// 上下文根
	protected String contextPath;
    // dynamic attributes.
    protected Map<String, Object> dynamicAttributes;
	protected String id;
    protected String renderTo;
    protected String hidden;
    
    public boolean end(Writer writer, String body) {
        this.evaluateParams();
        try {
            super.end(writer, body);
			TemplateRenderingContext context = 
            		new TemplateRenderingContext(this.getDefaultTemplate(), this.getParameters(), writer);
            FreemarkerManager.getInstance().renderTemplate(context);
        } catch (Exception e) {
            throw new SmileException(e);
        }

        return false;
    }
    
	/**
     * 将Component中的属性全部添加到Map parameters中，用于ftl渲染。
     */
	protected void evaluateParams() {
		addParameter("dynamicAttributes", dynamicAttributes);
		
		if(contextPath != null) {
			this.addParameter("contextPath", contextPath);
		}
		if(id != null) {
			this.addParameter("id", id);
		}
		if(renderTo != null) {
			this.addParameter("renderTo", renderTo);
		}
		if(hidden != null) {
			this.addParameter("hidden", hidden);
		}
		this.addParameter("staticPath", 
				Configurer.getStaticPath() == null ? contextPath : Configurer.getStaticPath());
	}
    
    protected abstract String getDefaultTemplate();

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	public void setDynamicAttributes(Map<String, Object> dynamicAttributes) {
		this.dynamicAttributes = dynamicAttributes;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

}
