package exceptions;

public class NullPointerQueueElementException extends RuntimeException {
    public NullPointerQueueElementException() {
    }

    public NullPointerQueueElementException(String message) {
        super(message);
    }

    public NullPointerQueueElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPointerQueueElementException(Throwable cause) {
        super(cause);
    }

    public NullPointerQueueElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
