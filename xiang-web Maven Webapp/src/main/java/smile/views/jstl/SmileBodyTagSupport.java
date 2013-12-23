package smile.views.jstl;

import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 
 * @author 杨帆
 *
 */
public class SmileBodyTagSupport extends BodyTagSupport {

	private static final long serialVersionUID = 6713619647548229769L;
	
    protected String getBody() {
        if (bodyContent == null) {
            return "";
        } else {
            return bodyContent.getString().trim();
        }
    }

}
