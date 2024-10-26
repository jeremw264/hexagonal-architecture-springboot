package com.jeremw.hexagonal.adapter.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class handles global exceptions in the application, such as unexpected errors.
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Slf4j
@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {
    /**
     * Handles unknown errors that occur within the application.
     *
     * @param req       The HttpServletRequest in which the error occurred.
     * @param exception The Exception that was thrown.
     * @return A ResponseEntity containing details of the error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApplicationExceptionDTO> unknownError(HttpServletRequest req, Exception exception) {

        log.warn("An unknown error occurred. Request URL: {}", req.getRequestURL().toString(), exception);

        ApplicationExceptionDTO res = ApplicationExceptionDTO.builder()
                .errorMessage(exception.getMessage())
                .requestURL(req.getRequestURL().toString())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }

}
