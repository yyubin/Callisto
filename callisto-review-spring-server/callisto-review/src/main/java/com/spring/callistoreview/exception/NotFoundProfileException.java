package com.spring.callistoreview.exception;

public class NotFoundProfileException extends RuntimeException{

    public NotFoundProfileException() {
        super();
    }

    public NotFoundProfileException(String message) {
        super(message);
    }

    public NotFoundProfileException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundProfileException(Throwable cause) {
        super(cause);
    }

    protected NotFoundProfileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
