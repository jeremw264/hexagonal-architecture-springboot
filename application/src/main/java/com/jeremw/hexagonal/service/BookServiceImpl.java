package com.jeremw.hexagonal.service;

import com.jeremw.hexagonal.annotation.ServicePort;
import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.exception.BookNotFound;
import com.jeremw.hexagonal.ports.input.BookService;
import com.jeremw.hexagonal.ports.output.BookRepository;

import java.util.List;

/**
 * Implementation of the BookService interface.
 * <p>
 * This class provides the business logic for managing books, including operations
 * to retrieve, create, update, and delete books. It interacts with the
 * {@link BookRepository} to perform CRUD operations. This service is annotated
 * with {@code @ServicePort} to be recognized as a Spring bean.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@ServicePort
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * Constructs a new BookServiceImpl with the specified BookRepository.
     *
     * @param bookRepository the repository to be used for book operations
     */
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFound("Book not found with id: " + bookId));
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow(() -> new BookNotFound("Book not found with the title: " + title));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book bookToUpdate = getBookById(bookId);

        if (book.getTitle() != null)
            bookToUpdate.setTitle(book.getTitle());

        if (book.getAuthor() != null)
            bookToUpdate.setAuthor(book.getAuthor());

        return bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBookById(Long bookId) {
        Book bookToDelete = getBookById(bookId);
        bookRepository.delete(bookToDelete);
    }
}
