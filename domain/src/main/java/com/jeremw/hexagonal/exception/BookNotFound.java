package com.jeremw.hexagonal.exception;

/**
 * Exception thrown when a book is not found in the system.
 * This exception indicates that a requested book could not be located.
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
public class BookNotFound extends RuntimeException {
    /**
     * Constructs a new {@code BookNotFound} exception with the specified detail message.
     *
     * @param message the detail message which is saved for later retrieval by the {@link Throwable#getMessage()} method.
     */
    public BookNotFound(String message) {
        super(message);
    }
}
