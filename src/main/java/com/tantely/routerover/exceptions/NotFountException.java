package com.tantely.routerover.exceptions;

public class NotFountException extends RuntimeException {
    public NotFountException(String message) {
        super(message);
    }

    public NotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
