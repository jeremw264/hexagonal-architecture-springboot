package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.domain.Book;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller interface for managing books.
 * <p>
 * This interface defines the REST API for managing books, including operations
 * to retrieve, create, update, and delete books.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@RestController
@RequestMapping("/books")
public interface BookController {

    /**
     * Retrieves a list of all books.
     *
     * @return ResponseEntity containing a list of books and HTTP status code.
     */
    @Operation(summary = "Get all books", description = "Retrieve a list of all books.")
    @GetMapping
    ResponseEntity<List<Book>> getBooks();

    /**
     * Retrieves a book by its ID.
     *
     * @param bookId the ID of the book to retrieve.
     * @return ResponseEntity containing the requested book.
     */
    @Operation(summary = "Get book by ID", description = "Retrieve a book by its ID.")
    @GetMapping("/{bookId}")
    ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId);

    /**
     * Retrieves a book by its title.
     *
     * @param title the title of the book to retrieve.
     * @return ResponseEntity containing the requested book.
     */
    @Operation(summary = "Get book by title", description = "Retrieve a book by its title.")
    @GetMapping("/title/{title}")
    ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title);

    /**
     * Creates a new book.
     *
     * @param book the book object to create
     * @return ResponseEntity containing the created book.
     */
    @Operation(summary = "Create a new book", description = "Create a new book.")
    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody Book book);

    /**
     * Updates an existing book by its ID.
     *
     * @param bookId the ID of the book to update
     * @param book   the updated book object
     * @return ResponseEntity containing the updated book.
     */
    @Operation(summary = "Update a book", description = "Update an existing book by its ID.")
    @PutMapping("/{bookId}")
    ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book);

    /**
     * Deletes a book by its ID.
     *
     * @param bookId the ID of the book to delete
     * @return ResponseEntity with HTTP status code indicating the result.
     */
    @Operation(summary = "Delete a book", description = "Delete a book by its ID.")
    @DeleteMapping("/{bookId}")
    ResponseEntity<Void> deleteBookById(@PathVariable("bookId") Long bookId);
}
