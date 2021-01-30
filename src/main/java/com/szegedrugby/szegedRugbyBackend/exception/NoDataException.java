package com.szegedrugby.szegedRugbyBackend.exception;

import org.springframework.http.HttpStatus;

public class NoDataException extends Exception{
    HttpStatus httpStatus;

    public NoDataException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
