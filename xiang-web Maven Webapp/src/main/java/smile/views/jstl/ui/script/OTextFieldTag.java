package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OTextField;
import smile.views.jstl.ui.AbstractUIBeanTag;

public class OTextFieldTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 3796341679452903899L;
	
	protected String disabled;
	protected String allowBlank;
	protected String autoValidation;
	protected String blankText;
	protected String hideLabel;
	
	protected String hidePreI;
	protected String hideSufI;
	protected String label;
	protected String labelAlign;
	protected String labelSeparator;
	protected String labelWidth;
	protected String preIText;
	protected String preIWidth;
	protected String readOnly;
	
	protected String starCls;
	protected String starText;
	protected String starWidth;
	protected String sufIText;
	protected String sufIWidth;
	protected String validateEvent;
	protected String validator;
	protected String value;
	protected String vtype;
	protected String vtypeAlias;
	protected String width;

	@Override
	public Component getBean() {
		return new OTextField();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		OTextField otextField = (OTextField) this.component;
		
		otextField.setDisabled(disabled);
		otextField.setLabel(label);
		otextField.setHideLabel(hideLabel);
		otextField.setLabelSeparator(labelSeparator);
		otextField.setLabelAlign(labelAlign);
		
		otextField.setLabelWidth(labelWidth);
		otextField.setStarText(starText);
		otextField.setStarCls(starCls);
		otextField.setStarWidth(starWidth);
		otextField.setPreIText(preIText);
		otextField.setHidePreI(hidePreI);
		otextField.setPreIWidth(preIWidth);
		otextField.setSufIText(sufIText);
		otextField.setHideSufI(hideSufI);
		
		otextField.setSufIWidth(sufIWidth);
		otextField.setWidth(width);
		otextField.setValue(value);
		otextField.setReadOnly(readOnly);
		otextField.setAutoValidation(autoValidation);
		otextField.setValidator(validator);
		otextField.setVtype(vtype);
		otextField.setVtypeAlias(vtypeAlias);
		otextField.setAllowBlank(allowBlank);
		otextField.setBlankText(blankText);
		otextField.setValidateEvent(validateEvent);
	}

	public void setAllowBlank(String allowBlank) {
		this.allowBlank = allowBlank;
	}

	public void setAutoValidation(String autoValidation) {
		this.autoValidation = autoValidation;
	}

	public void setBlankText(String blankText) {
		this.blankText = blankText;
	}

	public void setHideLabel(String hideLabel) {
		this.hideLabel = hideLabel;
	}

	public void setHidePreI(String hidePreI) {
		this.hidePreI = hidePreI;
	}

	public void setHideSufI(String hideSufI) {
		this.hideSufI = hideSufI;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setLabelAlign(String labelAlign) {
		this.labelAlign = labelAlign;
	}

	public void setLabelSeparator(String labelSeparator) {
		this.labelSeparator = labelSeparator;
	}

	public void setLabelWidth(String labelWidth) {
		this.labelWidth = labelWidth;
	}

	public void setPreIText(String preIText) {
		this.preIText = preIText;
	}

	public void setPreIWidth(String preIWidth) {
		this.preIWidth = preIWidth;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public void setStarCls(String starCls) {
		this.starCls = starCls;
	}

	public void setStarText(String starText) {
		this.starText = starText;
	}

	public void setStarWidth(String starWidth) {
		this.starWidth = starWidth;
	}

	public void setSufIText(String sufIText) {
		this.sufIText = sufIText;
	}

	public void setSufIWidth(String sufIWidth) {
		this.sufIWidth = sufIWidth;
	}

	public void setValidateEvent(String validateEvent) {
		this.validateEvent = validateEvent;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setVtypeAlias(String vtypeAlias) {
		this.vtypeAlias = vtypeAlias;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

}
