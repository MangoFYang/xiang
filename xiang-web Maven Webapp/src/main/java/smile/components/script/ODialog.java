package smile.components.script;

import smile.components.AbstractUIBean;

/**
 * 
 * @author 杨帆
 *
 */
public class ODialog extends AbstractUIBean {
	
	public static final String TEMPLATE = "odialog";
	
	protected String autoOpen;
	protected String closeOnEscape;
	
	protected String draggable;
	protected String embedType;
	protected String height;
	protected String maxHeight;
	protected String maxWidth;
	protected String minHeight;
	protected String minWidth;
	protected String modal;
	protected String resizable;
	protected String stack;
	protected String title;
	protected String url;
	protected String width;
	protected String zIndex;
	protected String data;
	
	@Override
	protected void evaluateParams() {
		super.evaluateParams();
		if(url != null) {
			this.addParameter("url", url);
		}
		if(embedType != null) {
			this.addParameter("embedType", embedType);
		}
		if(closeOnEscape != null) {
			this.addParameter("closeOnEscape", closeOnEscape);
		}
		if(resizable != null) {
			this.addParameter("resizable", resizable);
		}
		if(draggable != null) {
			this.addParameter("draggable", draggable);
		}
		if(autoOpen != null) {
			this.addParameter("autoOpen", autoOpen);
		}
		if(width != null) {
			this.addParameter("width", width);
		}
		if(height != null) {
			this.addParameter("height", height);
		}
		if(minWidth != null) {
			this.addParameter("minWidth", minWidth);
		}
		if(minHeight != null) {
			this.addParameter("minHeight", minHeight);
		}
		if(maxWidth != null) {
			this.addParameter("maxWidth", maxWidth);
		}
		if(maxHeight != null) {
			this.addParameter("maxHeight", maxHeight);
		}
		if(modal != null) {
			this.addParameter("modal", modal);
		}
		if(stack != null) {
			this.addParameter("stack", stack);
		}
		if(title != null) {
			this.addParameter("title", title);
		}
		if(zIndex != null) {
			this.addParameter("zIndex", zIndex);
		}
		if(data != null) {
			this.addParameter("data", data);
		}
	}
	
	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}
	
	public void setAutoOpen(String autoOpen) {
		this.autoOpen = autoOpen;
	}

	public void setCloseOnEscape(String closeOnEscape) {
		this.closeOnEscape = closeOnEscape;
	}

	public void setDraggable(String draggable) {
		this.draggable = draggable;
	}

	public void setEmbedType(String embedType) {
		this.embedType = embedType;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}

	public void setMaxWidth(String maxWidth) {
		this.maxWidth = maxWidth;
	}

	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}

	public void setMinWidth(String minWidth) {
		this.minWidth = minWidth;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

	public void setResizable(String resizable) {
		this.resizable = resizable;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setzIndex(String zIndex) {
		this.zIndex = zIndex;
	}

	public void setData(String data) {
		this.data = data;
	}

}
