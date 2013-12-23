package smile.views.jstl.ui.script;

import smile.components.script.AbstractList4ExcludeInput;
import smile.views.jstl.ui.AbstractUIBeanTag;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractList4ExcludeInputTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 2619660498702582184L;
	
	// 数据变量
	protected String data;
	// 显示域，用户看。
	protected String displayField;
	protected String height;
	// 值域，提交后台。
	protected String valueField;
	protected String width;
	
	@Override
	protected void populateParams() {
		super.populateParams();
		AbstractList4ExcludeInput list4ExcludeInput = (AbstractList4ExcludeInput) this.component;
		list4ExcludeInput.setData(data);
		list4ExcludeInput.setDisplayField(displayField);
		list4ExcludeInput.setValueField(valueField);
		list4ExcludeInput.setWidth(width);
		list4ExcludeInput.setHeight(height);
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public void setWidth(String width) {
		this.width = width;
	}

}
