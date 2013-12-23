package smile.views.jstl.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;

import smile.components.AbstractUIBean;
import smile.views.jstl.ComponentTagSupport;

/**
 * 抽象的UI组件
 * 具有设置动态属性的能力
 * 
 * 设置id、dynamicAttributes、renderTo。
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractUIBeanTag extends ComponentTagSupport implements DynamicAttributes {

	private static final long serialVersionUID = 7650505516880802353L;
	
	// 动态属性。
    protected Map<String, Object> dynamicAttributes = new HashMap<String, Object>();
	
    protected String renderTo;
    protected String hidden;

    @Override
	protected void populateParams() {
		super.populateParams();
		AbstractUIBean uiBean = (AbstractUIBean) component;
		uiBean.setContextPath(this.pageContext.getServletContext().getContextPath());
		uiBean.setId(id);
		uiBean.setRenderTo(renderTo);
		uiBean.setHidden(hidden);
		uiBean.setDynamicAttributes(dynamicAttributes);
	}

	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if (value != null && value instanceof String) {
            dynamicAttributes.put(localName, value);
        } else {
            dynamicAttributes.put(localName, value);
        }
    }

	public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

}
