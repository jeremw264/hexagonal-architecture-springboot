package com.jeremw.hexagonal.exception;

/**
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
public class BookNotFound extends RuntimeException {
    public BookNotFound(String message) {
        super(message);
    }
}
