package com.szegedrugby.szegedRugbyBackend.exception;

import org.springframework.http.HttpStatus;

public class PlanAlreadyRegisteredException extends TrainingException {
    public PlanAlreadyRegisteredException(String messege) {
        super(messege, HttpStatus.CONFLICT);
    }
}
