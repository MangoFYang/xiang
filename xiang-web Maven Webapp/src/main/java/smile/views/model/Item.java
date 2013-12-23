package smile.views.model;

/**
 * 
 * 
 * 
 * @author 杨帆
 *
 */
public class Item {
	
	protected String label;
	
	protected String value;

	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [label=").append(label).append(", value=")
				.append(value).append("]");
		return builder.toString();
	}
	
}
