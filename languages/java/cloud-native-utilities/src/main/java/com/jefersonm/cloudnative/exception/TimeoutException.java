package com.jefersonm.cloudnative.exception;

public class TimeoutException extends RuntimeException {

    public TimeoutException(String message) {
        super(message);
    }

}
