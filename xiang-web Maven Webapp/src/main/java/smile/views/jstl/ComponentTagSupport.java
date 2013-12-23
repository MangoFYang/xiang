package smile.views.jstl;

import javax.servlet.jsp.JspException;

import smile.components.Component;

/**
 * 
 * Smile标签库的基类。
 * 一个标签包括一个Tag类和一个Component类
 * 
 * @author 杨帆
 *
 */
public abstract class ComponentTagSupport extends SmileBodyTagSupport {

	private static final long serialVersionUID = 7400450079474415353L;
	
	protected Component component;
	
	public int doEndTag() throws JspException {
        component.end(pageContext.getOut(), getBody());
        component = null;
        return EVAL_PAGE;
    }
	
    public int doStartTag() throws JspException {
        this.component = this.getBean();

        // 将页面上接收来的属性-值拷贝到Component中
        this.populateParams();
        // 返回值表示，需要处理标签体吗?
        // true表示需要标签体，false表示跳过标签体。
        boolean evalBody = this.component.start(pageContext.getOut());

        if (evalBody) {
            return this.component.usesBody() ? EVAL_BODY_BUFFERED : EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }

    public abstract Component getBean();

    public Component getComponent() {
        return component;
    }

    /**
     * 将JSP中传来的属性-值拷贝到Component中
     */
    protected void populateParams() {
    }
    
}
