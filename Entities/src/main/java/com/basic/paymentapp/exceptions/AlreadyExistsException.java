package com.basic.paymentapp.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message)
    {
        super(message);
    }
}
