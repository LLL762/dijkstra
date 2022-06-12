package app.exception;

public class NoVertexFoundException extends RuntimeException {

	private static final long serialVersionUID = 5255608351219021914L;

	public NoVertexFoundException() {
		super();

	}

	public NoVertexFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public NoVertexFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public NoVertexFoundException(String message) {
		super(message);

	}

	public NoVertexFoundException(Throwable cause) {
		super(cause);

	}

}
