package com.jeremw.hexagonal.adapter.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * This exception class represents resource-related errors that may occur within the application.
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Getter
public class ApplicationException extends RuntimeException {
    /**
     * The unique identifier for the type of error.
     */
    private final String errorCode;

    /**
     * The HTTP status associated with the exception.
     */
    private final HttpStatus status;

    public ApplicationException(String message, String errorCode, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
