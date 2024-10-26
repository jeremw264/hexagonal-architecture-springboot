package com.jeremw.hexagonal.ports.input;

import com.jeremw.hexagonal.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book getBookByTitle(String title);

    Book createBook(Book book);

    Book updateBook(Long bookId, Book book);

    void deleteBookById(Long bookId);
}
