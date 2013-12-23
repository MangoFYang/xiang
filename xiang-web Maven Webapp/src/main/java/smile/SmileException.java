package smile;

public class SmileException extends RuntimeException {

	private static final long serialVersionUID = -4603036088721775008L;

	public SmileException() {
		super();
	}

	public SmileException(String message) {
		super(message);
	}

	public SmileException(String message, Throwable cause) {
		super(message, cause);
	}

	public SmileException(Throwable cause) {
		super(cause);
	}
	
}
