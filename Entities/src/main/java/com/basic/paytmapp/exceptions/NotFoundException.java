package com.basic.paytmapp.exceptions;

public class NotFoundException extends RuntimeException {
    public  NotFoundException(String message)
    {
        super(message);
    }
}
