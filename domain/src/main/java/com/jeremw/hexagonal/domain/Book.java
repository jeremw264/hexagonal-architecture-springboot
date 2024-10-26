package com.jeremw.hexagonal.domain;

import lombok.*;

/**
 * Represents a book in the system.
 * <p>
 * This class encapsulates the properties of a book, including its title and author.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 **/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    /**
     * The unique identifier of the book.
     */
    private long id;

    /**
     * The title of the book.
     */
    private String title;

    /**
     * The author of the book.
     */
    private String author;
}
