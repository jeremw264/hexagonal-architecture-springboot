package com.jeremw.hexagonal.ports.input;

import com.jeremw.hexagonal.domain.Book;

import java.util.List;

/**
 * This interface defines the contract for a service that manages book-related operations.
 * It provides methods for retrieving, creating, updating, and deleting book.
 * <p>
 * Implementations of this interface will contain the business logic related to book management.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
public interface BookService {

    /**
     * Retrieves all books from the service.
     *
     * @return a list of all available books.
     */
    List<Book> getAllBooks();

    /**
     * Retrieves a book by its unique identifier.
     *
     * @param bookId the unique identifier of the book to be retrieved.
     * @return the found book, or null if no book is found with the given ID.
     */
    Book getBookById(Long bookId);

    /**
     * Retrieves a book by its title.
     *
     * @param title the title of the book to search for.
     * @return the found book, or null if no book is found with the given title.
     */
    Book getBookByTitle(String title);

    /**
     * Creates a new book in the service.
     *
     * @param book the book entity to be created.
     * @return the created book entity, which may contain an updated ID if generated.
     */
    Book createBook(Book book);

    /**
     * Updates an existing book identified by its unique identifier.
     *
     * @param bookId the unique identifier of the book to be updated.
     * @param book   the updated book entity.
     * @return the updated book entity.
     */
    Book updateBook(Long bookId, Book book);

    /**
     * Deletes a book identified by its unique identifier.
     *
     * @param bookId the unique identifier of the book to be deleted.
     */
    void deleteBookById(Long bookId);
}