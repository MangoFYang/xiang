package smile.views.model;

public class Result {
	
	private Object extra;
	
	private String message;
	
	private boolean result;

	public String getClassName() {
		return this.getClass().getName();
	}

	public Object getExtra() {
		return extra;
	}

	public String getMessage() {
		return message;
	}

	public boolean isResult() {
		return result;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}

}
