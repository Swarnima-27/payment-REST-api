package com.basic.paymentapp.exceptions;

public class NotValidException extends RuntimeException{
    public NotValidException(String message)
    {
        super(message);
    }
}
