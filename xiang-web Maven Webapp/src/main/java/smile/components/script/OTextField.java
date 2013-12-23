package smile.components.script;

import smile.components.AbstractUIBean;

public class OTextField extends AbstractUIBean {
	
    /**
     * InputTag默认的模板名
     */
    public static final String TEMPLATE = "otextfield";
    
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
	protected void evaluateParams() {
		super.evaluateParams();
		if(disabled != null) {
			this.addParameter("disabled", disabled);
		}
		if(label != null) {
			this.addParameter("label", label);
		}
		if(hideLabel != null) {
			this.addParameter("hideLabel", hideLabel);
		}
		if(labelSeparator != null) {
			this.addParameter("labelSeparator", labelSeparator);
		}
		if(labelAlign != null) {
			this.addParameter("labelAlign", labelAlign);
		}
		
		if(labelWidth != null) {
			this.addParameter("labelWidth", labelWidth);
		}
		if(starText != null) {
			this.addParameter("starText", starText);
		}
		if(starCls != null) {
			this.addParameter("starCls", starCls);
		}
		if(starWidth != null) {
			this.addParameter("starWidth", starWidth);
		}
		if(preIText != null) {
			this.addParameter("preIText", preIText);
		}
		if(hidePreI != null) {
			this.addParameter("hidePreI", hidePreI);
		}
		if(preIWidth != null) {
			this.addParameter("preIWidth", preIWidth);
		}
		if(sufIText != null) {
			this.addParameter("sufIText", sufIText);
		}
		if(hideSufI != null) {
			this.addParameter("hideSufI", hideSufI);
		}
		
		if(sufIWidth != null) {
			this.addParameter("sufIWidth", sufIWidth);
		}
		if(width != null) {
			this.addParameter("width", width);
		}
		if(value != null) {
			this.addParameter("value", value);
		}
		if(readOnly != null) {
			this.addParameter("readOnly", readOnly);
		}
		if(autoValidation != null) {
			this.addParameter("autoValidation", autoValidation);
		}
		if(validator != null) {
			this.addParameter("validator", validator);
		}
		if(vtype != null) {
			this.addParameter("vtype", vtype);
		}
		if(vtypeAlias != null) {
			this.addParameter("vtypeAlias", vtypeAlias);
		}
		if(allowBlank != null) {
			this.addParameter("allowBlank", allowBlank);
		}
		if(blankText != null) {
			this.addParameter("blankText", blankText);
		}
		if(validateEvent != null) {
			this.addParameter("validateEvent", validateEvent);
		}
		
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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
