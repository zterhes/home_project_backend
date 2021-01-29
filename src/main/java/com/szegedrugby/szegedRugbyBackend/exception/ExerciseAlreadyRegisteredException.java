package com.szegedrugby.szegedRugbyBackend.exception;

import org.springframework.http.HttpStatus;

public class ExerciseAlreadyRegisteredException extends TrainingException {
    public ExerciseAlreadyRegisteredException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
