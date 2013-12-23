package smile.views.jstl.ui.script;

import smile.components.script.AbstractList4Input;

/**
 * 
 * @author 杨帆
 *
 */
public abstract class AbstractList4InputTag extends OTriggerInputTag {

	private static final long serialVersionUID = -5749274135269666727L;
	
	// 数据源
	protected String data;
	// 显示域，用户看。
	protected String displayField;
	// 值域，提交后台。
	protected String valueField;

    protected void populateParams() {
        super.populateParams();
        AbstractList4Input list4Input = (AbstractList4Input) component;
		list4Input.setData(data);
		list4Input.setDisplayField(displayField);
		list4Input.setValueField(valueField);
    }

	public void setData(String data) {
		this.data = data;
	}

	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}
    
}
