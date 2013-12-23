package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.ODialog;
import smile.views.jstl.ui.AbstractUIBeanTag;

/**
 * 
 * @author 杨帆
 *
 */
public class ODialogTag extends AbstractUIBeanTag {

	private static final long serialVersionUID = 1608316144418484581L;
	
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
	public Component getBean() {
		return new ODialog();
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		ODialog odialog = (ODialog) this.component;
		odialog.setUrl(url);
		odialog.setEmbedType(embedType);
		odialog.setAutoOpen(autoOpen);
		odialog.setCloseOnEscape(closeOnEscape);
		odialog.setDraggable(draggable);
		odialog.setHeight(height);
		odialog.setMaxHeight(maxHeight);
		odialog.setMaxWidth(maxWidth);
		odialog.setMinHeight(minHeight);
		odialog.setMinWidth(minWidth);
		odialog.setModal(modal);
		odialog.setResizable(resizable);
		odialog.setStack(stack);
		odialog.setTitle(title);
		odialog.setWidth(width);
		odialog.setzIndex(zIndex);
		odialog.setData(data);
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
