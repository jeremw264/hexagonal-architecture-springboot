package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.adapter.exception.ApplicationException;
import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.exception.BookNotFound;
import com.jeremw.hexagonal.ports.input.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Component
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Override
    public ResponseEntity<Book> getBookById(final Long bookId) {
        Book book = null;
        try {
            book = bookService.getBookById(bookId);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), "BookNotFoundException", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<Book> getBookByTitle(final String title) {
        Book book = null;
        try {
            book = bookService.getBookByTitle(title);
        } catch (BookNotFound e) {
            throw new ApplicationException(e.getMessage(), "BookNotFoundException", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<Book> createBook(final Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }

    @Override
    public ResponseEntity<Book> updateBook(final Long bookId, final Book book) {
        Book updatedBook = null;
        try {
            updatedBook = bookService.updateBook(bookId, book);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), "BookNotFoundException", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedBook);
    }

    @Override
    public ResponseEntity<Void> deleteBookById(final Long bookId) {
        try {
            bookService.deleteBookById(bookId);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), "BookNotFoundException", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }
}
