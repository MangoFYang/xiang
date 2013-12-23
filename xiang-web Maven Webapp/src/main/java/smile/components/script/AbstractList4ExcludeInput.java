package smile.components.script;

import smile.components.AbstractUIBean;

/**
 * 基于div、ul等其他的需要翻译功能的组件基类。
 * 一般向服务器提交的值和显示的值不一样，如：字典，这类组件称为翻译类组件。
 * 并且这类组件需要用户提供数据源。
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractList4ExcludeInput extends AbstractUIBean {
	
	// 数据变量
	protected String data;
	// 显示域，用户看。
	protected String displayField;
	// 值域，提交后台。
	protected String valueField;
	
	protected String width;
	protected String height;
	
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(data != null) {
			this.addParameter("data", data);
		}
		if(displayField != null) {
			this.addParameter("displayField", displayField);
		}
		if(valueField != null) {
			this.addParameter("valueField", valueField);
		}
		if(width != null) {
			this.addParameter("width", width);
		}
		if(height != null) {
			this.addParameter("height", height);
		}
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
