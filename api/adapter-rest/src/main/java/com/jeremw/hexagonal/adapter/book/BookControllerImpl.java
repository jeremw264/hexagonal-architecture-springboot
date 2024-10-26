package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.ports.input.BookService;
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
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<Book> getBookByTitle(final String title) {
        Book book = bookService.getBookByTitle(title);
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<Book> createBook(final Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }

    @Override
    public ResponseEntity<Book> updateBook(final Long bookId, final Book book) {
        Book updatedBook = bookService.updateBook(bookId, book);
        return ResponseEntity.ok(updatedBook);
    }

    @Override
    public ResponseEntity<Void> deleteBookById(final Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.noContent().build();
    }
}
