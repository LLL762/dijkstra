package app.exception;

/**
 * 10/06/2022.
 *
 * @author Laurent Lamiral
 */
public class NoPathExist extends RuntimeException {

    public NoPathExist() {
    }

    public NoPathExist(String message) {
        super(message);
    }

    public NoPathExist(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPathExist(Throwable cause) {
        super(cause);
    }

    public NoPathExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
