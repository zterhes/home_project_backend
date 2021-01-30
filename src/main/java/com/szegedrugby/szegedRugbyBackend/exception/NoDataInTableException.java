package com.szegedrugby.szegedRugbyBackend.exception;

import org.springframework.http.HttpStatus;

public class NoDataInTableException extends NoDataException {
    public NoDataInTableException(String messege, HttpStatus httpStatus) {
        super(messege,httpStatus);
    }
}
