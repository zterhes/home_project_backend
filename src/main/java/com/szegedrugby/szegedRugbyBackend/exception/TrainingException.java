package com.szegedrugby.szegedRugbyBackend.exception;

import org.springframework.http.HttpStatus;

public class TrainingException extends Exception{
    HttpStatus httpStatus;


    public TrainingException(String message,HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }

    public TrainingException(String messsage){
        super(messsage);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
