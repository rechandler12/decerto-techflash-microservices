package com.decerto.librarymanager.library.domain;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {
    private final Validator validator;

    <T> void validate(T command) {
        var constraintViolations = validator.validate(command);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
