package Data4;

public class MyException extends RuntimeException {
    public MyException() {
        super();
    }

    public MyException(final String message) {
        super(message);
    }

    public MyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyException(final Throwable cause) {
        super(cause);
    }

    protected MyException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
