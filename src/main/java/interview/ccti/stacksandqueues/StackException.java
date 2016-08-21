package interview.ccti.stacksandqueues;

public class StackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackException() {
	}

	public StackException(String message) {
		super(message);
	}

	public StackException(Throwable cause) {
		super(cause);
	}

	public StackException(String message, Throwable cause) {
		super(message, cause);
	}

	public StackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
