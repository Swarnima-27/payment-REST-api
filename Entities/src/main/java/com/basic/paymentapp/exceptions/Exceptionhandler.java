package com.basic.paymentapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class Exceptionhandler {

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception)
    {
        ErrorMessage error=new ErrorMessage(new Timestamp(System.currentTimeMillis()), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value=AlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleAlreadyExistsException(Exception exception)
    {
        ErrorMessage error=new ErrorMessage(new Timestamp(System.currentTimeMillis()), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value=EmptyInputException.class)
    public ResponseEntity<ErrorMessage> handleEmptyInputException(Exception exception)
    {
        ErrorMessage error=new ErrorMessage(new Timestamp(System.currentTimeMillis()), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value=NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(Exception exception)
    {
        ErrorMessage error=new ErrorMessage(new Timestamp(System.currentTimeMillis()), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value=NotValidException.class)
    public ResponseEntity<ErrorMessage> handleNotValidException(Exception exception)
    {
        ErrorMessage error=new ErrorMessage(new Timestamp(System.currentTimeMillis()), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=TransactionFailedException.class)
    public ResponseEntity<ErrorMessage> handleTransactionFailedException(Exception exception)
    {
        ErrorMessage error=new ErrorMessage(new Timestamp(System.currentTimeMillis()), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }

}
